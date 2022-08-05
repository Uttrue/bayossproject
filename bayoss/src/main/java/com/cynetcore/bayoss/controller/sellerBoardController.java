package com.cynetcore.bayoss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cynetcore.bayoss.service.SellerItemService;
import com.cynetcore.bayoss.util.SellerFileUploader;
import com.cynetcore.bayoss.vo.SellerItemVo;

@Controller
@RequestMapping(value = "/sellerboard")
public class sellerBoardController {
	
	@Autowired
	private SellerItemService itemService;
	

	//셀러 물품 등록 페이지
	@RequestMapping(value = "/sellerboardform", method = RequestMethod.GET)
	public String sellinsert() {
		System.out.println("sellerboardform");
		return "sellerboard/sellerboardform";
	}
	
	//셀러 물품 등록 실행
	@RequestMapping(value = "/sellinsertrun", method = RequestMethod.POST)
	public String sellinsertrun(SellerItemVo itemVo, MultipartFile file) throws Exception {
		System.out.println("sellinsertrun, itemVo" + itemVo);
		long size = file.getSize();
		System.out.println("sellinsertrun, file" + file);
		if(size != 0) {
			String originalFilename = file.getOriginalFilename();
			System.out.println("sellinsertrun, originalFilename" + originalFilename);
			byte[] fileData = file.getBytes();
			String imagename =  SellerFileUploader.fileUpload(originalFilename, "/bayoss/seller",file);
			itemVo.setItem_mainimage(imagename);
			System.out.println("sellinsertrun, imagename" + imagename);
			System.out.println("sellinsertrun, itemVo" + itemVo);
	//		String imagename = SellerFileUploader.fileUpload("dev.harbormax.com/bayoss/seller", file.getOriginalFilename(), fileData);
	//		itemVo.setItem_mainimage(imagename);
			//FTP 서버로 파일 전송하는것 만들기
		}
		
	//	boolean result = itemService.itemInsert(itemVo);
		return "redirect:/sellerboard/sellList";
	}
	
	//셀러 물품 리스트
	@RequestMapping(value = "/selllist", method = RequestMethod.GET)
	public String selllist(int seller_reg_no) {
	
		return "sellerboard/sellList";
	}
	
	//셀러 물품 등록 페이지
	@RequestMapping(value = "/sellupdate", method = RequestMethod.GET)
	public String sellupdate() {
	
		return "sellerboard/sellupdateForm";
	}
	
	//셀러 물품 업데이트 실행
	@RequestMapping(value = "/sellupdaterun", method = RequestMethod.POST)
	public String sellupdaterun() {
	
		return "sellerboard/sellList";
	}
	
	//셀러 물품 업데이트 실행
	@RequestMapping(value = "/sellstatus", method = RequestMethod.POST)
	public String sellstatus() {
	
		return "sellerboard/sellList";
	}
	
	//셀러 물품 삭제
	@RequestMapping(value = "/selldelete", method = RequestMethod.GET)
	public String selldelete() {
	
		return "sellerboard/sellList";
	}
	
}
