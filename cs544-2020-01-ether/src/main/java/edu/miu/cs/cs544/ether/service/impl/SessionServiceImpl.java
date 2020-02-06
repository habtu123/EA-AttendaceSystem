package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Session;
import edu.miu.cs.cs544.ether.dal.repository.SessionRepository;
import edu.miu.cs.cs544.ether.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasRole('ADMIN')")
    public void addSession(Session newSession){
        sessionRepository.save(newSession);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasRole('ADMIN')")
    public Session getSessionById(Long sessionId){
        return sessionRepository.getOne(sessionId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSession(Long sessionId){
        sessionRepository.deleteById(sessionId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateSession(Session updatedSession){
        sessionRepository.save(updatedSession);
    }
}
