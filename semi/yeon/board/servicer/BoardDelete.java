package yeon.board.servicer;

import java.util.Scanner;

import yeon.board.control.BoardAction;
import yeon.board.dao.BoardDAOdelete;

public class BoardDelete implements BoardAction {
	@Override
	public void execute(Scanner scanner) {
		System.out.println("������ ���� �ۼ��ڿ� ��й�ȣ�� �Է��ϼ���.");
		System.out.println("�Խñ۹�ȣ :");
		int study_post_index = scanner.nextInt();
		System.out.println("���̵�:");   //���߿� ȸ���������� ����پ�
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
		// System.out.println("�ش� �ۼ��ڰ� ���ų� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		// return;
		// }
		// }
		// System.out.println("�����Ͽ����ϴ�.");

	}

}
