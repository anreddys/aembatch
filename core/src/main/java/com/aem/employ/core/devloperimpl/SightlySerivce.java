package com.aem.employ.core.devloperimpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.employ.core.customosgiconfiguration.CustomEmployOsgiConfiguration;
import com.aem.employ.core.devleperI.SightlySerivceInterface;

@Component(service=SightlySerivceInterface.class, immediate=true)
@Designate(ocd =CustomEmployOsgiConfiguration.class)
public class SightlySerivce implements SightlySerivceInterface{

	
	private  CustomEmployOsgiConfiguration obj;
	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		
		/* obj.getEmpId();
		 obj.getEmpName();
		 obj.getEmpSalary();*/
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
