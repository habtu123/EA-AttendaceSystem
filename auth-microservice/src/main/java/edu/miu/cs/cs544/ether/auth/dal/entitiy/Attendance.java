package edu.miu.cs.cs544.ether.auth.dal.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Attendance(Student student, Date date, Location location, TimeSlot timeSlot) {
		this.student = student;
		this.date = date;
		this.location = location;
		this.timeSlot = timeSlot;
	}
	public Attendance() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	@ManyToOne()
    @JoinColumn(name = "barCodeId", referencedColumnName = "barCodeId")
    private Student student;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Location location;
    @ManyToOne
    private TimeSlot timeSlot;
}
