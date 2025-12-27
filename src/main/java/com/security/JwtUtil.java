package com.example.demo.security;


public class JwtUtil {


private final String secret;
private final long validityInMs;
private final boolean isTestMode;


public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
this.secret = secret;
this.validityInMs = validityInMs;
this.isTestMode = isTestMode;
}
}