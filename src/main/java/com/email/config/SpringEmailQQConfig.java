package com.email.config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

@Configuration

public class SpringEmailQQConfig {
	@Bean
	public Session session() {
		Properties props = new Properties();
		// 出现530错误就要使用
		// ssl验证
		MailSSLSocketFactory sf = null;
		;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.port", "465");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		return session;

	}

	@Bean
	public MailSender mailSender(Session session) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("992572472@qq.com");
		mailSender.setPassword("uwosoaomadwobceh");
		mailSender.setSession(session);
		return mailSender;
	}

}
