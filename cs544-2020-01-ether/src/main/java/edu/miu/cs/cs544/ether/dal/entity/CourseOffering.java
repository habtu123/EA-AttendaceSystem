package edu.miu.cs.cs544.ether.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class CourseOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Course offering Id can not null")
	private Long courseOfferingId;

	@ManyToOne
	@Valid
	private Course course;
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date endDate;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Location location;
	

	public CourseOffering() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	public CourseOffering(Long courseOfferingId, Course course, Date startDate, Date endDate, Student student, Location location) {
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
