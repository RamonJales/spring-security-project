package br.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.entities.UserEntity;
import br.com.enuns.Role;
import br.com.repository.UserEntityRepository;

@Component
@Transactional
public class InitialPopulation implements CommandLineRunner{
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private PasswordEncoder enconder;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserEntity u1 = new UserEntity();
		u1.setUsername("ramon");
		u1.setPassword(enconder.encode("123"));
		u1.setRole(Role.ADMIN.getName());
		
		UserEntity u2 = new UserEntity();
		u2.setUsername("maria");
		u2.setPassword(enconder.encode("456"));
		u2.setRole(Role.USER.getName());
		
		UserEntity u3 = new UserEntity();
		u3.setUsername("bruna");
		u3.setPassword(enconder.encode("789"));
		u3.setRole(Role.USER.getName());
		
		userEntityRepository.save(u1);
		userEntityRepository.save(u2);
		userEntityRepository.save(u3);
		
		for (UserEntity user : userEntityRepository.findAll()) {
			System.out.println(user);
		}
	}
	
}
