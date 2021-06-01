package com.bezbjednost.InformacionaBezbjednost.security.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class JwtUser {
	
	private long id;
    private String random;
    private String token;
    

    
    
 
}
