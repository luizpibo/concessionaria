package com.concessionaria.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import javax.naming.AuthenticationException;

public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication)
        throws AuthenticationException;
}
