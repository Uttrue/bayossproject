package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.SellerDao;
import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerVo;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerDao sellerDao;
	
	//셀러 등록
	@Override
	public boolean sellerInsert(SellerVo sellerVo) {
		boolean result = sellerDao.sellerInsert(sellerVo);
		return result;
	}
	//셀러 아이디 중복 조회
	@Override
	public boolean issellerexist(String sid) {
		boolean result = sellerDao.issellerexist(sid);
		return result;
	}

	//셀러 로그인
	@Override
	public SellerVo sellerlogin(String sid, String spw) {
		SellerVo sellerVo = sellerDao.sellerlogin(sid, spw);
		return sellerVo;
	}

	
	//셀러 정보 조회
	@Override
	public SellerVo sellerInfo(SellerVo sellerVo) {
		SellerVo sellerinfo = sellerDao.sellerInfo(sellerVo);
		return sellerinfo;
	}
	//셀러 정보 업데이트
	@Override
	public boolean sellerUpdate(SellerVo sellerVo) {
		boolean result = sellerDao.sellerUpdate(sellerVo);
		return result;
	}
	//셀러 삭제
	@Override
	public boolean sellerDelete(SellerVo sellerVo) {
		boolean result = sellerDao.sellerDelete(sellerVo);
		return result;
	}
	//셀러 리스트
	@Override
	public List<SellerVo> sellerList() {
		List<SellerVo> sellerList = sellerDao.sellerList();
		return sellerList;
	}
	//셀러 업체 등록
	@Override
	public boolean sellerStoreReg(SellStoreVo storeVo) {
		boolean result = sellerDao.sellerStoreReg(storeVo);
		return result;
	}
	//셀러 업체 승인/정지
	@Override
	public boolean sellerStorestatus(SellStoreVo storeVo) {
		boolean result = sellerDao.sellerStorestatus(storeVo);
		return result;
	}
	//셀러 업체 정보 수정
	@Override
	public boolean sellerStoreUpdate(SellStoreVo storeVo) {
		boolean result = sellerDao.sellerStoreUpdate(storeVo);
		return result;
	}
	//셀러 스토어 정보 조회
	@Override
	public SellStoreVo sellerStoreInfo(String sid) {
		SellStoreVo sellerStoreInfo = sellerDao.sellerStoreInfo(sid);
		return sellerStoreInfo;
	}
	//셀러 스토어 리스트
	@Override
	public List<SellStoreVo> sellerStoreList() {
		List<SellStoreVo> sellerStoreList = sellerDao.sellerStoreList();
		return sellerStoreList;
	}
	
	
}
