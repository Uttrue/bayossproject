package com.cynetcore.bayoss.controller;

import java.io.FileInputStream;
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

import com.cynetcore.bayoss.service.SellerItemService;
import com.cynetcore.bayoss.util.SellerFileUploader;
import com.cynetcore.bayoss.vo.PagingDto;
import com.cynetcore.bayoss.vo.SellerItemVo;

@Controller
@RequestMapping(value = "/sellerboard")
public class sellerBoardController {
	
	@Autowired
	private SellerItemService itemService;
	
//	final static String URLPATH = "bayoss/seller";
//	final static String URLPATH = "C://bayossfile"; //로컬개발
	final static String URLPATH = "/var/lib/tomcat9/webapps/ROOT/images"; //서버 업로드용

	//셀러 물품 등록 페이지
	@RequestMapping(value = "/sellerboardform", method = RequestMethod.GET)
	public String sellinsert() {
		System.out.println("sellerboardform");
		return "sellerboard/sellerboardform";
	}
	
	//셀러 물품 등록 실행
	@RequestMapping(value = "/sellinsertrun", method = RequestMethod.POST)
	public String sellinsertrun(SellerItemVo itemVo, MultipartFile file, RedirectAttributes rttr, 
										HttpSession session) throws Exception {
		System.out.println("sellinsertrun, itemVo" + itemVo);
		long size = file.getSize();
		System.out.println("sellinsertrun, file" + file);
		if(size != 0) {
			String originalFilename = file.getOriginalFilename();
			System.out.println("sellinsertrun, originalFilename" + originalFilename);
			byte[] fileData = file.getBytes();
			String uploadFileName = SellerFileUploader.fileUpload(originalFilename, URLPATH, fileData);
			itemVo.setItem_mainimage(uploadFileName);
			
	/*		SellerFileUploader.Connect();*/
	/*		String imagename =  SellerFileUploader.upload(originalFilename, URLPATH,file);*/
	/*		SellerFileUploader.disconnect();*/
	/*		itemVo.setItem_mainimage(imagename);*/
	/*		System.out.println("sellinsertrun, imagename" + imagename);*/
			System.out.println("sellinsertrun, itemVo" + itemVo);
	//		String imagename = SellerFileUploader.fileUpload("dev.harbormax.com/bayoss/seller", file.getOriginalFilename(), fileData);
	/*		itemVo.setItem_mainimage(imagename);*/
			//등록후 글 보기 창으로 이동. 목록 리스트 생성. 페이징
		}
		//세션에 정보 다시 저장
		
		boolean result = itemService.itemInsert(itemVo);
		rttr.addFlashAttribute("insert_result", result);
		return "redirect:/sellerboard/selllist?sid="+ itemVo.getSid();
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
	
	//셀러 물품 리스트
	@RequestMapping(value = "/selllist", method = RequestMethod.GET)
	public String selllist(String sid, Model model,PagingDto pagingDto) {
		System.out.println("selllist, pagingDto앞" + pagingDto);
		List<SellerItemVo> itemlist = itemService.itemList(sid,pagingDto);
		pagingDto.setCount(itemService.itemListcount(sid,pagingDto));
		pagingDto.setPage(pagingDto.getPage());
		model.addAttribute("itemlist", itemlist);
		model.addAttribute("pagingDto", pagingDto);
		System.out.println("selllist, pagingDto뒤" + pagingDto);
		return "sellerboard/sellerboardlist";
	}
	
	//셀러 물품 상세보기
	@RequestMapping(value = "/iteminfo", method = RequestMethod.GET)
	public String selliteminfo(int ino, Model model) {
		SellerItemVo iteminfo = itemService.itemInfo(ino);
		model.addAttribute("iteminfo", iteminfo);
		
		return "sellerboard/sellerboardread";
	}
	
	//셀러 물품 업데이트 페이지
	@RequestMapping(value = "/sellupdateform", method = RequestMethod.GET)
	public String sellupdate(int ino, Model model) {
		SellerItemVo iteminfo = itemService.itemInfo(ino);
		model.addAttribute("iteminfo", iteminfo);
		return "sellerboard/sellerboardupdateform";
	}
	
	
	//셀러 물품 업데이트 실행
	@RequestMapping(value = "/sellupdaterun", method = RequestMethod.POST)
	public String sellupdaterun(SellerItemVo itemVo, MultipartFile file, RedirectAttributes rttr,HttpSession session) throws Exception {
		System.out.println("sellupdaterun : " + itemVo);
		long size = file.getSize();
		if(size == 0) {
			SellerItemVo iteminfo = itemService.itemInfo(itemVo.getIno());
			String mainimage = iteminfo.getItem_mainimage();
			itemVo.setItem_mainimage(mainimage);
			System.out.println("sellupdaterun : " + itemVo);
		} else {
			
			System.out.println("sellinsertrun, file" + file);
			if(size != 0) {
				String originalFilename = file.getOriginalFilename();
				System.out.println("sellinsertrun, originalFilename" + originalFilename);
		//		byte[] fileData = file.getBytes();
		/*		SellerFileUploader.Connect();*/
		/*		String fileimagename =  SellerFileUploader.upload(originalFilename, URLPATH,file);*/
		//		SellerFileUploader.disconnect();
				byte[] fileData = file.getBytes();
				String uploadFileName = SellerFileUploader.fileUpload(originalFilename, URLPATH, fileData);
				itemVo.setItem_mainimage(uploadFileName);
				System.out.println("sellinsertrun, imagename" + uploadFileName);
				System.out.println("sellinsertrun, itemVo" + itemVo);
		//		String imagename = SellerFileUploader.fileUpload("dev.harbormax.com/bayoss/seller", file.getOriginalFilename(), fileData);
				itemVo.setItem_mainimage(uploadFileName);
			}
		}
		//세션에 정보 다시 저장
		boolean result = itemService.itemUpdate(itemVo);
		rttr.addFlashAttribute("update_result", result);
		return "redirect:/sellerboard/iteminfo?ino="+ itemVo.getIno();
	}
	
	//셀러 물품 업데이트 실행
	@RequestMapping(value = "/sellstatus", method = RequestMethod.POST)
	public String sellstatus() {
	
		return "sellerboard/sellList";
	}
	
	
	//셀러 물품 삭제
	@RequestMapping(value = "/selldelete", method = RequestMethod.GET)
	public String selldelete(SellerItemVo sellerItemVo, RedirectAttributes rttr) {
		System.out.println("sellerItemVo : " + sellerItemVo);
		sellerItemVo.setItem_delete("T");
		System.out.println("sellerItemVo : " + sellerItemVo);
		boolean result = itemService.itemDelete(sellerItemVo);
		rttr.addFlashAttribute("delete_result", result);
		return "redirect:/sellerboard/selllist?sid="+ sellerItemVo.getSid();
	}
	

	
}
