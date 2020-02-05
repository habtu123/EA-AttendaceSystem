package edu.miu.cs.cs544.ether.auth.dal.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data  class TimeSlot {
    @Id
    private String abberiviation;
    private String description;
    @Temporal(TemporalType.TIME)
    private Date startTimel;
    @Temporal(TemporalType.TIME)
    private Date endTime;
}
