/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.quancm.tincode.controllers;

import com.quancm.tincode.models.Word;
import com.quancm.tincode.services.WordService;
import com.quancm.tincode.services.WordServiceSingleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caomi
 */
@WebServlet(name = "EditWordController", urlPatterns = {"/edit"})
public class EditWordController extends HttpServlet {

    private static int id;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            id = Integer.parseInt(request.getParameter("id"));
            WordService wordService = WordServiceSingleton.getInstance();
            Word word = wordService.getWordById(id);
            if (word != null) {
                request.setAttribute("word", word);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/edit-word.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            newWord.setId(id);
            newWord.setWord(word);
            newWord.setDefinition(definition);
            newWord.setOriginal(original);
            newWord.setExample(example);
            WordService wordService = WordServiceSingleton.getInstance();
            wordService.updateWord(newWord);
            request.setAttribute("status", "Sửa từ thành công");
            request.setAttribute("word", newWord);

        } catch (SQLException ex) {
            Logger.getLogger(CreateWordController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", "Sửa từ thất bại.");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/edit-word.jsp");
        requestDispatcher.forward(request, response);
    }

}
