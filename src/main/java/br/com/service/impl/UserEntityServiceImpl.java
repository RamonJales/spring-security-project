package br.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.entities.UserEntity;
import br.com.repository.UserEntityRepository;
import br.com.service.UserEntityService;

public class UserEntityServiceImpl implements UserEntityService{

	@Autowired
	UserEntityRepository userEntityRepository;
	
	@Override
	public Optional<UserEntity> findById(Integer id) {
		return userEntityRepository.findById(id);
	}

	@Override
	public UserEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return userEntityRepository.findByUsername(username);
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userEntityRepository.findAll();
	}

	@Override
	public void save(UserEntity article) {
		// TODO Auto-generated method stub
		userEntityRepository.save(article);
	}

}
