package com.cynetcore.bayoss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerVo;

@Repository
public class SellerDaoImpl implements SellerDao {

	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.seller.";
	
	@Autowired
	private SqlSession sqlSession;
	
	//셀러 등록
	@Override
	public boolean sellerInsert(SellerVo sellerVo) {
		int count = sqlSession.insert(NAMESPACE+"sellerInsert", sellerVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 아이디 중복 조회
	@Override
	public boolean issellerexist(String sid) {
		int count = sqlSession.selectOne(NAMESPACE + "issellerexist", sid);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	//셀러 로그인
	@Override
	public SellerVo sellerlogin(String sid, String spw) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("sid", sid);
		parameter.put("spw", spw);
		SellerVo sellerVo = sqlSession.selectOne(NAMESPACE + "sellerlogin", parameter);
		return sellerVo;
	}
	
	//셀러 정보 조회
	@Override
	public SellerVo sellerInfo(String sid) {
		SellerVo sellervo = sqlSession.selectOne(NAMESPACE + "sellerInfo", sid);
		return sellervo;
	}
	//셀러 정보 업데이트
	@Override
	public boolean sellerUpdate(SellerVo sellerVo) {
		int count = sqlSession.update(NAMESPACE + "sellerUpdate", sellerVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 삭제
	@Override
	public boolean sellerDelete(SellerVo sellerVo) {
		int count = sqlSession.update(NAMESPACE + "sellerDelete", sellerVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 리스트
	@Override
	public List<SellerVo> sellerList() {
		List<SellerVo> sellerlist = sqlSession.selectList(NAMESPACE+ "sellerList");
		return sellerlist;
	}
	//셀러 업체 등록
	@Override
	public boolean sellerStoreReg(SellStoreVo storeVo) {
		int count = sqlSession.insert(NAMESPACE+"sellerStoreReg", storeVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 업체 승인/정지
	@Override
	public boolean sellerStorestatus(SellStoreVo storeVo) {
		int count = sqlSession.update(NAMESPACE+ "sellerStorestatus", storeVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 업체 정보 수정
	@Override
	public boolean sellerStoreUpdate(SellStoreVo storeVo) {
		int count = sqlSession.update(NAMESPACE+ "sellerStoreUpdate", storeVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	//셀러 스토어 정보 조회
	@Override
	public SellStoreVo sellerStoreInfo(String sid) {
		SellStoreVo storeInfo = sqlSession.selectOne(NAMESPACE+"sellerStoreInfo", sid);
		return storeInfo;
	}
	//셀러 스토어 리스트
	@Override
	public List<SellStoreVo> sellerStoreList() {
		List<SellStoreVo> storeList = sqlSession.selectList(NAMESPACE+"sellerStoreList");
		return storeList;
	}
	
	//셀러 스토어 사업자번호 등록여부
	@Override
	public int sellstoreRegChk(String sell_store_regnum) {
		int count = sqlSession.selectOne(NAMESPACE + "sellstoreRegChk", sell_store_regnum);
		return count;
	}
	

	

}
