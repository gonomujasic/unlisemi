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
			System.out.println("메뉴를 입력하세요.");
			System.out.println("1.게시판 글 목록 보기" + " ");
			System.out.println("2.게시판 글 등록" + " ");
			System.out.println("3.게시판 글 수정" + " ");
			System.out.println("4.게시판 글 삭제" + " ");
			System.out.println("5.종료");
			System.out.println("메뉴 번호 입력:");
			String menu = scanner.next();
			switch (menu) {//스위치문을 통해서 메인 생성
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
