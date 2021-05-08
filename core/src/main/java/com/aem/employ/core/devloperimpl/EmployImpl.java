package com.aem.employ.core.devloperimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.employ.core.devleperI.EmployI;
@Component(service=EmployI.class,immediate=true)
public class EmployImpl implements EmployI {

	@Override
	public boolean empRegister(int id, String firstName, String lastName, String location) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

}
