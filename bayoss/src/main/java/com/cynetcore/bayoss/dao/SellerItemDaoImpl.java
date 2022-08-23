package com.cynetcore.bayoss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.PagingDto;
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
	public List<SellerItemVo> itemList(String sid,PagingDto pagingDto) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("sid", sid);
		parameter.put("pagingDto", pagingDto);
		List<SellerItemVo> list = sqlSession.selectList(NAMESPACE + "itemList", parameter);
		System.out.println("itemList, dao,parameter" + parameter);
		return list;
	}
	//셀러 전체 아이템 리스트
	@Override
	public List<SellerItemVo> selleritemList(String sid) {
		List<SellerItemVo> list = sqlSession.selectList(NAMESPACE + "selleritemList", sid);
		return list;
	}
	//셀러 전체 아이템 리스트 갯수
	@Override
	public int itemListcount(String sid,PagingDto pagingDto) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("sid", sid);
		parameter.put("pagingDto", pagingDto);
		int count = sqlSession.selectOne(NAMESPACE+ "itemListcount", parameter);
		System.out.println("itemListcount, dao,parameter" + parameter);
		System.out.println("itemListcount, dao,count" + count);
		return count;
	}
	//셀러 전체 아이템 상태에 따른 갯수
	@Override
	public int itemListcountTF(String sid, String item_status) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("sid", sid);
		parameter.put("item_status", item_status);
		int count = sqlSession.selectOne(NAMESPACE + "itemListcountTF", parameter);
		return count;
	}
	
	//전체 아이템 갯수
	@Override
	public int itemListholecount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE+"itemListholecount" , pagingDto);
		return count;
	}
	
	//전체 아이템 리스트 - 관리자용
	@Override
	public List<SellerItemVo> itemListhole(PagingDto pagingDto) {
		List<SellerItemVo> list = sqlSession.selectList(NAMESPACE + "itemListhole",pagingDto);
		return list;
	}





	


	




}
