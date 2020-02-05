package edu.miu.cs.cs544.ether.auth.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public @Data class AutheticationResponse {
    private final String jwt;
}
