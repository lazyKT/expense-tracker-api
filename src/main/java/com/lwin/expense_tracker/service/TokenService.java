package com.lwin.expense_tracker.service;

import com.lwin.expense_tracker.config.RsaKeyProperties;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);
    private final JwtDecoder decoder;
    private final JwtEncoder encoder;

    @Autowired
    public TokenService (RsaKeyProperties rsaKeyProperties) {
        JWK jwk = new RSAKey.Builder(rsaKeyProperties.publicKey()).privateKey(rsaKeyProperties.privateKey()).build();
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
        this.encoder = new NimbusJwtEncoder(jwkSource);
        this.decoder = NimbusJwtDecoder.withPublicKey(rsaKeyProperties.publicKey()).build();
    }


    public String generateToken (String userName) {
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(userName)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    public String getSubjectFromToken (String token) {
        Jwt jwt = this.decoder.decode(token);
        return jwt.getSubject();
    }

    public Boolean isTokenExpired (String token) {
        Jwt jwt = this.decoder.decode(token);
        return jwt.getExpiresAt() != null && jwt.getExpiresAt().isBefore(Instant.now());
    }

    public Boolean validateToken (String token, UserDetails userDetails) {
        String username = this.getSubjectFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
 }
