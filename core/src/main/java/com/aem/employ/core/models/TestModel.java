
package com.aem.employ.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

@Model(adaptables = Resource.class)
public class TestModel {
    @Inject
	private String title;     //reading title from resource
    
    @Inject
	private String description;     //reading description from resource

	@PostConstruct
	protected void init() {

	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
