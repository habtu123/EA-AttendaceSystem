package edu.miu.cs.cs544.ether.auth.restcontroller.auth;

import edu.miu.cs.cs544.ether.auth.dal.dto.AuthenticationRequest;
import edu.miu.cs.cs544.ether.auth.dal.dto.AutheticationResponse;
import edu.miu.cs.cs544.ether.auth.security.MyUserDetailService;
import edu.miu.cs.cs544.ether.auth.security.jwt.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutheticationContoller {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    @PostMapping(value = "/autheticate")
    public ResponseEntity<AutheticationResponse> createAutheticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        }catch (BadCredentialsException e){
//            throw new Exception("Incorete username or password", e);
//        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new AutheticationResponse(jwt));
    }

}
