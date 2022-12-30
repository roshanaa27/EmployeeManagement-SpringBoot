package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class employee {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int employeeId;
private String employeeName;
private String employeeEmail;
private String dept;

employee() {}

employee(int employeeId,String employeeName, String employeeEmail, String dept)
{
	this.setEmployeeId(employeeId);
	this.setEmployeeName(employeeName);
	this.setEmployeeEmail(employeeEmail);
	this.setDept(dept);
}
public int getEmployeeId()
{
	return employeeId;
}
public void setEmployeeId(int employeeId)
{
	this.employeeId=employeeId;
}
public String getEmployeeName()
{
	return employeeName;
}
public void setEmployeeName(String employeeName)
{
	this.employeeName=employeeName;
}
public String getEmployeeEmail()
{
	return employeeEmail;
}
public void setEmployeeEmail(String employeeEmail)
{
	this.employeeEmail=employeeEmail;
}
public String getDept()
{
	return dept;
}
public void setDept(String dept)
{
	this.dept=dept;
}
}
