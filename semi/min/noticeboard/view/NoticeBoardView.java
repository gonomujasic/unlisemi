package min.noticeboard.view;

import java.util.Scanner;

import min.noticeboard.service.NoticeDelete;
import min.noticeboard.service.NoticeList;
import min.noticeboard.service.NoticeUpdate;
import min.noticeboard.service.NoticeWrite;

public class NoticeBoardView {

	public void exectue() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);    //메인메뉴를 보여준다.
		System.err.println();
			System.out.println("공지사항입니다.");
			System.out.println("원하는 메뉴를 선택해주세요.");
			System.out.print("1. 공지사항 목록 불러오기" + "\t");
			System.out.print("2. 공지사항 작성" + "\t");
			System.out.print("3. 공지사항 수정" + "\t");
			System.out.print("4. 공지사항 삭제" + "\t");
			System.out.println("5. 공지사항 종료" + "\t");

			int sign = scanner.nextInt();
			switch (sign) {
			case 1:
				NoticeList noticeList = new NoticeList();     //공지목록으로가기
				noticeList.execute(scanner);
				break;

			case 2:
				NoticeWrite noticeWrite = new NoticeWrite(); //메인에서 글쓰고 메인으로 다시
				noticeWrite.execute(scanner);
				NoticeBoardView noticeBoardView = new NoticeBoardView();
				noticeBoardView.exectue();
				break;

			case 3:
				System.out.println("수정할 글번호를 입력해주세요.");        //메인에서 수정하고 메인으로 다시
				int noticeNumber = scanner.nextInt();
				NoticeUpdate noticeUpdate = new NoticeUpdate();
				noticeUpdate.execute(noticeNumber);
				NoticeBoardView noticeBoardView2 = new NoticeBoardView();
				noticeBoardView2.exectue();
				break;

			case 4:
				System.out.println("삭제할 글번호를 입력해주세요.");   //메인에서 삭제하고 메인으로다시
				int delNumber = scanner.nextInt();
				NoticeDelete noticeDelete = new NoticeDelete();
				noticeDelete.execute(delNumber);
				NoticeBoardView noticeBoardView3 = new NoticeBoardView();
				noticeBoardView3.exectue();
				break;

			case 5:
				System.out.println("공지사항을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력");
			}
		
		// scanner.close();

	}
}
