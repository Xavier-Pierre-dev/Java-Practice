package com.tutorial.hello.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Filter3 implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    System.out.println("Filter 3 initialized...");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("Filter 3 executing Before Servlet Processing ...");
        filterChain.doFilter(request, response);
        System.out.println("Filter 3 executing after Servlet Processing...");
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter 3 Destroyed..");
    }
}
