
package com.aem.employ.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.settings.SlingSettingsService;

import com.aem.employ.core.devleperI.SightlySerivceInterface;

@Model(adaptables = Resource.class)
public class ServiceModel {
    
	private String detail;
   @OSGiService   
  protected  SightlySerivceInterface obj;
   
   
	@PostConstruct
	protected void init() {
		
		detail=obj.getDeveloperData();

	}

	public String getDetails() {
	    return this.detail;
	  }
	
	
	

}
