package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.SellerItemDao;
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

	//전체 아이템 리스트
	@Override
	public List<SellerItemVo> itemListhole() {
		List<SellerItemVo> itemlist = itemDao.itemListhole();
		return itemlist;
	}

}
