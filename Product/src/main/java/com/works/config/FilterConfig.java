package com.works.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String userAgent = req.getHeader("user-agent");
        String ip = req.getLocalAddr();
        System.out.println( userAgent + " " + ip );

        chain.doFilter( request, response );
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
