package com.jdbc.util;

public class MyUtil {//����¡ ó��
	
	//��ü������ ����
	public int getPageCount(int numPerPage,int dataCount) {
		
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0) {
			pageCount++;
		}
		return pageCount;
	}
	
	//����¡ ó�� �޼ҵ�
	public String pageIndexList(int currentPage,int totalPage,String listUrl) {
		//list.jsp�� �Ѹ��ǵ�(listurl) ��ü������ 10, ���� 2�������� �Ѹ��� �;�
		//1 2 3 4 5�� ������ ��� ������ �ﰢ��,2�������� �Ķ���
		//������ Ŭ���� get ���<a href = "list.jsp?pageNum=2">2</a>
		
		int numPerBlock = 3;//������ 6 7 8 9 10 ������ ������ ���� 5���� ��������
		int currentPageSetup;//������ ,Ŭ���ϸ� 5�������� ��������
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0 || totalPage==0) {
			return "";
		}
		
		//list.jsp
		//list.jsp?searchKey=name&searchValue=suzi
		
		if(listUrl.indexOf("?")!=-1) {//�˻�
			listUrl = listUrl + "&";
		}else {
			listUrl = listUrl + "?";
		}
		
		//������ pageNum
		//	   1  2  3  4   5 ������
		//������  6  7  8  9  10 ������
		//������ 11 12
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		//������ �����
		if(totalPage>numPerBlock && currentPageSetup>0) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">������</a>&nbsp;");
			
			//<a href="list.jsp?pageNum=5">������</a>&nbsp;
			
		}
		
		//�ٷΰ��� ������
		page = currentPageSetup + 1;
		
		while(page<=totalPage && page<= (currentPageSetup + numPerBlock)) {
			
			if(page==currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				//<font color="Fuchsia">9</font>&nbsp;
			}else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
				//<a href="list.jsp?pageNum=7">7</a>&nbsp;
			}
			
			page++;
		}
		
		//������
		//������  6  7  8  9  10 ������
		//������ 11 12
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
			//<a href="list.jsp?pageNum=11">������</a>&nbsp;�� �� �ڵ����� ǥ��
			
		}
		return sb.toString();
	}
	
}
