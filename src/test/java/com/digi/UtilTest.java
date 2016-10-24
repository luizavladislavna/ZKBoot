package com.digi;

import lombok.extern.slf4j.Slf4j;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.annotations.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Slf4j
public class UtilTest {

	@Test
	public void getPass(){
		String password = "123";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		log.debug(hashedPassword);
		//assertThat(hashedPassword).isEqualTo("$2a$10$TiBNCp.xipfpbVOia0uvy.Kj2Jou1Fq3ALEWtpa.zO0cuVDJXqOaa");
	}
}
