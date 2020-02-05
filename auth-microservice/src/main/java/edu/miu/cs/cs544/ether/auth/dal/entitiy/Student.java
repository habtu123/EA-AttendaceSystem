package edu.miu.cs.cs544.ether.auth.dal.entitiy;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue()
    private Long id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String barCodeId;

}

