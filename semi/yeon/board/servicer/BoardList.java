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
			System.out.println("�Խñ۹�ȣ:" +arrayList.get(i).getstudy_post_index());
			System.out.print("ID:" + arrayList.get(i).getId()+",");
			System.out.print("�Խñ��ۼ���:" + arrayList.get(i).getstudy_post_date()+",");
			System.out.print("����:" + arrayList.get(i).getstudy_post_title()+",");
			System.out.print("����:" + arrayList.get(i).getstudy_post_contents()+",");
			System.out.println();
			
		}
	} else {
System.out.println("��ϵ� ���� �����ϴ�.");
	}
}
}
