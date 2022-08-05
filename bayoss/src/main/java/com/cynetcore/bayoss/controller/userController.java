package com.cynetcore.bayoss.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cynetcore.bayoss.service.SellerService;
import com.cynetcore.bayoss.vo.SellerVo;

@Controller
@RequestMapping(value = "/user")
public class userController {
	
	@Autowired
	private SellerService sellerService;
	
	//전유저 FAQ 진입
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faqboard() {
	
		return "board/FAQ";
	}
	//전유저 FAQ 진입
	@RequestMapping(value = "/qanda", method = RequestMethod.GET)
	public String qanda() {
	
		return "board/qanda";
	}
	
	
	//전유저 회사소개 진입
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutus() {
	
		return "board/aboutus";
	}
	
	//회원가입
	@RequestMapping(value = "/joinus", method = RequestMethod.GET)
	public String joinus() {
	
		return "customer/joinus";
	}
	
	//회원가입
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	
		return "customer/login";
	}
	
}
