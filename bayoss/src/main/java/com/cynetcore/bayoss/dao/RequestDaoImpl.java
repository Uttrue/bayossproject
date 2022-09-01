package com.cynetcore.bayoss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.RequestVo;

@Repository
public class RequestDaoImpl implements RequestDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.request.";
	
	@Override
	public boolean requestInsert(RequestVo requestVo) {
		int count = sqlSession.insert(NAMESPACE+"requestInsert", requestVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<RequestVo> requestList() {
		List<RequestVo> list = sqlSession.selectList(NAMESPACE+"requestList");
		return list;
	}

}
