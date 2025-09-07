package com.project.Swimming_coach.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final Key secretKey = Keys.hmacShaKeyFor("your-256-bit-secret-your-256-bit-secret".getBytes());

    public String generateToken(String username , String role , String status)
    {
        return  Jwts.builder()
                .setSubject(username)
                .claim("role",role)
                .claim("status",status)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(secretKey,SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7)) // 7 days
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean isTokenValid(String token , String username)
    {
        return username.equals(extractUsername(token))&& !isTokenExpired(token);
    }
    public String extractUsername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }
    public String extractRole(String token)
    {
        return  extractAllClaims(token).get("role",String.class);
    }
    public String extractStatus(String token)
    {
        return  extractAllClaims(token).get("status",String.class);
    }



    public <T>T extractClaim(String token , Function <Claims,T> resolver)
    {
        return resolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
    private boolean isTokenExpired(String token)
    {
        return extractClaim(token,Claims::getExpiration).before(new Date());
    }
}
