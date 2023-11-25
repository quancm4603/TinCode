package com.quancm.tincode.services;

/**
 *
 * @author caomi
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.quancm.tincode.models.Word;

public class WordService {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/tincode"; // Thay đổi URL của cơ sở dữ liệu của bạn
    private final String jdbcUsername = "root"; // Thay đổi username của cơ sở dữ liệu của bạn
    private final String jdbcPassword = "123456"; // Thay đổi mật khẩu của cơ sở dữ liệu của bạn

    private static final String INSERT_WORD_SQL = "INSERT INTO words (word, definition, original, example) VALUES (?, ?, ?, ?)";
    private static final String SELECT_WORD_BY_ID = "SELECT * FROM words WHERE id = ?";
    private static final String SELECT_ALL_WORDS = "SELECT * FROM words";
    private static final String DELETE_WORD_SQL = "DELETE FROM words WHERE id = ?";
    private static final String UPDATE_WORD_SQL = "UPDATE words SET word = ?, definition = ?, original = ?, example = ? WHERE id = ?";

    public WordService() {
    }

    // Tạo kết nối đến cơ sở dữ liệu
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Thêm một từ vào cơ sở dữ liệu và trả về ID của từ vừa được thêm vào
    public int addWord(Word word) throws SQLException {
        int generatedId = -1; // Initialize with an invalid ID

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORD_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, word.getWord());
            preparedStatement.setString(2, word.getDefinition());
            preparedStatement.setString(3, word.getOriginal());
            preparedStatement.setString(4, word.getExample());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated ID of the inserted word
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        }
        return generatedId;
    }

    // Lấy một từ từ cơ sở dữ liệu dựa trên ID
    public Word getWordById(int id) throws SQLException {
        Word word = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WORD_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String retrievedWord = rs.getString("word");
                String definition = rs.getString("definition");
                String original = rs.getString("original");
                String example = rs.getString("example");
                word = new Word(id, retrievedWord, definition, original, example);
            }
        }
        return word;
    }

    // Lấy danh sách từ từ cơ sở dữ liệu dựa trên từ khóa
    public List<Word> getWordByKeyword(String keyword) throws SQLException {
        List<Word> words = new ArrayList<>();
        String searchQuery = "SELECT * FROM words WHERE word LIKE ? OR definition LIKE ? OR original LIKE ? OR example LIKE ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            String searchParam = "%" + keyword + "%";
            for (int i = 1; i <= 4; i++) {
                preparedStatement.setString(i, searchParam);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String word = rs.getString("word");
                String definition = rs.getString("definition");
                String original = rs.getString("original");
                String example = rs.getString("example");
                words.add(new Word(id, word, definition, original, example));
            }
        }
        return words;
    }

    // Lấy danh sách tất cả các từ từ cơ sở dữ liệu
    public List<Word> getAllWords() throws SQLException {
        List<Word> words = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WORDS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String word = rs.getString("word");
                String definition = rs.getString("definition");
                String original = rs.getString("original");
                String example = rs.getString("example");
                words.add(new Word(id, word, definition, original, example));
            }
        }
        return words;
    }

    // Xóa một từ từ cơ sở dữ liệu
    public boolean deleteWord(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_WORD_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Cập nhật thông tin một từ trong cơ sở dữ liệu
    public boolean updateWord(Word word) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_WORD_SQL)) {
            statement.setString(1, word.getWord());
            statement.setString(2, word.getDefinition());
            statement.setString(3, word.getOriginal());
            statement.setString(4, word.getExample());
            statement.setInt(5, word.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
