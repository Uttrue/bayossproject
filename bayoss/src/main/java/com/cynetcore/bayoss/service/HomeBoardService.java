package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.HomeBoardVo;

public interface HomeBoardService {
	//메인 글쓰기
	public boolean boardInsert(HomeBoardVo boardVo);
	//섹션별 조회
	public List<HomeBoardVo> boardSearch(String main_category, String detail_category);
	//보드 리스트 조회
	public List<HomeBoardVo> boardList();
}
