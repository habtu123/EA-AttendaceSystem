package edu.miu.cs.cs544.ether.dal.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends User {
    private String studentId;
    private String barCodeId;
    
	public Student() {
		
	}

	public Student(String username, String password, List<UserRole> roles, String studentId, String barCodeId) {
		super(username, password, roles);
		this.studentId = studentId;
		this.barCodeId = barCodeId;
	}

	public Student(String studentId, String barCodeId) {
		this.studentId = studentId;
		this.barCodeId = barCodeId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getBarCodeId() {
		return barCodeId;
	}

	public void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}

}

