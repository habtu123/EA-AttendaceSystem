package edu.miu.cs.cs544.ether.security.jwt;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.miu.cs.cs544.ether.exception.UnauthorizedRequestException;
import edu.miu.cs.cs544.ether.security.MyPrncipalUser;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JwtTokenUtilService implements Serializable
{

 private static final long serialVersionUID = -3301605591108950415L;

 static final String CLAIM_KEY_USERNAME = "subject";
 static final String CLAIM_KEY_AUDIENCE = "audience";
 static final String CLAIM_KEY_CREATED = "iat";
 static final String CLAIM_KEY_AUTHORITIES = "roles";
 static final String CLAIM_KEY_IS_ENABLED = "isEnabled";
 static final String CLAIM_SCOPE = "scope";

 @Value("${jwt.secret}")
 private String secret;

 @Autowired
 ObjectMapper objectMapper;

 @Autowired
 JWTUtils jwtRsaUtils;

 @Value("${jwt.expiration}")
 private Long expiration;

 public String getUsernameFromToken(String token)
 {
  String username = null;
  final Map<String, Object> claims = getClaimsFromToken(token);
  if (claims != null) {
   username = (String) claims.get(CLAIM_KEY_USERNAME);
  }

  return username;
 }

 public JwtUser getUserDetails(String token)
 {
  if (token == null) {
   return null;
  }
  final Map<String, Object> claims = getClaimsFromToken(token);
  if (claims != null && claims.get(CLAIM_KEY_AUTHORITIES) != null) {
   List<SimpleGrantedAuthority> authorities = null;
   authorities = ((List<String>) claims.get(CLAIM_KEY_AUTHORITIES)).stream().map(SimpleGrantedAuthority::new)
     .collect(Collectors.toList());
   return new JwtUser((String) claims.get(CLAIM_KEY_USERNAME), "", authorities,
     (boolean) claims.get(CLAIM_KEY_IS_ENABLED));
  }
  return null;
 }

 public String getAudienceFromToken(String token)
 {
  String audience = null;
  final Map<String, Object> claims = getClaimsFromToken(token);
  if (claims != null) {
   audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
  }
  return audience;
 }

 private Map<String, Object> getClaimsFromToken(String token)
 {
  Map<String, Object> claims = null;
  JwtClaims jwtClaims;
  try {
   PublicKey key = jwtRsaUtils.parseRSAPublicKey();

   JwtConsumer jwtConsumer = new JwtConsumerBuilder().setRequireExpirationTime().setVerificationKey(key).build();

   jwtClaims = jwtConsumer.processToClaims(token);
   claims = jwtClaims.getClaimsMap();

  } catch (final Exception e) {
   claims = null;
  }
  return claims;
 }

 public Boolean validateToken(String token, UserDetails userDetails)
 {
  final String username = getUsernameFromToken(token);
  // Token is expired
  if (username == null) {
   return false;
  }
  final String usernameTrimmed = username.trim();
  final MyPrncipalUser user = (MyPrncipalUser) userDetails;
  String jwtUsername = user.getUsername().trim();
  return (jwtUsername.equals(usernameTrimmed));
 }
}