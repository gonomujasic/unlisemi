package yeon.board.servicer;

import java.util.HashMap;
import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOwrite;

public class BoardWrite implements BoardAction {
	@Override
	public void execute(Scanner scanner) {
		System.out.println("게시판 글을 작성하세요.");
		System.out.print("작성자 : ");
		String author = scanner.next();
		// System.out.print("이 메일 : ");
		// String email = scanner.next();
		// System.out.print("비밀번호 : ");
		// String passwd = scanner.next();
		System.out.print("제목 : ");
		
		String study_post_title = scanner.next();
		System.out.print("글 내용 : ");
		String study_post_contents = scanner.next();
		BoardDAOwrite boardDAOwrite = new BoardDAOwrite();
		boardDAOwrite.write(author, study_post_title, study_post_contents);
		// HashMap<String, String> hashMap = new HashMap<String, String>();
		// hashMap.put("author", author);
		// hashMap.put("study_post_title", study_post_title);
		// // hashMap.put("email", email);
		// hashMap.put("study_post_contents", study_post_contents);
		// // hashMap.put("passwd", passwd);
		// addArticle(hashMap);
		// System.out.println("등록하였습니다.");
	}

	public void addArticle(HashMap<String, String> hashMap) {
		// TODO Auto-generated method stub

	}
}
