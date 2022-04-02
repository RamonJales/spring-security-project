package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.entities.UserEntity;

@Component
public interface UserEntityService {
	Optional<UserEntity> findById(Integer id);
	UserEntity findByUsername(String username);
	List<UserEntity> findAll();
	void save(UserEntity article);
}
