package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mkyong.common.model.Employee;


public class EmployeeDS {

	private static Map<Integer, Employee> allEmployees;
	static {
		allEmployees = new HashMap<Integer, Employee>();
		Employee e1 = new Employee(1, "Huang Yi Ming", "huangyim@cn.ibm.com");
		Employee e2 = new Employee(2, "Wu Dong Fei", "wudongf@cn.ibm.com");
		allEmployees.put(e1.getEmpid(), e1);
		allEmployees.put(e2.getEmpid(), e2);
	}
	
	public void add(Employee e) {
		allEmployees.put(e.getEmpid(), e);
	}

	public Employee get(long id) {
		return allEmployees.get(id);
	}

	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for( Iterator<Employee> it = allEmployees.values().iterator(); it.hasNext(); ) {
			Employee e = it.next();
			employees.add(e);
		}
		return employees;
	}

	public void remove(long id) {
		allEmployees.remove(id);
	}

	public void update(Employee e) {
		allEmployees.put(e.getEmpid(), e);
	}

}
