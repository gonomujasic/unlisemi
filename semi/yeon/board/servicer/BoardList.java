package yeon.board.servicer;

import java.util.ArrayList;
import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOList;
import yeon.board.dto.BoardDTO;

public class BoardList implements BoardAction{
@Override
public void execute(Scanner scanner) {
	
	BoardDAOList boardDAO = new BoardDAOList();
	ArrayList<BoardDTO>arrayList = boardDAO.select();
	if (arrayList.size()> 0) {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println("게시글번호:" +arrayList.get(i).getstudy_post_index());
			System.out.print("ID:" + arrayList.get(i).getId()+",");
			System.out.print("게시글작성일:" + arrayList.get(i).getstudy_post_date()+",");
			System.out.print("제목:" + arrayList.get(i).getstudy_post_title()+",");
			System.out.print("내용:" + arrayList.get(i).getstudy_post_contents()+",");
			System.out.println();
			
		}
	} else {
System.out.println("등록된 글이 없습니다.");
	}
}
}
