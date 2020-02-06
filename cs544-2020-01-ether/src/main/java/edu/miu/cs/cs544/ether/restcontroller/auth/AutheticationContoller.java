package edu.miu.cs.cs544.ether.restcontroller.auth;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import edu.miu.cs.cs544.ether.dal.dto.AuthenticationRequest;
import edu.miu.cs.cs544.ether.dal.dto.AutheticationResponse;
import edu.miu.cs.cs544.ether.security.MyUserDetailService;
import edu.miu.cs.cs544.ether.security.jwt.JWTUtils;
import edu.miu.cs.cs544.ether.security.jwt.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AutheticationContoller {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth-url}")
    private String authUrl;
    @PostMapping(value = "/autheticate")
    @HystrixCommand(fallbackMethod = "defaultToken")
    public String createAutheticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        ResponseEntity<AutheticationResponse> jwt = restTemplate.postForEntity(authUrl, authenticationRequest, AutheticationResponse.class);

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtilService.generateToken(userDetails);

        return jwt.getBody().getJwt();
    }

    public  String defaultToken(AuthenticationRequest authenticationRequest){
        return "Sorry, You token is not availeble now";
    }

}
