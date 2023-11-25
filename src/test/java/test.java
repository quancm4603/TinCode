
import com.quancm.tincode.models.Word;
import com.quancm.tincode.services.UserService;
import com.quancm.tincode.services.UserServiceSingleton;
import com.quancm.tincode.services.WordService;
import com.quancm.tincode.services.WordServiceSingleton;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author caomi
 */
public class test {
    
    public static void main(String[] args) throws SQLException {
        WordService wordService = WordServiceSingleton.getInstance();
        Word word = new Word();
        word.setWord("1 xị");
        word.setDefinition("100 nghìn đồng");
        word.setOriginal("Internet");
        word.setOriginal("https://quancm4603.github.io/TeenDictFrontend/");
        word.setExample("Cho tôi 1 xị");
        
        System.out.println(wordService.addWord(word));
        
        
        
    }
    
}
