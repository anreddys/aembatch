package com.aem.employ.core.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.aem.employ.core.devleperI.SightlySerivceInterface;

public class Developer extends WCMUsePojo {

	Logger logger = LoggerFactory.getLogger(Developer.class);
	protected String detail;
	
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
		SightlySerivceInterface service = getSlingScriptHelper().getService(SightlySerivceInterface.class);
	    detail = service.getDeveloperData();
		
	}
	
	public String getDetails() {
	    return this.detail;
	  }
	
	

}
