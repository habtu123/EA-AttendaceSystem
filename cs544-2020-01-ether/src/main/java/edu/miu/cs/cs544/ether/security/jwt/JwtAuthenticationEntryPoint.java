package edu.miu.cs.cs544.ether.security.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
public class JwtAuthenticationEntryPoint extends ResponseEntityExceptionHandler
  implements AuthenticationEntryPoint, Serializable
{

 private static final long serialVersionUID = 1L;

 @Override
 public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
   throws IOException
 {
  Integer code = HttpServletResponse.SC_UNAUTHORIZED;
  String message = "Unauthorized";
  logger.error(code, authException);
  response.sendError(code, message);
 }
}