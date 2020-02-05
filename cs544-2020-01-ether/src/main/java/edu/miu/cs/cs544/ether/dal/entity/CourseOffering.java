package edu.miu.cs.cs544.ether.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CourseOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long courseOfferingId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
	
	public CourseOffering() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseOffering(Long courseOfferingId, Course course, Date startDate, Date endDate, Student student) {
		this.courseOfferingId = courseOfferingId;
		this.course = course;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
	}
	public Long getCourseOfferingId() {
		return courseOfferingId;
	}
	public void setCourseOfferingId(Long courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
