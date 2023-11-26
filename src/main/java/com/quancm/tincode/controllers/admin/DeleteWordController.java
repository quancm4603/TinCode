/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.quancm.tincode.controllers.admin;

import com.quancm.tincode.services.WordService;
import com.quancm.tincode.services.WordServiceSingleton;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="DeleteWordController", urlPatterns={"/delete"})
public class DeleteWordController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        WordService wordService = WordServiceSingleton.getInstance();
        try {
            wordService.deleteWord(id);
            response.sendRedirect("./admin");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteWordController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(404, "Không tìm thấy từ để xóa.");
        }
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }


}
