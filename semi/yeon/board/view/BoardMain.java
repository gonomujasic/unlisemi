package yeon.board.view;

import java.util.Scanner;

import yeon.board.servicer.BoardDelete;
import yeon.board.servicer.BoardList;
import yeon.board.servicer.BoardUpdate;
import yeon.board.servicer.BoardWrite;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isStop = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("�޴��� �Է��ϼ���.");
			System.out.println("1.�Խ��� �� ��� ����" + " ");
			System.out.println("2.�Խ��� �� ���" + " ");
			System.out.println("3.�Խ��� �� ����" + " ");
			System.out.println("4.�Խ��� �� ����" + " ");
			System.out.println("5.����");
			System.out.println("�޴� ��ȣ �Է�:");
			String menu = scanner.next();
			switch (menu) {//����ġ���� ���ؼ� ���� ����
			case "1":
				BoardList boardList = new BoardList();
				boardList.execute(scanner);
				break;
			case "2":
				BoardWrite boardWrite = new BoardWrite();
				boardWrite.execute(scanner);
				break;
			case "3":
				BoardUpdate boardUpdate = new BoardUpdate();
				boardUpdate.execute(scanner);
				break;
			case "4":
				BoardDelete boardDelete = new BoardDelete();
				boardDelete.execute(scanner);
				break;
			case "5":
				isStop = true;
			}

		} while (!isStop);
	}

}
