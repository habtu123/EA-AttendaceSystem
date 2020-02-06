package edu.miu.cs.cs544.ether.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
public class TimeSlot {
    @Id
	@NotEmpty(message = "Timeslot abbreviation can not be empty ")
    private String abbreviation;
    private String description;
    @Temporal(TemporalType.TIME)
	@NotNull(message = "Timeslot starttime cannot be null")
    private Date startTime;
    @Temporal(TemporalType.TIME)
	@NotNull(message = "Timeslot endtime cannot be null")
    private Date endTime;
    
    public TimeSlot() {
    	
    }

	public TimeSlot(String abbreviation, String description, Date startTime, Date endTime) {
		this.abbreviation = abbreviation;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
    
    
    
}
