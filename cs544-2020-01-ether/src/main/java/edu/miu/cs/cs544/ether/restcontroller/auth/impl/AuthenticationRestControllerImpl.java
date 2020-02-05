package edu.miu.cs.cs544.ether.restcontroller.auth.impl;

import javax.servlet.http.HttpServletResponse;

import edu.miu.cs.cs544.ether.exception.PasswordNotFoundException;
import edu.miu.cs.cs544.ether.restcontroller.auth.AuthenticationRestController;
import edu.miu.cs.cs544.ether.security.MyPrncipalUser;
import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationRequest;
import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationResponse;
import edu.miu.cs.cs544.ether.security.jwt.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Luigi Salvatore Galluzzi
 *
 */
@RequestMapping(value = "auth", headers = "Accept=application/json")
@RestController
public class AuthenticationRestControllerImpl implements AuthenticationRestController
{

 @Value("${jwt.header}")
 private String tokenHeader;

 @Autowired
 private AuthenticationManager authenticationManager;

 @Autowired
 private JwtTokenUtilService jwtTokenUtilService;

 @ApiOperation(value = "Login", nickname = "Login", notes = "")
 @ApiResponses(value = { @ApiResponse(code = 200, message = "Status 200"),
   @ApiResponse(code = 401, message = "Status 401"), @ApiResponse(code = 500, message = "Status 500") })

 @Override
 @PostMapping(value = "/login")
 public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(
   @ApiParam(name = "authentication", value = "username and password for authentication", required = true) @RequestBody JwtAuthenticationRequest authenticationRequest,
   HttpServletResponse response)
 {

  // Authentication Process
  // The authenitcate method calls loadUserByUsername method automatically
  // and then the findByLoginName method, into the UserAccessRepository is called
  Authentication authentication = null;
  try {
   UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
   validatePrinciple(auth.getPrincipal());

//   authentication = authenticationManager.authenticate(
//     new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//   SecurityContextHolder.getContext().setAuthentication(authentication);
   // Token Building
   final UserDetails userDetails = (UserDetails) auth.getPrincipal();
   String token = generateToken(userDetails);
   response.setHeader(tokenHeader, token);
  } catch (Exception e) {
   String message = e.getMessage();
   if (message == null) {
    throw new PasswordNotFoundException(message);
   } else {
    throw e;
   }
  }

  // Complete Response
  // return ResponseEntity.ok(new
  // JwtAuthenticationResponse(userDetails.getUsername(),
  // userDetails.getAuthorities()))

  // Custom Response: without information
  return ResponseEntity.ok().body(null);
 }
 private void validatePrinciple(Object principal) {
  if (!(principal instanceof MyPrncipalUser)) {
   throw new  IllegalArgumentException("Principal can not be null!");
  }
 }

 /**
  * @param userDetails
  * @param token
  * @return
  */
 private String generateToken(final UserDetails userDetails)
 {
  return jwtTokenUtilService.generateToken(userDetails);
 }

}

