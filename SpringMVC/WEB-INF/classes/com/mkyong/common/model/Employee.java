package com.mkyong.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@XmlRootElement(name="employee")
@Table(name="EMPLOYEE")
@SequenceGenerator(sequenceName="EMPID_SEQ",name="EMPID_SEQ_GEN") 
@JsonAutoDetect
public class Employee implements Serializable {
	
	
	public Employee(int empid, String empname, String mailid,
			Date dateofbirth, String status) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.mailid = mailid;
		this.dateofbirth = dateofbirth;
		this.status = status;
	}


	@Id
	@GeneratedValue(generator="EMPID_SEQ_GEN",strategy=GenerationType.SEQUENCE)
	private int empid;
	@Column private String empname;
	@Column	private String mailid;

	@Column	private Date dateofbirth;
	
	  
	public Employee(){
		
	}
	
	
	public Employee(int id, String name, String email) {
		// TODO Auto-generated constructor stub
		
		this.empid = id;
		this.empname = name;
		this.mailid = email;
	}


	private String status;
	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "EmployeePOJO [empid=" + empid + ", empname=" + empname
				+ ", mailid=" + mailid + ", dateofbirth=" + dateofbirth
				+ ", status=" + status + "]";
	}
	
}
