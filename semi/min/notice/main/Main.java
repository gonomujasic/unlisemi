package min.notice.main;

import min.notice.controller.NoticeController;

public class Main {

	private static NoticeController controller;
	
	//메인
	public static void main(String[] args) {
		
		//컨트롤러에 메뉴뷰 요청
		controller = new NoticeController();
		controller.requestNoticeMenuView(); 

	}

}
