package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Session;
import edu.miu.cs.cs544.ether.dal.repository.SessionRepository;
import edu.miu.cs.cs544.ether.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void addSession(Session newSession){
        sessionRepository.save(newSession);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN','FACULTY')")
    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }
    
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN','FACULTY')")
    public List<Session> getSessions(Long courseOfferingId){
        return sessionRepository.findAll().stream()
        		.filter(s -> s.getCourseOffering().getCourseOfferingId().equals(courseOfferingId))
        		.collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Session getSessionById(Long sessionId){
        return sessionRepository.getOne(sessionId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteSession(Long sessionId){
        sessionRepository.deleteById(sessionId);
    }
    
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteSessionByCourseOffering(Long courseOfferingId){
        Iterable<Session> sessions = sessionRepository.findAll().stream()
        		.filter(s -> s.getCourseOffering().getCourseOfferingId().equals(courseOfferingId))
        		.collect(Collectors.toList());
        sessionRepository.deleteInBatch(sessions);
        		
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void updateSession(Session updatedSession){
        sessionRepository.save(updatedSession);
    }
}
