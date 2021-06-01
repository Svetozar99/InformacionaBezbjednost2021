package com.bezbjednost.InformacionaBezbjednost.security;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;
import com.bezbjednost.InformacionaBezbjednost.security.model.JwtUser;
import com.bezbjednost.InformacionaBezbjednost.security.model.JwtUserDetails;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl.KorisnikService;




@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private KorisnikService userService;

  private JwtUser jwtUser;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    
	Korisnik user = userService.findOne(Long.valueOf(id));
	
	return Optional.ofNullable(user).map(u -> JwtUserDetails.builder()
															.id(jwtUser.getId())
															.random(jwtUser.getRandom())
															.token(jwtUser.getToken())
															.authorities(getAuth(u))
															.build())
									.orElseThrow(IllegalArgumentException::new);

  }
  
  public void setJwtUser(JwtUser jwtUser) {
	  this.jwtUser = jwtUser;
  }
  
  private Collection<? extends GrantedAuthority> getAuth(Korisnik u){

	  return AuthorityUtils.createAuthorityList(u.getKorisnikAuthorities()
			  									 .stream()
			  									 .flatMap(usersAuthority -> Stream.of(String.valueOf(usersAuthority.getAuthority().getUloga().toString())))
			  									 .toArray(String[]::new));
  }

}
