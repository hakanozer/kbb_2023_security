package com.works.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String url = req.getRequestURI();
        String username = auth.getName();
        String roles = auth.getAuthorities().toString();
        String sessionID = req.getSession().getId();
        long time = System.currentTimeMillis();
        String detail = auth.getDetails().toString();

        System.out.println(url + " " + username + " " + roles + " " + sessionID + " " + time + " " + detail);
        filterChain.doFilter(req, res);
    }

}