/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.quancm.tincode.controllers.authen;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caomi
 */
@WebServlet(name = "LogoutController", urlPatterns = {"/logout", "/dang-xuat"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) { // Tên cookie cần xóa
                        cookie.setMaxAge(0); // Set thời gian sống của cookie thành 0 để nó bị xóa ngay lập tức
                        response.addCookie(cookie); // Gửi cookie đã được chỉnh sửa về cho người dùng để xóa
                    }
                    if (cookie.getName().equals("password")) { // Tên cookie cần xóa
                        cookie.setMaxAge(0); // Set thời gian sống của cookie thành 0 để nó bị xóa ngay lập tức
                        response.addCookie(cookie); // Gửi cookie đã được chỉnh sửa về cho người dùng để xóa
                    }
                }
            }
        }
        response.sendRedirect("./login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
