package com.aem.employ.core.servlets;

import java.io.IOException;

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
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Employee Register Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/employregister"            
})
public class EmployRegisterServlet extends SlingAllMethodsServlet {
	
	 private static final Logger log = LoggerFactory.getLogger(EmployRegisterServlet.class);
	
	 @Reference
	 private EmployeesNodeService empNodService;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		empNodService.registerEmployDetails(fname,lname,uname,pwd);
		
		log.info("Registration Done");
		
		response.getWriter().print("EmployRegistration servlet called");
		
	}
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		
		
		
		
	}

}