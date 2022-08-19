package com.cynetcore.bayoss.controller;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cynetcore.bayoss.service.SellerItemService;
import com.cynetcore.bayoss.service.SellerService;
import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerItemVo;
import com.cynetcore.bayoss.vo.SellerVo;

@Controller
@RequestMapping(value = "/seller")
public class sellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerItemService sellerItemService;
	
	@Autowired
	private JavaMailSender mailSender;

	//셀러 기본 홈 - 로그인창 - 모든정보 보기가능
	@RequestMapping(value = "/sellerlogin", method = RequestMethod.GET)
	public String sellerlogin(HttpSession session) {
		SellerVo sellerVo = (SellerVo) session.getAttribute("sellerVo");
		SellStoreVo storeInfo = (SellStoreVo) session.getAttribute("storeInfo");
		if(sellerVo != null) {
			if(storeInfo != null) {
				session.setAttribute("storeInfo", storeInfo);
				return "seller/sellermain";
			} else if(storeInfo == null) {
				return "seller/sellstorejoin";
			}
		}
		
			return "seller/sellerlogin";
		
	}
	
	//셀러 기본 홈 - 로그인실행 메인화면이동
	@RequestMapping(value = "/sellerloginrun", method = RequestMethod.POST)
	public String sellerloginrun(String sid,String spw, HttpSession session) {
//		System.out.println("sellerloginrun, sid : " + sid);
//		System.out.println("sellerloginrun, spw : " + spw);
		SellerVo sellerVo = sellerService.sellerlogin(sid, spw);
		if(sellerVo != null) {
			session.setAttribute("sellerVo", sellerVo);
			//셀러 스토어 조회
			SellStoreVo storeInfo = sellerService.sellerStoreInfo(sellerVo.getSid());
			if(storeInfo != null) {
				//셀러 스토어 있을때 셀러관리홈화면
				session.setAttribute("storeInfo", storeInfo);
				//셀러 아이템 리스트
				List<SellerItemVo> itemlist = sellerItemService.selleritemList(sellerVo.getSid());
				session.setAttribute("itemlist", itemlist);
				//셀러 아이템 리스트 갯수
				int listcount = sellerItemService.itemListcount(sellerVo.getSid());
				session.setAttribute("itemcount", listcount);
				//셀러 아이템 상태 갯수
				int statuscountT = sellerItemService.itemListcountTF(sellerVo.getSid(), "T");
				int statuscountF = sellerItemService.itemListcountTF(sellerVo.getSid(), "F");
				session.setAttribute("statuscountT", statuscountT);
				session.setAttribute("statuscountF", statuscountF);
				return "seller/sellermain";
			} else if(storeInfo == null) {
				//셀러 스토어 없을때 스토어 등록 화면
				return "seller/sellstorejoin";
			}
		}	
			return "redirect:/seller/sellerlogin";
		
		
	}
	
	//셀러 로그아웃
	@RequestMapping(value = "/sellerlogout", method = RequestMethod.GET)
	public String sellerlogout(HttpSession session) {
		session.removeAttribute("sellerVo");
		session.removeAttribute("storeInfo");
		return "redirect:/";
	}
	
	
	//셀러 회원가입 양식
	@RequestMapping(value = "/sellerjoin", method = RequestMethod.GET)
	public String sellerJoin() {
	
		return "seller/sellerjoin";
	}
	
	//셀러 아이디 중복체크
	@RequestMapping(value = "/issellerexist", method = RequestMethod.GET)
	@ResponseBody
	public String issellerexist(String sid) {
		boolean result = sellerService.issellerexist(sid);
		return String.valueOf(result);
	}
	
	
	//셀러 회원가입 실행
	@RequestMapping(value = "/sellerjoinrun", method = RequestMethod.POST)
	public String sellerjoinrun(SellerVo sellerVo, RedirectAttributes rttr) {
		System.out.println("sellerVo : " + sellerVo);
		boolean result = sellerService.sellerInsert(sellerVo);
		rttr.addFlashAttribute("join_result", result);
		return "redirect:/seller/sellerlogin";
	}
	
	//셀러 업데이트 양식
	@RequestMapping(value = "/sellerupdateform", method = RequestMethod.GET)
	public String sellerupdateform(String sid, Model model) {
		SellerVo sellerVo = sellerService.sellerInfo(sid);
		model.addAttribute("sellerVo", sellerVo);
		return "seller/sellerupdateform";
	}
	//셀러 업데이트 실행
	@RequestMapping(value = "/sellerupdaterun", method = RequestMethod.POST)
	public String sellerupdaterun(SellerVo sellerVo, RedirectAttributes rttr, HttpSession session) {
		boolean result = sellerService.sellerUpdate(sellerVo);
		System.out.println("sellerupdaterun sellerVo : " + sellerVo);
		rttr.addFlashAttribute("update_result", result);
		if(result == true) {
			session.setAttribute("sellerVo", sellerVo);
		}
		return "redirect:/seller/sellerupdateform";
	}
	
	
	//스토어 부분
	//셀러스토어 회원가입 양식
	@RequestMapping(value = "/sellstoreform", method = RequestMethod.GET)
	public String sellstoreform() {
	
		return "seller/sellstorejoin";
	}
	
	//셀러 스토어 등록  실행
	@RequestMapping(value = "/sellstorereg", method = RequestMethod.POST)
	public String sellstorereg(SellerVo sellerVo, RedirectAttributes rttr) {
		System.out.println("sellerVo : " + sellerVo);
		boolean result = sellerService.sellerInsert(sellerVo);
		rttr.addFlashAttribute("join_result", result);
		return "redirect:/seller/sellerhome";
	}
	
	//셀러스토어 업데이트 양식
	@RequestMapping(value = "/sellstoreupdateform", method = RequestMethod.GET)
	public String sellstoreupdateform(String sid, Model model) {
		SellStoreVo sellerStoreInfo = sellerService.sellerStoreInfo(sid);
		model.addAttribute("sellerStoreInfo", sellerStoreInfo);
		return "seller/sellstoreupdateform";
	}
	//셀러 스토어 업데이트 실행
	
	
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
