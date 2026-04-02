package com.basicproject.security;

import com.basicproject.model.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  private final SecretKey key;
  private final long accessExpirationMs;
  private final long refreshExpirationMs;

  public JwtService(
      @Value("${jwt.secret}") String secret,
      @Value("${jwt.access-expiration-minutes}") long accessMinutes,
      @Value("${jwt.refresh-expiration-days}") long refreshDays) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    this.accessExpirationMs = accessMinutes * 60 * 1000;
    this.refreshExpirationMs = refreshDays * 24 * 60 * 60 * 1000;
  }

  public String generateAccessToken(AppUser user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("type", "access");
    claims.put("username", user.getUsername());
    if (user.getProfile() != null && user.getProfile().getRole() != null) {
      claims.put("role", user.getProfile().getRole().name());
    }
    return buildToken(claims, user.getUsername(), accessExpirationMs);
  }

  public String generateRefreshToken(String username) {
    Map<String, Object> claims = Map.of("type", "refresh", "username", username);
    return buildToken(claims, username, refreshExpirationMs);
  }

  private String buildToken(Map<String, Object> extraClaims, String subject, long ttlMs) {
    Date now = new Date();
    return Jwts.builder()
        .claims(extraClaims)
        .subject(subject)
        .issuedAt(now)
        .expiration(new Date(now.getTime() + ttlMs))
        .signWith(key)
        .compact();
  }

  public String extractUsername(String token) {
    return parseClaims(token).getSubject();
  }

  public boolean isAccessToken(String token) {
    return "access".equals(parseClaims(token).get("type", String.class));
  }

  public boolean isRefreshToken(String token) {
    return "refresh".equals(parseClaims(token).get("type", String.class));
  }

  public boolean isTokenValid(String token, String expectedUsername) {
    try {
      Claims c = parseClaims(token);
      return c.getSubject().equals(expectedUsername) && c.getExpiration().after(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  private Claims parseClaims(String token) {
    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
  }
}
