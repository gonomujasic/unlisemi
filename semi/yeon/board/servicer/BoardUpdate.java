package yeon.board.servicer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOList;
import yeon.board.dao.BoardDAOupdate;
import yeon.board.dto.BoardDTO;

public class BoardUpdate implements BoardAction {
	@Override
	public void execute(Scanner scanner) {
		BoardDAOList boardDAO = new BoardDAOList();
		ArrayList<BoardDTO>arrayList = boardDAO.select();
		System.out.println("게시글번호와 id를 입력하세요.");
		System.out.println("게시글 번호:");
		int study_post_index = scanner.nextInt();
		System.out.println("id :");
		String id = scanner.next();
		if (arrayList.size() > 0) {
			int index = -1;
			for (int i = 0; i < arrayList.size(); i++) {
				if (arrayList.get(i).getstudy_post_index()==study_post_index){
					if (arrayList.get(i).getId().equals(id)) {
						arrayList.remove(arrayList.get(i));
						index = i;
					}
				}
			}
			if (index == -1) {
				System.out.println("실패");
			} else {
//				System.out.println("이 메일:");
//				String email = scanner.next();
				System.out.println("글 제목:");
				String study_post_title = scanner.next();
				//String subject = scanner.next();
				System.out.println("글 내용");
				String study_post_contents = scanner.next();
				//String content = scanner.next();
				BoardDAOupdate boardDAOupdate = new BoardDAOupdate();
				boardDAOupdate.update(study_post_title,study_post_contents);			
//				HashMap<String, String> hashMap = new HashMap<String, String>();
//				hashMap.("study_post_index", study_post_index);
//				hashMap.put("subject", subject);
////				hashMap.put("email", email);
//				hashMap.put("content", content);
//				hashMap.put("id", id);
//				addArticle(hashMap);
//				System.out.println("수정하였습니다.");

			}

		}

	}

	public void addArticle(HashMap<String, String> hashMap) {
		//arrayList.add(hashMap);

	}
}
