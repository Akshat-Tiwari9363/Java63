package com.jwt.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private String secretKey="";

    public JWTService() {
        try {
            KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk =keyGen.generateKey();
            secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username){
        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder()
        .claims()
        .add(claims)
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+60*60*30))
        .and()
        .signWith(getKey())
        .compact();
    }

    private SecretKey getKey(){
        byte[] keyBytes=Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
    return Jwts.parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        return expiration.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            String username = extractUserName(token);
        
            return username.equals(userDetails.getUsername())
                    && !isTokenExpired(token);
        
        } catch (Exception e) {
            return false;
        }
    }

}
