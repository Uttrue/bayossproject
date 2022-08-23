package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.PagingDto;
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
	public List<SellerItemVo> itemList(String sid,PagingDto pagingDto);
	//셀러 전체 아이템 리스트
	public List<SellerItemVo> selleritemList(String sid);
	//셀러 전체 아이템 갯수
	public int itemListcount(String sid,PagingDto pagingDto);
	//셀러 아이템 상태에 따른 갯수
	public int itemListcountTF(String sid,String item_status);
	//전체 아이템 갯수
	public int itemListholecount(PagingDto pagingDto);
	//전체 아이템 리스트
	public List<SellerItemVo> itemListhole(PagingDto pagingDto);
}
