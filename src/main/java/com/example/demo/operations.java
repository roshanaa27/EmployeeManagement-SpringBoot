package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class operations {
@Autowired repository ob;
@PostMapping("/add")
public String save(@RequestBody employee employee1)
{
	employee w= new employee();
	int id=employee1.getEmployeeId();
	String employeeName=employee1.getEmployeeName();
	String employeeEmail=employee1.getEmployeeEmail();
	String dept=employee1.getDept();
	
	w.setEmployeeId(id);
	w.setEmployeeName(employeeName);
	w.setEmployeeEmail(employeeEmail);
	w.setDept(dept);
	
	employee first = new employee(id,employeeName,employeeEmail,dept);
	ob.save(first);
	return "Added successfully";
}

@GetMapping("/employee")
public List<employee> getAllemployees()
{
	return ob.findAll();
}

@GetMapping("employee/{id}")
public List<employee> getEmployeeById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@GetMapping("employee/name/{employeeName}")
public List<employee> getByName(@PathVariable("employeeName") String employeeName)
{
	return ob.findByName(employeeName);
}

@PutMapping("/update/{id}")
public String update(@RequestBody employee x,@PathVariable("id") int id)
{
	int employeeId1=x.getEmployeeId();
	String employeeName=x.getEmployeeName();
	String employeeEmail=x.getEmployeeEmail();
	String dept=x.getDept();
	ob.update(employeeId1,employeeName,employeeEmail,dept,id);
	return "Successfully updated";
}

@DeleteMapping("delete/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Deleted successfully";
}
}