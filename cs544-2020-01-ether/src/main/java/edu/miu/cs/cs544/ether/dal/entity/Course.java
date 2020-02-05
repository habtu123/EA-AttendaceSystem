package edu.miu.cs.cs544.ether.dal.entity;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseId;
    private String name;
	@Lob
	private String description;

    public Course() {
    	
    }
    
    public Course(String courseId, String name, String description) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
	}
    
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
