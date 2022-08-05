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
@RequestMapping(value = "/sub")
public class boardController {
	
	@Autowired
	private SellerService sellerService;
	
	

	//서비스 페이지 진입
	@RequestMapping(value = "/maintenence", method = RequestMethod.GET)
	public String maintenence() {
	
		return "sub/maintenence";
	}
	//서비스 페이지 진입
	@RequestMapping(value = "/supplies", method = RequestMethod.GET)
	public String supplies() {
	
		return "sub/supplies";
	}
	//서비스 페이지 진입
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String services() {
	
		return "sub/services";
	}	

	//서비스 페이지 진입
	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String shopping() {
	
		return "sub/shopping";
	}	
	//서비스 페이지 진입
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String board() {
	
		return "sub/review";
	}	
	
}
