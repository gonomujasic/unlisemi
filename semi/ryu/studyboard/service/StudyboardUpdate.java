package ryu.studyboard.service;

import java.io.BufferedReader;
import java.io.IOException;

import ryu.studyboard.control.StudyboardAction;
import ryu.studyboard.dao.StudyboardDAO;
import ryu.studyboard.model.StudyboardDTO;

public class StudyboardUpdate implements StudyboardAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {

		System.out.println("수정할 글 번호를 입력하세요.");
		System.out.print("글 번호 : ");
		int study_board_index = Integer.parseInt(bufferedReader.readLine());
		StudyboardDAO studyboardDAO = new StudyboardDAO();
		StudyboardDTO studyboardDTO = studyboardDAO.showListBoard(study_board_index);
		if (studyboardDTO == null) {
			System.out.println("수정할 글 번호(" + study_board_index + ")가 없습니다.");
		} else {
			System.out.println("수정할 데이터를 입력하세요.");
			System.out.println("원래 비밀번호 : " + studyboardDTO.getPasswd());
			System.out.print("수정할 비밀번호 : ");
			String passwd = bufferedReader.readLine();
			System.out.println("원래 제목 : " + studyboardDTO.getStudy_board_title());
			System.out.print("수정할 제목 : ");
			String study_board_tilte = bufferedReader.readLine();
			System.out.println("원래 내용 : " + studyboardDTO.getStudy_board_contents());
			System.out.print("수정할 내용 : ");
			String study_board_contents = bufferedReader.readLine();
			studyboardDTO.setPasswd(passwd);
			studyboardDTO.setStudy_board_title(study_board_tilte);
			studyboardDTO.setStudy_board_contents(study_board_contents);
			studyboardDAO.updateBoard(studyboardDTO);
		}
	}
}