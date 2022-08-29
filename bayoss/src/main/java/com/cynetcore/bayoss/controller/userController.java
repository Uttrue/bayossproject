package com.cynetcore.bayoss.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cynetcore.bayoss.service.UserService;
import com.cynetcore.bayoss.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	
	//회원가입 진입
	@RequestMapping(value = "/joinus", method = RequestMethod.GET)
	public String joinus() {
	
		return "customer/joinus";
	}
	
	//로그인 진입
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	
		return "customer/login";
	}
	
	//리뷰쓰기
	@RequestMapping(value = "/writeform", method = RequestMethod.GET)
	public String writeform() {
	
		return "customer/writeform";
	}
	
	//유저 아이디 중복 조회
	@RequestMapping(value = "/isuserexist", method = RequestMethod.GET)
	@ResponseBody
	public String isuserexist(String cid) {
		boolean result = userService.isuserexist(cid);
		return String.valueOf(result);
	}
	
	//셀러 회원가입 실행
	@RequestMapping(value = "/userjoinrun", method = RequestMethod.POST)
	public String userjoinrun(UserVo userVo, RedirectAttributes rttr) {
		System.out.println("sellerVo : " + userVo);
		boolean result = userService.userInsert(userVo);
		rttr.addFlashAttribute("join_result", result);
		return "redirect:/";
	}
	
	//유저 로그인
	@RequestMapping(value = "/userloginrun", method = RequestMethod.POST)
	public String userloginrun(String cid,String cpw, HttpSession session) {
//			System.out.println("sellerloginrun, cid : " + cid);
//			System.out.println("sellerloginrun, cpw : " + cpw);
		UserVo userVo = userService.userlogin(cid,cpw);
		if(userVo != null) {
			session.setAttribute("userVo", userVo);
			return "redirect:/";
		}
			return "redirect:/user/login";
		
		
	}
	
	//유저 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userlogout(HttpSession session) {
		session.removeAttribute("userVo");
		
		return "redirect:/";
	}
	
	//제일 하단에 두기
	//셀러 이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheck(String email) {
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* 이메일 보내기 */
        String setFrom = "andy1324@naver.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "베이오스 홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + " 입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return Integer.toString(checkNum);
	}
	
}
