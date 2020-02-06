package edu.miu.cs.cs544.ether.restcontroller;

import edu.miu.cs.cs544.ether.dal.entity.Session;

import java.util.List;

public interface SessionController {

    public Session addSession(Session newSession);

    public List<Session> getSessions();
    
    public List<Session> getSessions(Long courseOfferingId);

    public Session getSessionById(Long sessionId);

    public void deleteSession(Long sessionId);
    
    public void deleteSessionByCourseOffering(Long courseOfferingId);

    public void updateSession(Long SessionId, Session updatedSession);


}
