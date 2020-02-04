package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entitiy.Session;
import edu.miu.cs.cs544.ether.service.customexpection.SessionController;
import edu.miu.cs.cs544.ether.service.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sessions/")
public class SessionControllerImpl implements SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Session addSession(@RequestBody Session newSession){
        sessionService.addSession(newSession);
        return newSession;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Session> getSessions(){
        return sessionService.getSessions();
    }

    @GetMapping(value = "{sessionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Session getSessionById(@PathVariable Long sessionId){
        return sessionService.getSessionById(sessionId);
    }

    @DeleteMapping(value = "/delete/{sessionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSession(@PathVariable Long sessionId){
        sessionService.deleteSession(sessionId);
    }

    @RequestMapping(value="/update/{sessionId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSession(@PathVariable Long sessionId, @RequestBody Session updatedSession){
        //because this is a PUT, all fields are mandatory. Alternative would be to use the PATCH HTTP verb
        //TODO: Add functionality to validate that all fields have been passed
        Session existingSession = sessionService.getSessionById(sessionId);
        BeanUtils.copyProperties(updatedSession, existingSession, "sessionId");
        sessionService.updateSession(existingSession);
    }
}
