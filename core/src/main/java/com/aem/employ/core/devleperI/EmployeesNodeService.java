package com.aem.employ.core.devleperI;

public interface EmployeesNodeService {
	
	public boolean registerEmployDetails(String firstName,String lastName,String userName,String password);
	public boolean loginEmployee(String user,String pass);	

}
