package com.digi;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class Application {

	public static void main (String[] args) {
		log.info("testService:, {}", "testService");
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home () {
		return "hi!";
	}

}
