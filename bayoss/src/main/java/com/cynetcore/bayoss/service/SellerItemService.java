package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerItemVo;
import com.cynetcore.bayoss.vo.SellerVo;

public interface SellerItemService {
	//아이템 등록
	public boolean itemInsert(SellerItemVo sellerItemVo);
	//아이템 정보 조회
	public SellerItemVo itemInfo(int ino);
	//아이템 정보 업데이트
	public boolean itemUpdate(SellerItemVo sellerItemVo);
	//아이템 삭제
	public boolean itemDelete(SellerItemVo sellerItemVo);
	//셀러 아이템 리스트
	public List<SellerItemVo> itemList(String sid);
	//전체 아이템 리스트
	public List<SellerItemVo> itemListhole();
}
