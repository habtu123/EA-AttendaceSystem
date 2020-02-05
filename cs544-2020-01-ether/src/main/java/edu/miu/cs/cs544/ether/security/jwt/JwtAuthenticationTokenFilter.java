package edu.miu.cs.cs544.ether.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.miu.cs.cs544.ether.exception.UnauthorizedRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * @author Luigi Salvatore Galluzzi
 *
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{

 @Autowired
 private JwtTokenUtilService jwtTokenUtilService;

 @Value("${jwt.header}")
 private String tokenHeader;

 @Override
 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
   throws ServletException, IOException
 {
  final String authToken = request.getHeader(this.tokenHeader);

  UserDetails userDetails = null;

  if (authToken != null) {
   userDetails = jwtTokenUtilService.getUserDetails(authToken);
  }

  try {
   if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null
     && jwtTokenUtilService.validateToken(authToken, userDetails)) {

    // Si controlla l'integrità del Token e,
    // tramite le informazioni contenute nel Token JWT, viene riscostruito l'oggetto
    // Userdetail

    final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
      userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authentication);
   }
  } catch (Exception e) {
    throw new UnauthorizedRequestException(e.getMessage());
  }

  chain.doFilter(request, response);
 }
}