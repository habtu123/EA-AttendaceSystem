package edu.miu.cs.cs544.ether.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.miu.cs.cs544.ether.dal.Fortune;
import edu.miu.cs.cs544.ether.dal.Greeting;
import edu.miu.cs.cs544.ether.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class FortuneServiceImpl implements FortuneService {
    private Random rand = new Random();


    @Value("${fortuneservice.url}")
    private String fortuneUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public Greeting getFortune() {
        Fortune fortune = restTemplate.getForObject("http://fortune/getFortune", Fortune.class);
        return new Greeting("Greeting",fortune );
    }

    public Greeting defaultFallback(){
        return new Greeting("Hi", new Fortune(3, "Your fortune is uncertain"));
    }
}
