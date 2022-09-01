package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.RequestDao;
import com.cynetcore.bayoss.vo.RequestVo;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestDao requestDao;
	
	@Override
	public boolean requestInsert(RequestVo requestVo) {
		boolean result = requestDao.requestInsert(requestVo);
		return result;
	}

	@Override
	public List<RequestVo> requestList() {
		List<RequestVo> list = requestDao.requestList();
		return list;
	}

}
