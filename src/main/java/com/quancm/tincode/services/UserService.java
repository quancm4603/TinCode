package com.quancm.tincode.services;

/**
 *
 * @author caomi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quancm.tincode.models.User;

public class UserService {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/tincode"; // Thay đổi URL của cơ sở dữ liệu của bạn
    private final String jdbcUsername = "root"; // Thay đổi username của cơ sở dữ liệu của bạn
    private final String jdbcPassword = "123456"; // Thay đổi mật khẩu của cơ sở dữ liệu của bạn

    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

    public UserService() {
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

    // Xác thực người dùng từ cơ sở dữ liệu
    public User authenticateUser(String username, String password) throws SQLException {
        User user = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                // So sánh password nhập vào với password trong database
                if (password.equals(dbPassword)) {
                    int id = rs.getInt("id");
                    user = new User(id, username, password);
                }
            }
        }
        return user;
    }

}
