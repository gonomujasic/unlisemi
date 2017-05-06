package yeon.board.servicer;

import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOdelete;

public class BoardDelete implements BoardAction {
	@Override
	public void execute(Scanner scanner) {
		System.out.println("제거할 글의 작성자와 비밀번호를 입력하세요.");
		System.out.println("게시글번호 :");
		int study_post_index = scanner.nextInt();
		System.out.println("아이디:");   //나중에 회원정보에서 끌어다씀
		String id = scanner.next();
		
		BoardDAOdelete boardDAOdelete = new BoardDAOdelete(); 
		boardDAOdelete.delete(study_post_index, id);
		
	}

	public void removerArticle(String aythor, String passwd) {
		// BoardDAOList boardDAO = new BoardDAOList();
		// ArrayList<BoardDTO>arrayList = boardDAO.select();
		// if (arrayList.size() > 0) {
		// int index = -1;
		// for (int i = 0; i < arrayList.size(); i++) {
		// if (arrayList.get(i).get("author").equals(passwd)) {
		// if (arrayList.get(i).get("passwd").equals(passwd)) {
		// arrayList.remove(arrayList.get(i));
		// index = i;
		// }
		// }
		// }
		// if (index == -1) {
		// System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
		// return;
		// }
		// }
		// System.out.println("삭제하였습니다.");

	}

}
