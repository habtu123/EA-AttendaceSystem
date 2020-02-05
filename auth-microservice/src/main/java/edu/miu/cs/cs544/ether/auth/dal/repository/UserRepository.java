package edu.miu.cs.cs544.ether.auth.dal.repository;

import edu.miu.cs.cs544.ether.auth.dal.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.rmi.runtime.Log;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
