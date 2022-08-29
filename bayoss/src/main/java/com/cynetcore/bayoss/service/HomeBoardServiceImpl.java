package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.HomeBoardDao;
import com.cynetcore.bayoss.vo.HomeBoardVo;

@Service
public class HomeBoardServiceImpl implements HomeBoardService {

	@Autowired
	private HomeBoardDao homeBoardDao;
	
	//보드 글쓰기
	@Override
	public boolean boardInsert(HomeBoardVo boardVo) {
		boolean result = homeBoardDao.boardInsert(boardVo);
		return result;
	}

	//보드 글 출력
	@Override
	public List<HomeBoardVo> boardSearch(String main_category, String detail_category) {
		List<HomeBoardVo> list = homeBoardDao.boardSearch(main_category, detail_category);
		return list;
	}

	//보드 글 전체 출력
	@Override
	public List<HomeBoardVo> boardList() {
		List<HomeBoardVo> list = homeBoardDao.boardList();
		return list;
	}

}
