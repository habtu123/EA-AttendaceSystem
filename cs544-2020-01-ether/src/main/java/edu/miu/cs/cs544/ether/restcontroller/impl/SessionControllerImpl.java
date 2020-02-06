package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entity.Session;
import edu.miu.cs.cs544.ether.restcontroller.SessionController;
import edu.miu.cs.cs544.ether.service.SessionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionControllerImpl implements SessionController {

    @Autowired
    private SessionService sessionService;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-API-Key ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @PostMapping(value = "/sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Session addSession(@RequestBody Session newSession){
        sessionService.addSession(newSession);
        return newSession;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-API-Key", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Session> getSessions(){
        return sessionService.getSessions();
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/sessions/{sessionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Session getSessionById(@PathVariable Long sessionId){
        return sessionService.getSessionById(sessionId);
    }
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/sessions/courseoffering/{courseOfferingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Session> getSessions(@PathVariable Long courseOfferingId){
        return sessionService.getSessions(courseOfferingId);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-API-Key", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @DeleteMapping(value = "/sessions/{sessionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSession(@PathVariable Long sessionId){
        sessionService.deleteSession(sessionId);
    }
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-API-Key", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @DeleteMapping(value = "/sessions/courseoffering/{courseOfferingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSessionByCourseOffering(@PathVariable Long courseOfferingId){
        sessionService.deleteSessionByCourseOffering(courseOfferingId);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-API-Key", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @PutMapping(value="/sessions/{sessionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSession(@PathVariable Long sessionId, @RequestBody Session updatedSession){
        //because this is a PUT, all fields are mandatory. Alternative would be to use the PATCH HTTP verb
        //TODO: Add functionality to validate that all fields have been passed
        Session existingSession = sessionService.getSessionById(sessionId);
        BeanUtils.copyProperties(updatedSession, existingSession, "sessionId");
        sessionService.updateSession(existingSession);
    }
}
