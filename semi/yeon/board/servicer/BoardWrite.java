package yeon.board.servicer;

import java.util.HashMap;
import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOwrite;

public class BoardWrite implements BoardAction {
	@Override
	public void execute(Scanner scanner) {
		System.out.println("�Խ��� ���� �ۼ��ϼ���.");
		System.out.print("�ۼ��� : ");
		String author = scanner.next();
		// System.out.print("�� ���� : ");
		// String email = scanner.next();
		// System.out.print("��й�ȣ : ");
		// String passwd = scanner.next();
		System.out.print("���� : ");
		
		String study_post_title = scanner.next();
		System.out.print("�� ���� : ");
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
		// System.out.println("����Ͽ����ϴ�.");
	}

	public void addArticle(HashMap<String, String> hashMap) {
		// TODO Auto-generated method stub

	}
}
