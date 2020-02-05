package edu.miu.cs.cs544.ether.security.jwt;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Luigi Salvatore Galluzzi
 *
 */
@AllArgsConstructor
public @Data class JwtAuthenticationResponse implements Serializable
{

 private static final long serialVersionUID = 1250166508152483573L;

 private final String username;
 private Collection<? extends GrantedAuthority> authorities;

}