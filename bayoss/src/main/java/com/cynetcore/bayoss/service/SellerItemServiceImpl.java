package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.SellerItemDao;
import com.cynetcore.bayoss.vo.PagingDto;
import com.cynetcore.bayoss.vo.SellerItemVo;

@Service
public class SellerItemServiceImpl implements SellerItemService{
	
	@Autowired
	private SellerItemDao itemDao; 
	
	//아이템 등록
	@Override
	public boolean itemInsert(SellerItemVo sellerItemVo) {
		boolean result = itemDao.itemInsert(sellerItemVo);
		return result;
	}

	//아이템 정보 조회
	@Override
	public SellerItemVo itemInfo(int ino) {
		SellerItemVo itemVo = itemDao.itemInfo(ino);
		return itemVo;
	}

	//아이템 정보 업데이트
	@Override
	public boolean itemUpdate(SellerItemVo sellerItemVo) {
		boolean result = itemDao.itemUpdate(sellerItemVo);
		return result;
	}
	
	//아이템 삭제
	@Override
	public boolean itemDelete(SellerItemVo sellerItemVo) {
		boolean result = itemDao.itemDelete(sellerItemVo);
		return result;
	}

	//셀러 아이템 리스트
	@Override
	public List<SellerItemVo> itemList(String sid) {
		List<SellerItemVo> itemlist = itemDao.itemList(sid);
		return itemlist;
	}
	
	//셀러 전체 삭제포함 아이템 리스트
	@Override
	public List<SellerItemVo> selleritemList(String sid) {
		List<SellerItemVo> itemlist = itemDao.selleritemList(sid);
		return itemlist;
	}
	
	//셀러 전체 삭제포함 아이템 리스트 갯수
	@Override
	public int itemListcount(String sid) {
		int count = itemDao.itemListcount(sid);
		return count;
	}
	
	//셀러 전체 아이템 상태에 따른 갯수
	@Override
	public int itemListcountTF(String sid, String item_status) {
		int count = itemDao.itemListcountTF(sid, item_status);
		return count;
	}
	
	//전체 아이템 갯수
	@Override
	public int itemListholecount(PagingDto pagingDto) {
		int count = itemDao.itemListholecount(pagingDto);
		return count;
	}

	//전체 아이템 리스트
	@Override
	public List<SellerItemVo> itemListhole(PagingDto pagingDto) {
		List<SellerItemVo> itemlist = itemDao.itemListhole(pagingDto);
		return itemlist;
	}

	

	



}
