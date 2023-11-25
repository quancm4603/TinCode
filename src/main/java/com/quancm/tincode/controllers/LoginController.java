
package com.quancm.tincode.controllers;

import com.quancm.tincode.models.User;
import com.quancm.tincode.services.UserService;
import com.quancm.tincode.services.UserServiceSingleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name="LoginController", urlPatterns={"/login", "/dang-nhap"})
public class LoginController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("./");
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/authen/login.jsp");
            requestDispatcher.forward(request, response);
        }
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            //Get login params
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            //Valitade
            UserService userService = UserServiceSingleton.getInstance();
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                String remember = request.getParameter("remember");
                if (remember != null) {
                    Cookie usernameCookie = new Cookie("username", username);
                    usernameCookie.setMaxAge(60*24*3);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60*24*3);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    
                }
                // Đăng nhập thành công, quay về trang chủ
                response.sendRedirect("./");
            }else{
                //Đăng nhập thất bại, đăng nhập lại
                response.sendRedirect("./login");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }


}
