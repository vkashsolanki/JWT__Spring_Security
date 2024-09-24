package com.jwt.security.secutities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtHelper {

	// requirement
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	private String secret = "afafafafafafafafafafafafafafafafafafafa";

	// retreive username form token
	public String getUsernameFromToken(String token) {

		return getClaimFromToken(token, Claims::getSubject);

	}

	// retrieve expirations date from jwt token
	public Date getExpirationDateFromToken(String token) {
		
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> ) {

	}

	// for retrieving any informations form token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// Check if the token has expired
	private boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDataFromToken(token);
		return expiration.before(new Date());

	}

	// generate token for user

	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());

	}

	// while creating token ::==>>
	// 1. define claims of the token like Issuer, Exipration, Subject, and id
	// 2. Sign the jwt using the HS512 algorithm and secret key
	// 3. According to jws compact Serialization()

	// compaction of the JWT to a safe-URL String
	public String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuer(new JwtHelper())i
	}

	// validate token
	public boolean validataToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
