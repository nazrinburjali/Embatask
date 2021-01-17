package com.embatask.productmanagement.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthenticationFailureHandler  implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        {

//            Map<String, Object> response = new HashMap<>();
//            response.put("status", "34");
//            response.put("message", "unauthorized access");
//
//            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            OutputStream out = httpServletResponse.getOutputStream();
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writerWithDefaultPrettyPrinter().writeValue(out, response);
//            out.flush();
            System.out.println("Login ugursuz oldu, sebeb " + e.getMessage());

            if (e instanceof BadCredentialsException) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?error");
            }
        }
    }
}