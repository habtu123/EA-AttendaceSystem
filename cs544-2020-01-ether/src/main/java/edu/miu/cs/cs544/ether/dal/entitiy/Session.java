package edu.miu.cs.cs544.ether.dal.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data  class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private TimeSlot timeSlot;
    @ManyToOne(cascade = CascadeType.ALL)
    private CourseOffering courseOffering;

}
