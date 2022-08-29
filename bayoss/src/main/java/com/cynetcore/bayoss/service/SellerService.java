package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerVo;

public interface SellerService {
	//셀러 등록
	public boolean sellerInsert(SellerVo sellerVo);
	//셀러 아이디 중복 조회
	public boolean issellerexist(String sid);
	//셀러 로그인
	public SellerVo sellerlogin(String sid,String spw);
	//셀러 정보 조회
	public SellerVo sellerInfo(String sid);
	//셀러 정보 업데이트
	public boolean sellerUpdate(SellerVo sellerVo);
	//셀러 삭제
	public boolean sellerDelete(SellerVo sellerVo);
	//셀러 리스트
	public List<SellerVo> sellerList();
	//셀러 업체 등록
	public boolean sellerStoreReg(SellStoreVo storeVo);
	//셀러 업체 사업자번호 등록 여부
	public int sellstoreRegChk(String sell_store_regnum);
	//셀러 업체 승인/정지
	public boolean sellerStorestatus(SellStoreVo storeVo);
	//셀러 업체 정보 수정
	public boolean sellerStoreUpdate(SellStoreVo storeVo);
	//셀러 정보 조회
	public SellStoreVo sellerStoreInfo(String sid);
	//셀러 스토어 리스트
	public List<SellStoreVo> sellerStoreList();
}
