package edu.miu.cs.cs544.ether.restcontroller.auth;

import javax.servlet.http.HttpServletResponse;

import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationRequest;
import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationRestController
{


 // Response without JWT inside
 public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(
         JwtAuthenticationRequest authenticationRequest, HttpServletResponse response);
}
