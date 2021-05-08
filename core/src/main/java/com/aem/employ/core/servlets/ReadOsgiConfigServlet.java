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
import com.aem.employ.core.devleperI.CustomOsgiReadService;
import com.google.gson.Gson;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "= DemoJson Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/readosgiconfig" })
public class ReadOsgiConfigServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUid = 1L;

	@Reference
	protected CustomOsgiReadService customConfig;

	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		String osgiConfigData = customConfig.readOsgiConfiguration();
		System.out.println("Osgi Configuration Data==" + osgiConfigData);

		resp.getWriter().write(osgiConfigData);
	}

}
