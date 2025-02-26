package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.restcontroller.GreetingService;
import edu.miu.cs.cs544.ether.dal.Greeting;
import edu.miu.cs.cs544.ether.service.FortuneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "GreetingController")
@RestController
@RequestMapping("/")
public class GreetingControllerImpl implements GreetingService {



    @Autowired
    private FortuneService fortuneService;

    @ApiOperation(value = "View a list of available student", response = Greeting.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(value = "/getFortune", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting getFortune(){
       return  fortuneService.getFortune();
    }
}
