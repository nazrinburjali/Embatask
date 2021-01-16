package com.embatask.productmanagement.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        System.out.println("successhandler isledi");

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                    UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        httpServletRequest.getSession().setAttribute("user",userPrincipal.getUser());
        System.out.println("user ugurla login oldu" + userPrincipal.getUser());

        String page = userPrincipal.getUser().getRoles().get(0).getDefaultPage();
        httpServletResponse.sendRedirect(page);
        System.out.println("successhandler2 isledi");
    }

}

