package edu.miu.cs.cs544.ether.dal.repository;

import edu.miu.cs.cs544.ether.dal.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
