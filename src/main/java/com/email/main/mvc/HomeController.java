package com.email.main.mvc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping
public class HomeController {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	private InternalResourceViewResolver viewResolver;

	@RequestMapping({ "/", "home" })
	public String home() {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("992572472@qq.com");
		mailMessage.setTo("992572472@qq.com");
		mailMessage.setSubject("月亮代表我的心");
		mailMessage
				.setText("你问我爱你有多深，我爱你有几分，我的情也真，我的爱也真，你问我爱你有多深，我爱你有几分，我的情不移"
						+ "我的爱不变,月亮代表我的心,轻轻的一个吻,已经打动我的心,深深的一段情,叫我思念到如今,你问我爱你有多深,"
						+ "我爱你有几分你去想一想，你去看一看，月亮代表我的心，轻轻的一个吻，已经打动我的心，深深的一段情，叫我思念到如今，"
						+ "你问我爱你有多深，我爱你有几分，你去想一想，你去看一看，月亮代表我的心，你去想一想，你去看一看，月亮代表我的心");
		mailSender.send(mailMessage);
		return "index";
	}
}
