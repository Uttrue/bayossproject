package com.cynetcore.bayoss.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cynetcore.bayoss.service.HomeBoardService;
import com.cynetcore.bayoss.service.SellerItemService;
import com.cynetcore.bayoss.util.SellerFileUploader;
import com.cynetcore.bayoss.vo.HomeBoardVo;
import com.cynetcore.bayoss.vo.PagingDto;
import com.cynetcore.bayoss.vo.SellerItemVo;

@Controller
@RequestMapping(value = "/admin")
public class adminController {
	
	@Autowired
	private HomeBoardService boardService;
	
//	final static String URLPATH = "bayoss/seller";
	final static String URLPATH = "C://bayossfile"; //로컬개발
//	final static String URLPATH = "/var/lib/tomcat9/webapps/ROOT/images/admin"; //서버 업로드용

	//홈 화면 등록 페이지
	@RequestMapping(value = "/adminboardform", method = RequestMethod.GET)
	public String adminboardform() {
		System.out.println("adminboardform");
		return "admin/adminboardform";
	}
	
	//카테고리 화면 입력 실행
	@RequestMapping(value = "/admininsertrun", method = RequestMethod.POST)
	public String admininsertrun(HomeBoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("admininsertrun, boardVo" + boardVo);
		boolean result = boardService.boardInsert(boardVo);
		rttr.addFlashAttribute("admininsertrun", result);
		return "redirect:/admin/adminhomelist";
	}
	
	//카테고리 리스트
	@RequestMapping(value = "/adminhomelist", method = RequestMethod.GET)
	public String adminhomelist(Model model) {
		System.out.println("adminhomelist");
		List<HomeBoardVo> list = boardService.boardList();
		model.addAttribute("homelist", list);
		return "admin/adminhomelist";
	}
	
	//썸머노트 이미지 업로드
	@ResponseBody
	@RequestMapping(value = "/uploadSummernoteImageFile", method = RequestMethod.POST)
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile file) throws Exception{
		String originalFilename = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		String imagename = SellerFileUploader.fileUpload(originalFilename, URLPATH, fileData);
	/*	SellerFileUploader.Connect();*/
	/*	String imagename =  SellerFileUploader.upload(originalFilename, URLPATH,file);
		SellerFileUploader.disconnect();*/
		return imagename;
	}
	
	//이미지 출력하기
	@ResponseBody
	@RequestMapping(value = "/displayimages", method = RequestMethod.GET)
	public byte[] displayimages(String filename) throws Exception{
		/*SellerFileUploader.Connect();*/
		/*	System.out.println("접속 됨");
		InputStream fis = SellerFileUploader.download(URLPATH, filename);*/
	//	FileInputStream fis = new FileInputStream("/"+URLPATH + filename);
	/*	System.out.println("displayimages : " +fis );
		byte[] data = IOUtils.toByteArray(fis);
		fis.close();
		SellerFileUploader.disconnect();*/
		FileInputStream fis = new FileInputStream(URLPATH+ "/" +filename);
		byte[] data = IOUtils.toByteArray(fis);
		fis.close();
		return data;
	}
	
	
}
