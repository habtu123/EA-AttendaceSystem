package edu.miu.cs.cs544.ether.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "barCodeId", referencedColumnName = "barCodeId")
    private Student student;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @ManyToOne(cascade = CascadeType.ALL)
    private TimeSlot timeSlot;
}
