package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    public void addSession(Session newSession);

    public List<Session> getSessions();

    public Session getSessionById(Long sessionId);
    
    public List<Session> getSessions(Long courseOfferingId);

    public void deleteSession(Long sessionId);

    public void updateSession(Session updatedSession);

	void deleteSessionByCourseOffering(Long courseOfferingId);

}