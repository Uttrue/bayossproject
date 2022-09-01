package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.RequestVo;

public interface RequestService {
	//서비스 요청 저장
	public boolean requestInsert(RequestVo requestVo);
	//서비스 목록 리스트
	public List<RequestVo> requestList();
}
