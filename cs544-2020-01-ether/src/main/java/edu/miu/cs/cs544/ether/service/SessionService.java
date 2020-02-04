package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entitiy.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    public void addSession(Session newSession);

    public List<Session> getSessions();

    public Session getSessionById(Long sessionId);

    public void deleteSession(Long sessionId);

    public void updateSession(Session updatedSession);

}