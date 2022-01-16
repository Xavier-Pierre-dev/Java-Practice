package com.tutorial.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/login_MVC")
public class Login_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_MVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
        if ( login == null ) login = "";
        if ( password == null ) password = "";
        
        /*
        request.getSession(true) will create the session if doesn't exist so 
        that's not possible to have a pointer null exception with this synthax
        */
       HttpSession session = request.getSession(true);
       session.setAttribute("login", login);
       session.setAttribute("password", password);
       
       System.out.println( "in the doGet and request ContextPath : " + request.getContextPath().toString());
       
        
        //redirect
       request.getRequestDispatcher("/Login_MVC.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
        
        
        /*
        request.getSession(true) will create the session if doesn't exist so 
        that's not possible to have a pointer null exception with this synthax
        */
       HttpSession session = request.getSession(true);
       session.setAttribute("login", login);
       session.setAttribute("password", password);
         
       System.out.println( "in the doPost and request ContextPath : " + request.getContextPath().toString());

        if ( login.equals( "Bond" ) && password.equals( "007" ) ) {
        	session.setAttribute("isConnected", true);
        	request.getRequestDispatcher("/Connected.jsp").forward(request, response);
        	
        } else {
        	session.setAttribute("isConnected", false);
        	request.getRequestDispatcher("/Login_MVC.jsp").forward(request, response);
        	
        }
    }

}
