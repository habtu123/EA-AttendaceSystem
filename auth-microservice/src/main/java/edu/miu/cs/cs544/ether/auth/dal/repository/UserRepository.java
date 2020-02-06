package edu.miu.cs.cs544.ether.auth.dal.repository;

import edu.miu.cs.cs544.ether.auth.dal.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
