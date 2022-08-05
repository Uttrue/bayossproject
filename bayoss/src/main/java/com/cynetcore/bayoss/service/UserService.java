package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.UserVo;

public interface UserService {
	//유저 등록
	public boolean userInsert(UserVo userVo);
	//유저 아이디 중복 조회
	public boolean isuserexist(String cid);
	//유저 정보 조회
	public UserVo userInfo(UserVo userVo);
	//유저 정보 업데이트
	public boolean userUpdate(UserVo userVo);
	//유저 삭제
	public boolean userDelete(UserVo userVo);
	//유저 리스트
	public List<UserVo> userList();
	
}
