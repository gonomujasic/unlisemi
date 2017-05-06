package ryu.studyboard.service;

import java.io.BufferedReader;
import java.io.IOException;

import ryu.studyboard.control.StudyboardAction;
import ryu.studyboard.dao.StudyboardDAO;
import ryu.studyboard.model.StudyboardDTO;

public class StudyboardWrite implements StudyboardAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println("===게시글 등록 페이지===");
		System.out.print("작성자 아이디 : ");
		String id = bufferedReader.readLine();
		System.out.print("글 비밀번호 : ");
		String passwd = bufferedReader.readLine();
		System.out.print("글 제목 : ");
		String study_board_title = bufferedReader.readLine();
		System.out.print("글 내용 : ");
		String study_board_contents = bufferedReader.readLine();
		/*System.out.print("작성일 : ");
		String study_board_date = bufferedReader.readLine();*/
		StudyboardDAO studyboardDAO = new StudyboardDAO();
		StudyboardDTO studyboardDTO = new StudyboardDTO();
		studyboardDTO.setId(id);
		studyboardDTO.setPasswd(passwd);
		studyboardDTO.setStudy_board_title(study_board_title);
		studyboardDTO.setStudy_board_contents(study_board_contents);
		// studyboardDTO.setStudy_board_date(study_board_date);
		studyboardDAO.writeBoard(studyboardDTO);
	}
}