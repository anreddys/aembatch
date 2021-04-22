package com.aem.employ.core.bean;

public class JsonEmployeeBean {

	private String empId;
	private String empName;
	private String empSalary;
	private String empAddress;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "JsonEmployeeBean [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", empAddress=" + empAddress + "]";
	}

}
