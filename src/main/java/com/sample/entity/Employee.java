package com.sample.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

	private Integer employeeId;
	private String employeeName;
	private Employee manager;

	public Employee() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "employee_id", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "employee_name", unique = true, nullable = false, length = 50)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@ManyToOne
	@JoinColumn(name="manager_id")
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", manager=" + manager + "]";
	}
}
