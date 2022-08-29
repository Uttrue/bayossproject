package com.cynetcore.bayoss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.search.RecipientTerm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.HomeBoardVo;

@Repository
public class HomeBoardDaoImpl implements HomeBoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.homeboard.";
	
	//보드 글쓰기
	@Override
	public boolean boardInsert(HomeBoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "boardInsert", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	//보드 조회
	@Override
	public List<HomeBoardVo> boardSearch(String main_category, String detail_category) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("main_category", main_category);
		parameter.put("detail_category", detail_category);
		List<HomeBoardVo> homelist = sqlSession.selectList(NAMESPACE + "boardSearch", parameter);
		return homelist;
	}

	//보드 리스트
	@Override
	public List<HomeBoardVo> boardList() {
		List<HomeBoardVo> homelist = sqlSession.selectList(NAMESPACE + "boardList");
		return homelist;
	}

}
