package com.bezbjednost.InformacionaBezbjednost.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.bezbjednost.InformacionaBezbjednost.security.model.JwtAuthenticationToken;




public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
    	
    	super("/api/auth/**"); 
        
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

    	return Optional.of(httpServletRequest).map(req -> req.getHeader("Authorization"))
				  	   						  .filter(token -> !token.isEmpty())
				  	   						  .map(token -> token.replace("Bearer ", ""))
				  	   						  .map(JwtAuthenticationToken::new)
				  	   						  .map(token -> getAuthenticationManager().authenticate(token))
				  	   						  .orElseThrow(() -> new BadCredentialsException("Invalid or missing token!"));
        
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    	
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
        
    }
       
}