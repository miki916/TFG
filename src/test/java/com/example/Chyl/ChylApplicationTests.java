package com.example.Chyl;

import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Repositorys.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChylApplicationTests {

	@Autowired
	private UserRepository repo;

	@Test
	void contextLoads() {

		UserModel user = new UserModel();

		user.setUsername("Miguel");
		user.setPasswd("123");

		repo.save(user);



	}

}
