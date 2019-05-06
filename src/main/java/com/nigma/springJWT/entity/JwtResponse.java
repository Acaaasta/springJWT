package com.nigma.springJWT.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
  private String token;
  private String type = "Bearer";

  public JwtResponse(String token) {
    this.token = token;
  }
}