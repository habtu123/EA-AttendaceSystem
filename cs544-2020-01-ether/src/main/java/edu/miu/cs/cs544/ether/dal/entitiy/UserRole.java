package edu.miu.cs.cs544.ether.dal.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class UserRole {
    @Id
    @GeneratedValue
    private Long id;
    private String role;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;
}
