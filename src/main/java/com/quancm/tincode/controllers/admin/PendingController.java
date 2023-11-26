/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.quancm.tincode.controllers.admin;

import com.quancm.tincode.models.Word;
import com.quancm.tincode.services.PendingWordService;
import com.quancm.tincode.services.PendingWordServiceSingleton;
import java.io.IOException;
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

/**
 *
 * @author caomi
 */
@WebServlet(name="PendingController", urlPatterns={"/pending"})
public class PendingController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Word> words;
        PendingWordService pendingWordService = PendingWordServiceSingleton.getInstance();
        try {
            words = pendingWordService.getAllWords();
            request.setAttribute("words", words);
        } catch (SQLException ex) {
            Logger.getLogger(PendingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/pending.jsp");
        requestDispatcher.forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }


}
