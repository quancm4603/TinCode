/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quancm.tincode.filters;

import com.quancm.tincode.models.User;
import com.quancm.tincode.services.UserService;
import com.quancm.tincode.services.UserServiceSingleton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caomi
 */
@WebFilter(urlPatterns = "/*")
public class CheckLoginCookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false); // Retrieve existing session if exists

        if (session == null || session.getAttribute("user") == null) {
            // Session doesn't exist or user not logged in
            // Check if the login cookie exists
            Cookie[] cookies = httpRequest.getCookies();
            String username = null;
            String password = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) { // Replace with your login cookie name
                        username = cookie.getValue();
                        password = cookie.getValue();
                    }
                }
                UserService userService = UserServiceSingleton.getInstance();
                try {
                    if (username != null && password != null) {
                        User user = userService.authenticateUser(username, password);
                        if (user != null) {
                            session = httpRequest.getSession();
                            session.setAttribute("user", user);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CheckLoginCookieFilter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        chain.doFilter(request, response); // Continue the filter chain
    }

    @Override
    public void destroy() {
    }

}
