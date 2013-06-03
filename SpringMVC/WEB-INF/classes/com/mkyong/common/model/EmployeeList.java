package com.mkyong.common.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement(name="employees")
@JsonAutoDetect
public class EmployeeList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1068937489639391584L;
	private int count;
	private List<Employee> employees;
	
	public EmployeeList() {
		if(employees!=null)
		count=employees.size();
	}
	
	public EmployeeList(List<Employee> employees) {
		this.employees = employees;
		this.count = employees.size();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	//@XmlElement(name="employee")
	@JsonSerialize (using = EmployeeSerializer.class)
	public List<Employee> getEmployees() {
		if(this.employees!=null)
			System.out.println("setting size in getEmployees  "+this.employees.size());
		return employees;
	}
	public void setEmployees(List<Employee> employees) {		
		System.out.println("setting size in setEmployees  "+employees.size());
		this.employees = employees;
		count=employees.size();
	}
	
}