/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quancm.tincode.filters;

/**
 *
 * @author caomi
 */
import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String requestEncoding;
    private String responseEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requestEncoding = filterConfig.getInitParameter("requestEncoding");
        if (requestEncoding == null) {
            requestEncoding = "UTF-8";
        }

        responseEncoding = filterConfig.getInitParameter("responseEncoding");
        if (responseEncoding == null) {
            responseEncoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(requestEncoding);
        response.setCharacterEncoding(responseEncoding);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Clean-up, if any.
    }
}
