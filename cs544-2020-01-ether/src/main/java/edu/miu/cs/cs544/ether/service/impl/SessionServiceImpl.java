package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Session;
import edu.miu.cs.cs544.ether.dal.repository.SessionRepository;
import edu.miu.cs.cs544.ether.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void addSession(Session newSession){
        sessionRepository.save(newSession);
    }

    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long sessionId){
        return sessionRepository.getOne(sessionId);
    }

    public void deleteSession(Long sessionId){
        sessionRepository.deleteById(sessionId);
    }

    public void updateSession(Session updatedSession){
        sessionRepository.save(updatedSession);
    }
}
