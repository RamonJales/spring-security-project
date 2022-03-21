package br.com.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.entities.UserEntity;
import br.com.repository.UserEntityRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userEntityRepository.findByUsername(username);
		if (userEntity != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userEntity.getRole());
			Set<GrantedAuthority> authories = new HashSet<>();
			authories.add(authority);
			User user = new User(userEntity.getUsername() , userEntity.getPassword() , authories);
			return user;
		}
		else {
			return null;
		}
	}
}
