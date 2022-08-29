package com.cynetcore.bayoss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cynetcore.bayoss.service.HomeBoardService;
import com.cynetcore.bayoss.service.SellerItemService;
import com.cynetcore.bayoss.vo.HomeBoardVo;
import com.cynetcore.bayoss.vo.PagingDto;
import com.cynetcore.bayoss.vo.SellerItemVo;

@Controller
@RequestMapping(value = "/sub")
public class boardController {
	
	@Autowired
	private HomeBoardService homeBoardService;
	
	@Autowired
	private SellerItemService itemService;
	
	
	//서비스 인터넷 페이지 진입
	@RequestMapping(value = "/boardcontent", method = RequestMethod.GET)
	public String servicesInternet(String main_category, String detail_category, Model model) {
		List<HomeBoardVo> list = homeBoardService.boardSearch(main_category, detail_category);
		model.addAttribute("boardVo", list);
		return "sub/homeboard";
	}

	
	//쇼핑 전체 물품 리스트
	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String selllisthole(Model model, PagingDto pagingDto) {
		System.out.println("shoppinginfo, pagingDto" + pagingDto);
		List<SellerItemVo> itemlist = itemService.itemListhole(pagingDto);
		pagingDto.setCount(itemService.itemListholecount(pagingDto));
		pagingDto.setPage(pagingDto.getPage());
		model.addAttribute("itemlist", itemlist);
		model.addAttribute("pagingDto", pagingDto);
		System.out.println("shoppinginfo, pagingDto" + pagingDto);
		return "sub/shopping";
	}
	
	//쇼핑 전체 서비스 페이지 진입
	@RequestMapping(value = "/shoppinginfo", method = RequestMethod.GET)
	public String shoppinginfo(int ino,Model model) {
		System.out.println("shoppinginfo");
		SellerItemVo iteminfo = itemService.itemInfo(ino);
		model.addAttribute("iteminfo", iteminfo);
		return "sub/shoppinginfo";
	}
	
	//서비스 페이지 진입
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String board() {
	
		return "sub/review";
	}	
	
}
