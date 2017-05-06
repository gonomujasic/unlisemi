package jung.service.mentor;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MentorDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MentorDTO;
//정해선
//20170421작성
//멘토 정보 등록 클래스
//필요한 정보를 입력받아 mentorDAO클래스의 insert메소드를 호출한다
public class MentorInsert implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		MentorDAO mentorDAO = new MentorDAO();
		System.out.println();
		System.out.println("====멘토 정보 등록 페이지====");
		System.out.print("아이디 : ");
		String id=bufferedReader.readLine();
		System.out.print("출신 국가 : ");
		String nation = bufferedReader.readLine();
		System.out.print("교육 언어 : ");
		String language = bufferedReader.readLine();
		System.out.print("자기 소개 : ");
		String introduceMySelf = bufferedReader.readLine();
		
		MentorDTO mentorDTO = new MentorDTO();
		mentorDTO.setId(id);
		mentorDTO.setNation(nation);
		mentorDTO.setLanguage(language);
		mentorDTO.setIntroduceMySelf(introduceMySelf);
		mentorDAO.insert(mentorDTO);
	}

}
