package com.cynetcore.bayoss.seller;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.SellerItemDao;
import com.cynetcore.bayoss.util.SellerFileUploader;
import com.cynetcore.bayoss.vo.SellerItemVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestSellitem {
	
	@Autowired
	private SellerItemDao itemDao;
	
//	@Autowired
//	private SellerFileUploader uploader;
	
	//아이템 등록
	@Test
	public void testItemInsert() {
		for(int i = 1; i < 20; i++ ) {
			SellerItemVo sellerItemVo = new SellerItemVo("test01", "테스트제품2", 10000, null, null ,"e09691e9-8bee-468a-bb6b-d884bb532162_디지털 트윈.PNG", "<br><p><font color=\"red\"><br></font></p><p><font color=\"red\"><br></font></p><p><img src=\"/sellerboard/displayimages?filename=a7943171-372c-4846-aa5b-cadfceaee9ca_a9dc1013-aca7-4638-bd1c-bf05e793cfa9_KakaoTalk_20220628_152452790_01.jpg\" style=\"width: 100%;\"><font color=\"red\"><br></font></p>");
			boolean result = itemDao.itemInsert(sellerItemVo);
		//	System.out.println("testItemInsert, result : " + result);
		}
	}
	
	//업로드 테스트
//	@Test
//	public void testupload() {
//		try {
//			uploader.fileUpload(null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	//아이템 업데이트
	@Test
	public void testItemUpdate() {
		SellerItemVo sellerItemVo = new SellerItemVo("test01", "테스트제품11", 100001, null, null ,"1아아아아아", "1아아아아");
		boolean result = itemDao.itemUpdate(sellerItemVo);
		System.out.println("testItemUpdate, result : " + result);
	}
	
	//아이템 삭제 업데이트
	@Test
	public void testItemDelete() {
		SellerItemVo SellerItemVo = new SellerItemVo();
		SellerItemVo.setIno(1);
		SellerItemVo.setItem_status("F");
		boolean result = itemDao.itemDelete(SellerItemVo);
		System.out.println("testItemDelete" + result);
	}
	
	//아이템 정보
	@Test
	public void testItemInfo() {
		SellerItemVo iteminfo = itemDao.itemInfo(1);
		System.out.println("testItemInfo" + iteminfo);
	}
	
	//셀러 리스트
	@Test
	public void testSellItemList() {
		List<SellerItemVo> itemlist = itemDao.itemList("test01");
		System.out.println("testSellItemList" + itemlist);
	}
	
	//셀러 리스트
		@Test
		public void testSellItemListHole() {
			List<SellerItemVo> itemlist = itemDao.itemListhole();
			System.out.println("testSellItemListHole" + itemlist);
		}
	
}
