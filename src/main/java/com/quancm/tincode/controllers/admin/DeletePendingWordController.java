/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.quancm.tincode.controllers.admin;

import com.quancm.tincode.models.Word;
import com.quancm.tincode.services.PendingWordService;
import com.quancm.tincode.services.PendingWordServiceSingleton;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caomi
 */
@WebServlet(name="DeletePendingWordController", urlPatterns={"/delete-pending"})
public class DeletePendingWordController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            PendingWordService pendingWordService = PendingWordServiceSingleton.getInstance();
            Word newWord = pendingWordService.getWordById(id);
            pendingWordService.deleteWord(id);
            response.sendRedirect("./pending");
        } catch (Exception e) {
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }


}
