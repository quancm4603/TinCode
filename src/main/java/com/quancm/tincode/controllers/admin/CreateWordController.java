/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.quancm.tincode.controllers.admin;

import com.quancm.tincode.models.Word;
import com.quancm.tincode.services.WordService;
import com.quancm.tincode.services.WordServiceSingleton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caomi
 */
@WebServlet(name = "CreateWordController", urlPatterns = {"/create-word", "/tao-tu"})
public class CreateWordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/word/create-word.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String word = request.getParameter("word");
            String definition = request.getParameter("definition");
            String original = request.getParameter("original");
            String example = request.getParameter("example");

            Word newWord = new Word();
            newWord.setWord(word);
            newWord.setDefinition(definition);
            newWord.setOriginal(original);
            newWord.setExample(example);
            WordService wordService = WordServiceSingleton.getInstance();
            wordService.addWord(newWord);
            
            request.setAttribute("status", "Thêm từ thành công");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateWordController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", "Thêm từ thất bại, từ đã tồn tại.");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/word/create-word.jsp");
        requestDispatcher.forward(request, response);
    }

}
