package com.cynetcore.bayoss.seller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.SellerDao;
import com.cynetcore.bayoss.vo.SellStoreVo;
import com.cynetcore.bayoss.vo.SellerVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestSeller {
	
	@Autowired
	private SellerDao sellerDao;
	
	//셀러 일반 등록
	@Test
	public void testSellerInsert() {
		SellerVo sellerVo = new SellerVo("test05", "test05", "test02@gmail.com", "010-1234-5678");
		boolean result = sellerDao.sellerInsert(sellerVo);
		System.out.println("testSellerInsert, result : " + result);
	}
	
	//셀러 아이디 중복
	@Test
	public void testissellerexist() {
		boolean result = sellerDao.issellerexist("test01");
		System.out.println("testissellerexist, result : " + result);
	}
	
	//셀러 일반 업데이트
	@Test
	public void testSellerUpdate() {
		SellerVo sellerVo = new SellerVo("test01", "test01m", "test01m@gmail.com", "010-1234-56789");
		boolean result = sellerDao.sellerUpdate(sellerVo);
		System.out.println("testSellerUpdate, result : " + result);
	}
	
	//셀러 일반 탈퇴
	@Test
	public void testSellerDelete() {
		SellerVo sellerVo = new SellerVo();
		sellerVo.setSid("test01");
		sellerVo.setStatus("T");
		boolean result = sellerDao.sellerDelete(sellerVo);
		System.out.println("testSellerDelete" + result);
	}
	
	//셀러 일반 정보
	@Test
	public void testSellerInfo() {
		SellerVo sellerInfo = sellerDao.sellerInfo("test01");
		System.out.println("testSellerInfo" + sellerInfo);
	}
	
	//셀러 리스트
	@Test
	public void testSellerList() {
		List<SellerVo> sellerlist = sellerDao.sellerList();
		System.out.println("testSellerList" + sellerlist);
	}
	
	//셀러 정식 등록 신청
	@Test
	public void testSellerStoreReg() {
		SellStoreVo storeVo = new SellStoreVo("test01", "하버맥스", "강희욱", "6038184360", 0511111111, "20130619","ulsan");
		boolean result = sellerDao.sellerStoreReg(storeVo);
		System.out.println("testSellerStoreReg: " + result);
	}

	//셀러 상태 변경
	@Test
	public void testSellerStoreStatus() {
		SellStoreVo storeVo = new SellStoreVo();
		storeVo.setSeller_reg_no(1);
		storeVo.setSell_store_status("T");
		boolean result = sellerDao.sellerStorestatus(storeVo);
		System.out.println("testSellerStoreStatus: " + result);
	}
	
	//셀러 정보 업데이트
	@Test
	public void testsellerStoreUpdate() {
	//	SellStoreVo storeVo = new SellStoreVo("test01", "하버맥스수정", 987654321, 987654321, 987654321);
	//	storeVo.setSeller_reg_no(1);
	//	boolean result = sellerDao.sellerStoreUpdate(storeVo);
	//	System.out.println("testsellerStoreUpdate: " + result);
	}
	
	//셀러 스토어 정보 조회
	@Test
	public void testsellerStoreInfo() {
		SellStoreVo result = sellerDao.sellerStoreInfo("test01");
		System.out.println("testsellerStoreInfo : " + result);
	}
	
	//셀러 스토어 전체 리스트
	@Test
	public void testsellerStoreList() {
		List<SellStoreVo> storeList = sellerDao.sellerStoreList();
		System.out.println("sellerStoreList : " + storeList);
	}
	
}
