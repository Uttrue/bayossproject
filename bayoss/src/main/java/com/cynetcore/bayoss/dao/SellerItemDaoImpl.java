package com.cynetcore.bayoss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.SellerItemVo;

@Repository
public class SellerItemDaoImpl implements SellerItemDao {

	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.sellitem.";
	
	@Autowired
	private SqlSession sqlSession;
	
	//아이템 등록
	@Override
	public boolean itemInsert(SellerItemVo sellerItemVo) {
		int count = sqlSession.insert(NAMESPACE + "itemInsert", sellerItemVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	
	//아이템 정보 조회
	@Override
	public SellerItemVo itemInfo(int ino) {
		SellerItemVo itemVo = sqlSession.selectOne(NAMESPACE + "itemInfo", ino);
		return itemVo;
	}

	
	//아이템 정보 업데이트
	@Override
	public boolean itemUpdate(SellerItemVo sellerItemVo) {
		int count = sqlSession.update(NAMESPACE + "itemUpdate", sellerItemVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//아이템 삭제
	@Override
	public boolean itemDelete(SellerItemVo sellerItemVo) {
		int count = sqlSession.update(NAMESPACE + "itemDelete", sellerItemVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//셀러 아이템 리스트
	@Override
	public List<SellerItemVo> itemList(String sid) {
		List<SellerItemVo> list = sqlSession.selectList(NAMESPACE + "itemList", sid);
		return list;
	}

	//전체 아이템 리스트 - 관리자용
	@Override
	public List<SellerItemVo> itemListhole() {
		List<SellerItemVo> list = sqlSession.selectList(NAMESPACE + "itemListhole");
		return list;
	}

}
