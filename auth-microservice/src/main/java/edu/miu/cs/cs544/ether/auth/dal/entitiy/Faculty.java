package edu.miu.cs.cs544.ether.auth.dal.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.util.List;

@Entity
public class Faculty extends User{
    private String profession;
    private String remark;

    public Faculty(String username, String password, List<UserRole> roles, String profession, String remark) {
        super(username, password, roles);
        this.profession = profession;
        this.remark = remark;
    }

    public Faculty(String profession, String remark) {
        this.profession = profession;
        this.remark = remark;
    }
}
