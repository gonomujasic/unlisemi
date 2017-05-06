package min.noticeboard.service;

import java.util.ArrayList;
import java.util.Scanner;

import min.noticeboard.control.NoticeBoardAction;
import min.noticeboard.dao.NoticeBoardDao;
import min.noticeboard.model.NoticeBoardDTO;
import min.noticeboard.view.NoticeBoardView;

public class NoticeList implements NoticeBoardAction {

	@Override
	public void execute(Scanner scanner) { //0421 	정민규	 	공지글 목록을 보여주고 밑에 메뉴 표시		웹구현할거는 미정 
		// TODO Auto-generated method stub
		NoticeBoardDao noticeBoardDao = new NoticeBoardDao();
		ArrayList<NoticeBoardDTO> articleList = noticeBoardDao.select(); //dao select 메서드에서 전체 목록이 담긴 arraylist를 반환받는다.
		if (articleList.size() == 0) {
			System.out.println("공지사항이 없습니다.");
			System.out.println();
		} else {
			for (int i = 0; i < articleList.size(); i++) {
				System.out.println("글번호" + "\t" + "제목" + "\t" + "작성자" + "\t" + "작성일" + "\t" + "조회수");
				System.out.print(articleList.get(i).getNoticeNumber() + "\t");
				System.out.print(articleList.get(i).getNoticeTitle() + "\t");
				System.out.print(articleList.get(i).getId() + "\t");
				System.out.print(articleList.get(i).getNoticeDate() + "\t");
				System.out.println(articleList.get(i).getNoticeViewNumber());

			}
			System.out.println();

			System.out.println("1. 글쓰기" + "\t" + "2. 공지삭제하기" + "\t" + "3. 공지내용보기" + "\t" + "4. 수정하기" + "\t" + "5. 메인메뉴로");

			//while문으로 하지않고 다음 행선지를 직접 해줌 
			int sign = scanner.nextInt();
			if (sign == 1) {
				NoticeWrite noticeWrite = new NoticeWrite();
				noticeWrite.execute(scanner);
				NoticeList noticeList = new NoticeList(); //공지글목록에서 글을쓰고나면 공지목록으로 가기
				noticeList.execute(scanner);
			} else if (sign == 2) {
				System.out.println("삭제할 글번호를 입력해주세요.");
				int delNumber = scanner.nextInt();
				NoticeDelete noticeDelete = new NoticeDelete(); 
				noticeDelete.execute(delNumber);
				NoticeList noticeList = new NoticeList();  //공지목록에서 글을 삭제하면 공지목록으로 가기
				noticeList.execute(scanner);
			} else if (sign == 3) {
				NoticeRead noticeRead = new NoticeRead();   //공지목록에서 공지글 내용보기를 한다.
				noticeRead.execute(scanner);

			} else if (sign == 4) {
				System.out.println("수정할 글번호 입력");
				int upNumber = scanner.nextInt(); 
				NoticeUpdate noticeUpdate = new NoticeUpdate(); //공지목록에서 공지글 수정하고 공지목록으로 돌아가기
				noticeUpdate.execute(upNumber);
				NoticeList noticeList = new NoticeList();
				noticeList.execute(scanner);
			} else if (sign == 5) {
				NoticeBoardView noticeBoardView = new NoticeBoardView();  //메인으로돌아가기
				noticeBoardView.exectue();
			} else {
				System.out.println("잘못누름");
				NoticeList noticeList = new NoticeList(); //공지목록에서 메뉴선택 잘못하면 공지목록다시
				noticeList.execute(scanner);
			}

		}

	}

}
