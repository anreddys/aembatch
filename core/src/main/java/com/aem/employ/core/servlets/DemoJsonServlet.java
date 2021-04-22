package com.aem.employ.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.simple.JSONObject;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.employ.core.bean.JsonEmployeeBean;
import com.google.gson.Gson;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "= DemoJson Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/readjson" })
public class DemoJsonServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUid = 1L;

	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {
		// Reading Employee details from sightly component USing request Object
		String empId = req.getParameter("empId");
		String empName = req.getParameter("empName");
		String empSalary = req.getParameter("empSalary");
		String empAddress = req.getParameter("empAddress");
		
		System.out.println("empId"+empId+"empName"+empName+"empSal"+empSalary+"empAddress"+empAddress);

		 //Encode the submitted form data to JSON
        JSONObject obj=new JSONObject();
        obj.put("empId",empId);
        obj.put("empName",empName);
        obj.put("empSalary",empSalary);
        obj.put("empAddress",empAddress);
        
         
           //Get the JSON formatted data    
        String jsonData = obj.toJSONString();
		
		// After Readig Setting Variables to Bean class
		/*JsonEmployeeBean jsonEmp = new JsonEmployeeBean();
		jsonEmp.setEmpId(empId);
		jsonEmp.setEmpName(empName);
		jsonEmp.setEmpSalary(empSalary);
		jsonEmp.setEmpAddress(empAddress);

		System.out.println("JsonEmployee Bean ====" + jsonEmp);*/

		// Converting Java Object to Json Object Using Gson

		/*Gson gson = new Gson();
		String json = gson.toJson(jsonEmp);
		System.out.println("Employee Details After Converting to Json format" + json);*/

		resp.getWriter().write(jsonData);
	}

	/*
	 * @Override protected void doPost(SlingHttpServletRequest request,
	 * SlingHttpServletResponse response) throws ServletException, IOException { //
	 * TODO Auto-generated method stub //super.doPost(request, response); }
	 */

}
