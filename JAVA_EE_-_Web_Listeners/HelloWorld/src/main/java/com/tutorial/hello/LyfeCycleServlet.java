package com.tutorial.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LyfeCycleServlet
 */
//@WebServlet(urlPatterns="/LyfeCycleServlet", loadOnStartup=1)
//@WebServlet("/LyfeCycleServlet")
public class LyfeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int countGetRequest = 0;
	String param = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LyfeCycleServlet() {
        super();
    	System.out.println();
    	System.out.println("-----");
        System.out.println("Constructor : servlet created but not yet initialised mean the context from web.xml are not loaded");
    	System.out.println("-----");
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println();
    	System.out.println("-----");
    	System.out.println("init method : fully initialised called once mean the context from web.xml is already loaded");
    	this.param = this.getServletContext().getInitParameter("MY_PARAM").toString();
    	System.out.println(this.param);
    	System.out.println("-----");
    }
    
    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	System.out.println("-----");
    	System.out.println("service method for dispatching http request to the right method");
    	System.out.println("-----");
    	super.service(arg0, arg1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println();
    	System.out.println("-----");
    	System.out.println("in the doGet method of : " + this.getClass().getName().toString());
    	countGetRequest++;
		System.out.println("The number of get request receive by the servlet LyfeCycleServlet since her first initialisation is : " + countGetRequest);
    	System.out.println("-----");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" and MY_PARAM equal : ").append(this.getServletContext().getInitParameter("MY_PARAM").toString());
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	System.out.println();
    	System.out.println("-----");
        System.out.println("Destroy method called once");
    	System.out.println("-----");
    	super.destroy();
    }

}
