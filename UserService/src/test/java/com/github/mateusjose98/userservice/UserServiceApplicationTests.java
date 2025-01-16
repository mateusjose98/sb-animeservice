package com.github.mateusjose98.userservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mateusjose98.userservice.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfigs.class)
class UserServiceApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private User user;

	@Test
	void contextLoads() throws JsonProcessingException {
		String s = objectMapper.writeValueAsString(user);
		System.out.println(s);
	}

}
