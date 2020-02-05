package edu.miu.cs.cs544.ether.restcontroller.auth;

import edu.miu.cs.cs544.ether.dal.dto.AuthenticationRequest;
import edu.miu.cs.cs544.ether.dal.dto.AutheticationResponse;
import edu.miu.cs.cs544.ether.security.MyUserDetailService;
import edu.miu.cs.cs544.ether.security.jwt.JWTUtils;
import edu.miu.cs.cs544.ether.security.jwt.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/autheticate")
    public String createAutheticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        ResponseEntity<AutheticationResponse> jwt = restTemplate.postForEntity("http://auth/autheticate", authenticationRequest, AutheticationResponse.class);

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtilService.generateToken(userDetails);

        return jwt.getBody().getJwt();
    }

}
