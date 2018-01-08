package com.email.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


//@Configuration
public class SpringEmailJamesConfig {
	@Bean
	public MailSender mailSender(){
		Properties properties =new Properties();
		properties.setProperty("mail.debug", "true");
		
		JavaMailSenderImpl mailSender =new JavaMailSenderImpl();
		mailSender.setJavaMailProperties(properties);
		mailSender.setHost("127.0.0.1");
		mailSender.setPort(25);
		mailSender.setUsername("yuan");
		mailSender.setPassword("123456");
		return mailSender;
	}
}
