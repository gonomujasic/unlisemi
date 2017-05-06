package ryu.studyboard.service;

import java.io.BufferedReader;
import java.io.IOException;


import ryu.studyboard.control.StudyboardAction;
import ryu.studyboard.dao.StudyboardDAO;

public class StudyboardDelete implements StudyboardAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		StudyboardDAO studyboardDAO = new StudyboardDAO();
		System.out.print("삭제할 글 번호를 입력하세요. : ");
		int study_board_index = Integer.parseInt(bufferedReader.readLine());
		System.out.print("삭제할 글의 비밀번호를 입력하세요. : ");
		String passwd = bufferedReader.readLine();
		studyboardDAO.deleteBoard(study_board_index, passwd);
	}
}