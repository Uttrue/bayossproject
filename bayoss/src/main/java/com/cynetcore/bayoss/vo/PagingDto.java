package com.cynetcore.bayoss.vo;

public class PagingDto {
	private int page = 1; // 현재 페이지
	private int startRow; // 시작 행
	private int endRow; // 종료 행
	private String searchType; // 찾으려는 방식
	private String keyword; // 키워드
	private int perPage = 10; // 각 페이지당 글 수
	private int totalPage; // 전체 페이지
	private int count; // 전체 글 수
	private int startPage = 1; // 시작 페이지
	private int endPage = 1; // 끝 페이지

	// 기본 생성자
	public PagingDto() {
		super();
	}

	// 필드 생성자
	public PagingDto(int page, int startRow, int endRow, String searchType, String keyword, int perPage, int totalPage,
			int count, int startPage, int endPage) {
		super();
		this.page = page;
		this.startRow = startRow;
		this.endRow = endRow;
		this.searchType = searchType;
		this.keyword = keyword;
		this.perPage = perPage;
		this.totalPage = totalPage;
		this.count = count;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	// Getter & Setter (Accessor)
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		setStartRow(page * perPage - (perPage - 1)); // 시작 행 설정
		setEndRow(page * perPage); // 종료 행 설정
		setStartPage(((page - 1) / 10) * 10 + 1); // 시작 페이지 설정
		setEndPage(((page - 1) / 10 + 1) * 10); // 종료 페이지 설정
		setTotalPage((int) Math.ceil((double) count / perPage)); // 전체 페이지 결정

		if (totalPage == 0) {
			totalPage = 1;
		}

		// 전체 페이지가 종료 페이지보다 작다면 종료 페이지를 전체 페이지로 변경

		endPage = (totalPage < endPage) ? totalPage : endPage;

	}

	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override

	public String toString() {
		return "PagingDto [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", searchType="
				+ searchType + ", keyword=" + keyword + ", perPage=" + perPage + ", totalPage=" + totalPage + ", count="
				+ count + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}	
}
