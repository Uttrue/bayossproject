package com.cynetcore.bayoss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cynetcore.bayoss.service.UserLikeService;
import com.cynetcore.bayoss.vo.UserLikeVo;

@Controller
@RequestMapping(value = "/userlike")
public class userLikeController {
	
	@Autowired
	private UserLikeService likeService;
	
	//like 입력 및 상태 변경
	@RequestMapping(value = "/likestatus", method = RequestMethod.GET)
	@ResponseBody
	public String likeinsert(UserLikeVo likeVo) {
		System.out.println("likeinsert, likeVo : " + likeVo);
		boolean result = false;
		//데이터 여부 조회
		UserLikeVo likeVoData = likeService.islikeexist(likeVo.getcid(), likeVo.getIno());
		System.out.println("likeinsert, likeVoData : " + likeVoData);
		//데이터 없으면 입력
		//있으면 상태 변경
		if(likeVoData != null) {
			if(likeVoData.getStatus() == "T" || likeVoData.getStatus().equals("T")) {
				likeService.likestatus("F", likeVoData.getLno());
				result = false;
			} else if(likeVoData.getStatus() == "F"  || likeVoData.getStatus().equals("F")) {
				result = likeService.likestatus("T", likeVoData.getLno());
				result = true;
			}
		} else {
			likeService.likeInsert(likeVo);
			result = true;
		}
		return String.valueOf(result);
	}
	
	//글 조회시 초기 좋아요 여부
	@RequestMapping(value = "/getislike", method = RequestMethod.GET)
	@ResponseBody
	public String getislike(String cid, int ino) {
		boolean result = false;
		UserLikeVo likeVoData = likeService.islikeexist(cid, ino);
		if(likeVoData != null) {
			if(likeVoData.getStatus() == "T" || likeVoData.getStatus().equals("T")) {
				result = true;
			} else if(likeVoData.getStatus() == "F"  || likeVoData.getStatus().equals("F")) {
				result = false;
			}
		}
		return String.valueOf(result);
	}
	
	//글 조회시 초기 좋아요 여부
	@RequestMapping(value = "/getcountlike", method = RequestMethod.GET)
	@ResponseBody
	public int getcountlike(String sid, int ino) {
		int count = likeService.getcountlike(sid, ino);
		return count;
	}
	
	//리스트 출력하기, 셀러, 커스터머 모두
}
