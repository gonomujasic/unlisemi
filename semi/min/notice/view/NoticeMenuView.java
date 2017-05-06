package min.notice.view;

import java.util.Scanner;

import min.notice.controller.NoticeController;

public class NoticeMenuView {

	Scanner scanner;
	NoticeController noticeController;

	//컨트롤러 사용위해 가져옴
	public NoticeMenuView(NoticeController noticeController) {
		scanner = new Scanner(System.in);
		this.noticeController = noticeController;

	}

	//메뉴 
	public void noticeMenu() {

		while (true) {

			
			System.out.println();
			
			// list
			noticeController.requestListView();
			
			System.out.println();
			System.out.println("1. 공지사항 등록");
			System.out.println("2. 공지사항 읽기");
			System.out.println("3. 프로그램 종료");
			System.out.println("번호를 입력하세요.");
			String num = scanner.next();

			if (num.equals("1")) {

				// insert
				noticeController.requestInsertView();

			} else if (num.equals("2")) {

				// read
				noticeController.requestReadView();

			} else if (num.equals("3")) {

				//종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}

}
