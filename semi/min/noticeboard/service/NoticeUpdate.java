package min.noticeboard.service;

import java.util.Scanner;

import min.noticeboard.dao.NoticeBoardDao;
import min.noticeboard.model.NoticeBoardDTO;

public class NoticeUpdate {

	public void execute(int noticeNumber) {
		//0421 	정민규		데이터베이스에 공지글 수정하기위해 수정내용 받아주고 수정해주는 메서드 호출		웹구현할거미정 
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //노티스 넘버 받느라고 스캐너를 안받아줬는데 이거 메서드매개변수를 스캐너도 같이해서 해도될거같음
		System.out.println("제목을 고쳐주세요.");
		String noticeTitle = scanner.next();
		System.out.println("작성자를 고쳐주세요."); // 나중에 회원정보? 에서 알아서 집어넣기 안쳐줘도 되게
		String id = scanner.next();
		System.out.println("내용을 고쳐주세요.");
		String noticeContents = scanner.next();
		NoticeBoardDTO noticeBoardDTO = new NoticeBoardDTO(id, noticeTitle, noticeContents);
		NoticeBoardDao noticeBoardDao = new NoticeBoardDao();
		noticeBoardDao.update(noticeNumber, noticeBoardDTO); 

	} // 수정해줍니다

}
