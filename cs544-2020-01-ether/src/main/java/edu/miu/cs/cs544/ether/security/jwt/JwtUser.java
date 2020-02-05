package edu.miu.cs.cs544.ether.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

public @Data class JwtUser implements UserDetails
{
 private static final long serialVersionUID = 1L;
 private final String username;
 private final String password;
 private final Collection<? extends GrantedAuthority> authorities;
 private final boolean enabled;

 @JsonIgnore
 @Override
 public boolean isAccountNonExpired()
 {
  return true;
 }

 @JsonIgnore
 @Override
 public boolean isAccountNonLocked()
 {
  return true;
 }

 @JsonIgnore
 @Override
 public boolean isCredentialsNonExpired()
 {
  return true;
 }

 @Override
 public boolean isEnabled()
 {
  return enabled;
 }

}