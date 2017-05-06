package ryu.studyboard.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ryu.studyboard.dao.StudyboardDAO;
import ryu.studyboard.model.StudyboardDTO;
import ryu.studyboard.service.StudyboardDelete;
import ryu.studyboard.service.StudyboardUpdate;
import ryu.studyboard.service.StudyboardWrite;

public class StudyboardView {

	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		boolean isStop = false;
		StudyboardDAO studyboardDAO = new StudyboardDAO();
		do {
			System.out.println();
			System.out.println("==게시판 메뉴==");
			System.out.print("1. 게시글 쓰기");
			System.out.print("\t2. 게시글 목록");
			System.out.print("\t3. 게시글 수정");
			System.out.print("\t4. 게시글 삭제");
			System.out.println("\t5. 종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 입력  : ");
			String menu = null;
			menu = bufferedReader.readLine();
			switch (menu) {
			case "1":
				StudyboardWrite studyboardWrite = new StudyboardWrite();
				studyboardWrite.execute(bufferedReader);
				break;
			case "2":
				StudyboardDTO studyboardDTO = new StudyboardDTO();
				studyboardDAO.viewBoard(studyboardDTO);
				break;
			case "3":
				StudyboardUpdate studyboardUpdate = new StudyboardUpdate();
				studyboardUpdate.execute(bufferedReader);
				break;
			case "4":
				StudyboardDelete studyboardDelete = new StudyboardDelete();
				studyboardDelete.execute(bufferedReader);
				break;
			case "5":
				System.out.println("프로그램을 종료합니다.");
				isStop = true;
				break;
			}
		} while (!isStop);
	}
}
