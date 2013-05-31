package com.mkyong.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.common.dao.EmployeeDAO;
import com.mkyong.common.model.Employee;
import com.mkyong.common.model.EmployeeList;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO empDao;
	@RequestMapping(value="get/{id}",method = RequestMethod.GET ,headers="Accept=application/xml, application/json")
	public @ResponseBody Employee getEmp1(@PathVariable String id) {
		 Employee emps = empDao.getById(Integer.parseInt(id.trim())); 
			return emps;
		
	}
	
	@RequestMapping(value="get/{id}",method = RequestMethod.POST,produces="application/xml")
	public @ResponseBody  Employee geEmp(@PathVariable String id) {
		System.out.println("get{id} called");
		 Employee emps = empDao.getById(Integer.parseInt(id.trim())); 
		return emps;
		

	}
	
	@RequestMapping(value="getAll",method = RequestMethod.POST,produces="application/json")
	public @ResponseBody  EmployeeList geALLEmp() {
		System.out.println("getAll called");
		  List<Employee> emps = empDao.getALLEmployees();
		  System.out.println("emp size in controller "+emps.size());
		  EmployeeList e=new EmployeeList();
		  e.setEmployees(emps);
		  return e;

	}
	
	
	@RequestMapping(value="add",method = RequestMethod.POST, headers="Accept=application/xml, application/json")
	public @ResponseBody String insertEmp(@RequestBody Employee e) {
		try{
			System.out.println("add called"+e);
			empDao.save(e);
			return "added succefully";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "not added succefully";
	}
	
	
	@RequestMapping(value="addAll",method = RequestMethod.POST, headers="Accept=application/xml, application/json")
	public @ResponseBody String insertEmpAll(@RequestBody EmployeeList eList) {
		try{
			System.out.println(eList);
			for(Employee emp:eList.getEmployees())
					empDao.save(emp);
			return "added succefully";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "not added succefully";
	}
	
	
	
	@RequestMapping(value="delete/{param}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteEmp(@PathVariable String param) {
		System.out.println("delete called");
		empDao.delete(Integer.parseInt(param));
		return "Deleted successfully "+param;

	}
	//put method for update existing emp
	@RequestMapping(value="putAll",method = RequestMethod.PUT ,headers="Accept=application/xml, application/json")
	public @ResponseBody String postEmpAll(@RequestBody EmployeeList eList) {
		try{
			System.out.println("PutAll    "+eList);
			for(Employee emp:eList.getEmployees())
					empDao.update(emp);
			return "updated succefully";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "not updated succefully";

	}
	
	//put method for update existing emp
		@RequestMapping(value="put",method = RequestMethod.PUT ,headers="Accept=application/xml, application/json")
		public @ResponseBody String postEmp(@RequestBody Employee emp) {
			try{
				System.out.println("put called");
				empDao.update(emp);
				return "updated succefully";
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return "not updated succefully";

		}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	
}