package edu.miu.cs.cs544.ether.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class CourseOffering {
	public CourseOffering(Long courseOfferingId, Course course, Date startDate, Date endDate, Student student) {
		this.courseOfferingId = courseOfferingId;
		this.course = course;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
	}
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

}
