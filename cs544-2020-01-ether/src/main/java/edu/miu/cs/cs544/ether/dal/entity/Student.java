package edu.miu.cs.cs544.ether.dal.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String barCodeId;
    
	public Student() {
		
	}

	public Student(String studentId, String firstName, String lastName, String barCodeId) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.barCodeId = barCodeId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarCodeId() {
		return barCodeId;
	}

	public void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}
	
	
    
    

}

