package com.aem.employ.core.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.employ.core.devleperI.EmployeesNodeService;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Employee login Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/employlogin" })
public class EmployLoginServlet extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(EmployLoginServlet.class);

	
	@Reference
	private EmployeesNodeService empNodService;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		String user=request.getParameter("uname");
	String pass=request.getParameter("pwd");
	
	
   boolean b=empNodService.loginEmployee(user, pass);
   if(b) {
	RequestDispatcher dp= request.getRequestDispatcher("/content/employ/en/Success.html");
	dp.forward(request, response);
	   
   }else {
	   RequestDispatcher dp= request.getRequestDispatcher("/content/employ/en/Fail.html");
		dp.forward(request, response);
	   
   }
		
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(request, response);

	}

}