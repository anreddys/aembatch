package com.aem.employ.core.devloperimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.employ.core.devleperI.SightlySerivceInterface;

@Component(service=SightlySerivceInterface.class, immediate=true)
public class SightlySerivce implements SightlySerivceInterface{

	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		return "John";
	}

	@Override
	public String getDeveloperProfile() {
		// TODO Auto-generated method stub
		return "AEM Developer";
	}

	@Override
	public String getDeveloperSkills() {
		// TODO Auto-generated method stub
		return "JAVA, OSGI, HTML, JS";
	}

	@Override
	public String getDeveloperData() {                       // 2mints 
		// TODO Auto-generated method stub
		String name = this.getDeveloperName();
		String profile = this.getDeveloperProfile();
		String skills = this.getDeveloperSkills();
		return name + " is a " + profile + ", He is expert in skills like " + skills;
	}

}
