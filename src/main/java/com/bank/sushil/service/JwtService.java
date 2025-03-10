package com.bank.sushil.service;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	@Value("${jwtSecretKey}")
	private static String jwtSecretKey;

	//1 day
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 1;

	public SecretKey generateSecretKey() {
		byte[] keyBytes = jwtSecretKey.getBytes();
		return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
	}

	public String generateToken(String username) {

		Date now = new Date();
		Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder().subject(username).issuedAt(now).expiration(expiration).signWith(generateSecretKey())
				.compact();
	}

	public Claims extractClaims(String token) {
		return Jwts.parser().verifyWith(generateSecretKey()).build().parseSignedClaims(token).getPayload();
	}

	public String extractSubject(String token) {
		return extractClaims(token).getSubject();
	}

	public boolean isTokenExpired(String token) {
		return new Date().before(extractExpiration(token));
	}

	public Date extractExpiration(String token) {
		return extractClaims(token).getExpiration();
	}

}
