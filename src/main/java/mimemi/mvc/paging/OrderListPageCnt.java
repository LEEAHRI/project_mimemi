package mimemi.mvc.paging;


public class OrderListPageCnt {
	private static int pageCnt; // �� ������ ��
	public static  int pagesize = 10;// �� ������ �� ����� �Խñ��� ��
	public static int pageNo = 1; // ������ �ѹ�
	public int blockcount = 5; // �� ���� ������ �Խñ� ��� ��
	
	public OrderListPageCnt() {
		super();
	}

	public OrderListPageCnt(int pageCnt) {
		super();
		this.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public static int getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		OrderListPageCnt.pagesize = pagesize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		OrderListPageCnt.pageNo = pageNo;
	}

	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	
}
