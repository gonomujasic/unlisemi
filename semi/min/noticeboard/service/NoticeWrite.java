package min.noticeboard.service;

import java.util.Scanner;

import min.noticeboard.control.NoticeBoardAction;
import min.noticeboard.dao.NoticeBoardDao;
import min.noticeboard.model.NoticeBoardDTO;

public class NoticeWrite implements NoticeBoardAction {

	@Override
	public void execute(Scanner scanner) {         //0421	정민규		데이터베이스에 공지글 쓰기위해 값들 받아주고 써주는 메서드 호출		웹에서 구현할거 미정
		// TODO Auto-generated method stub
		System.out.print("작성자: ");
		String id = scanner.next();
		//합쳤을때 회원정보에서 id 자동으로 불러오기
		System.out.println("제목: ");
		String title = scanner.next();
		System.out.println("내용: ");
		String contents = scanner.next();
		NoticeBoardDTO noticeBoardDTO = new NoticeBoardDTO(id, title, contents);
		NoticeBoardDao noticeBoardDao = new NoticeBoardDao();
		noticeBoardDao.insert(noticeBoardDTO); 
		
		
	}

}
