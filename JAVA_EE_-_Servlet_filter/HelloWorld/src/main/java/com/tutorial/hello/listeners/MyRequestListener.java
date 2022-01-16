package com.tutorial.hello.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletRequestListener {

    private static final Logger LOG = Logger.getLogger( MyRequestListener.class.getName() );

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.setAttribute( "startTime", System.currentTimeMillis() );
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long startTime = (Long) request.getAttribute( "startTime" );
        LOG.log( Level.INFO, "Request is produced in {0} milliseconds", 
                 System.currentTimeMillis() - startTime );
    }
    
}