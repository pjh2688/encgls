package com.enc.dto;

public class PageMaker {

	private int totalCount; // 1. 전체 게시물 개수.
	private int pageNum; // 2. 현재 페이지 번호.
	private int contentNum = 10; // 3. 한 페이지에 몇 개의 게시글을 보여줄지 결정해주는 변수. 5개씩 뿌려줄 예정이므로 5로 초기화
	private int startPage = 1; // 4. 현재 페이지 블록의 시작페이지를 1로 설정.
	private int endPage; // 5. 마지막 페이지는 totalCount와 contentNum으로 계산할 예정.
	private int currentBlock = 1; // 6. 현재 페이지 블록.(1~5 <- 1블록, 6~10 <- 2블록, 11~15 < 3블록)
	private int lastBlock; // 7. 마지막 페이지 블록. ex) 게시글이 15개 있고 한 페이지에 5개의 게시글을 뿌려준다면 마지막 블록은 3이 된다.
	private int pageCount = 5; // 8. 한 블록당 보여줄 페이지 갯수 초기화(1블록당 5페이지씩 보여준다고 설정.)

	private boolean prev = false; // 9. 이전 페이지 화살표.(처음에 보이면 안되니까 false로 초기화)
	private boolean next; // 10. 다음 페이지 화살표.

	// 11. 시작 페이지 구하기(현재 블록 값으로 시작 페이지를 구한다.)
	public void setStartPage(int currentBlock) {
		this.startPage = (this.pageCount * currentBlock) - (this.pageCount - 1); // 5는 한 블록 당 페이지가 몇개 있을지 설정하는 값
		// 만약 101개의 게시글(전체게시글 수)이 있고 한 페이지당 10개의 게시글(contentNum)을 보여준다면
		// 해당 블록의 시작 페이지 = (블록당 보여줄 페이지 갯수(5) * 해당 블록 번호)에서 (블록당 보여줄 페이지 갯수(5)-
		// startPage 갯수(1개)) 계산한 값을 빼주면 구할 수 있다.
		// 1// 1 2 3 4 5
		// 2// 6 7 8 9 10
		// 3// 11
	}

	// 12. 이 게시판에 몇 페이지까지 표시할지 계산하는 메소드(endPage 계산을 위해 필요)
	public int calcPage(int totalCount, int contentNum) { // 전체 몇 페이지까지 있을지 페이지 갯수 계산하는 메소드(전체 페이지 갯수 계산)

		// 예를들어 125개의 게시글을 10개씩 페이지에 뿌려줄때 필요한 페이지는 12.5개가 필요합니다.
		// 소수점이 있으면 반올림 해주면 13페이지가 필요합니다.
		int totalPage = totalCount / contentNum; // 전체 게시물 수(totalCount)를 한 페이지당 보여지는 게시물을의 수(cotentNum)로 나눈다. = 한 블록안
													// 페이지 갯수 계산
		/*
		 * 예를 들어 전체 게시물(totalCount)이 16개이고 한 페이지당 보여줄 게시물(contentNum)이 5개라면 16 / 5 ->
		 * 3.1 -> 소수점이 있다면 1페이지 + 한다. -> 그 작업이 밑에 if문 4페이지가 필요하게 된다.
		 */

		if (totalCount % contentNum > 0) { // totalCount / contentNum 해서 0으로 나누어 떨어지지 않고 나머지가 있다면
			totalPage++; // 전체 페이지 수에서 1 페이지 증가.
		}

		return totalPage; // 전체 페이지 개수를 리턴한다.
	}

	// 13. 현재 페이지 블록 구하기(endPage 계산을 위해 필요)
	public void setCurrentBlock(int pageNum) { // 현재 페이지 블록이 몇번 블록인지 페이지 번호를 통해 블록 값을 구해주는 메소드.

		this.currentBlock = pageNum / this.pageCount; // 페이지 번호 / 한 블록안에 있는 페이지 개수
		// 1p 1/5 = 0.2 -> int 형이니 java에선 0
		// 2p 2/5 = 0.4 -> ..
		// 3p 3/5 = 0.6 -> ..
		// 6p 6/5 = 1.2 -> int 형이니 java에선 1
		// 8p 8/5 = 1.6 -> ..
		// 11p 11/5 = 2.2 -> .. int 형이니 java에선 2

		if (pageNum % this.pageCount > 0) { // currentBlock을 구할 때 나머지 값이 있으면 page에 1을 더한다.
			this.currentBlock++;
		}

	}

	// 14. 전체 게시글을 매개변수로 받아 마지막 페이지의 블록이 몇번인지 구하기(endPage 계산을 위해 필요)
	public void setLastBlock(int totalCount) { // 마지막 페이지 블록이 몇번 블록인지 지정해주는 메소드.
		// 마지막 블록의 번호는 전체 게시글 수 나누기(/) 한 블록당 보여줄 페이지 갯수(5) * 한 페이지당 보여줄 글의
		// 갯수(contentNum=5)
		// 결국 마지막 블록의 값이 전체 페이지 블록의 갯수가 된다.
		this.lastBlock = totalCount / (this.pageCount * this.contentNum);

		// 125 / 50 = 2.5 -> 나머지가 1보다 크니 존재할 수 있는 페이지 블록은 3
		if (totalCount % (this.pageCount * this.contentNum) > 0) { // 마지막 블록 번호 계산식에서 나온 값에 나머지가 생긴다면(나누어 떨어지지 않았다면).
			this.lastBlock++; // 마지막 블록을 1 증가 시킨다.(만약 위에서 2.6의 값이 나왔다면 마지막 블록은 최종적으로 3.6 즉 반올림하여 3이된다)
		}
	}

	// 15. 블록의 마지막 페이지 설정
	public void setEndPage(int getCurrentBlock, int getLastBlock) {
		if (getCurrentBlock == getLastBlock) { // 현재 currentBlock이 마지막 블록이라면
			this.endPage = calcPage(getTotalCount(), getContentNum()); // 전체 게시글 수와 한 페이지당 보여질 게시글 수를 매개변수로 보내서 전체 페이지
																		// 갯수를 구해온다.
		} // 그러면 calcPage의 return 값은 마지막 페이지 번호가 return 된다.(마지막 page번호가 총 page 갯수와 같으니까)
		else { // 현재 보여지는 블록이 마지막 블록이 아니라면
			this.endPage = getStartPage() + (this.pageCount - 1); // 해당 페이지의 시작 페이지 + 한 페이지 블록당 5개의 페이지를 뿌려줄것이기 때문에 시작
																	// 페이지를 제외한 페이지 5-1=4를 더해준다.
		}

		// 총 100개의 게시글이 있고, 한 페이지당 5개의 게시글을 표시한다고 가정.
		// 1블록
		// 1 페이지의 endPage : 시작 페이지(1) + 10 = 11
		// 2 페이지의 endPage : 시작 페이지(6) + 10 = 16
		// 3 페이지의 endPage : 시작 페이지(11) + 4 = 15
		// 4 페이지의 endPage : 시작 페이지(16) + 4 = 20
		// 5 페이지의 endPage : 시작 페이지(21) + 4 = 25
		// 6 페이지의 endPage : 26 : 현재 페이지 블록이 마지막 페이지 블록이기 때문에 calcPage로 전체 페이지 갯수를 구해오면 이
		// 메소드의 return 값은 마지막 페이지의 시작페이지번호이자 마지막페이지번호이고 전체페이지개수이기도 한 26이 return 된다.
	}

	// 16. 왼쪽 오른쪽 화살표
	public void prevnext(int pageNum) {

		if (pageNum > 0 && pageNum < pageCount + 1) { // 현재 페이지 블록이 첫번째 페이지 블록일 경우(한 블록에 페이지 5개씩 뿌려주는 걸로 가정했으니 범위는 0<첫
														// 블록에 나타낼 페이지<6)
			setPrev(false); // 첫번째 페이지 블록에선 prev 화살표가 있으면 안되니 false
			setNext(true); // 다음 페이지로 가는 화살표 next는 있어야되니 true
		} else if (getLastBlock() == getCurrentBlock()) { // 현재 페이지 블록이 마지막 페이지 블록일 경우
			setPrev(true);
			setNext(false);
		} else { // 첫번째와 마지막 블록이 둘다 아니라면
			setPrev(true);
			setNext(true);
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public int getLastBlock() {
		return lastBlock;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
