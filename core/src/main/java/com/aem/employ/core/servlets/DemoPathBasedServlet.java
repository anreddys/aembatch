package com.aem.employ.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.employ.core.dbutil.DatabaseConnectionHelper;
import com.aem.employ.core.devleperI.SightlySerivceInterface;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                  // "sling.servlet.resourceTypes="+ "employ/components/structure/page",
                 //  "sling.servlet.extensions=" + "txt"
                 "sling.servlet.paths=" + "/bin/test"
           })
public class DemoPathBasedServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUid = 1L;
    
    @Reference
    protected DatabaseConnectionHelper helper;
    @Reference
    protected SightlySerivceInterface obj;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
     String details=  obj.getDeveloperData();
     
    Connection con= helper.getDataBaseConnection("employ");
    System.out.println("Connnection Successfull from Servlet"+con);
    	resp.getWriter().write(details);
    }
    
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//super.doPost(request, response);
    }
    
    }
