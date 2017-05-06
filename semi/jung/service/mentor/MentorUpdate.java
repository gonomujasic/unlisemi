package jung.service.mentor;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MentorDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MentorDTO;
import jung.register.view.MentorMain;
//정해선
//20170421작성
//멘토 정보 수정 클래스
//아이디, 패스워드 확인 후 현재 정보를 보여주면서 변경할 내용에 대해 입력을 받음.
//입력을 전부 마치면 mentorDAO클래스의 update메소드를 호출한다.
public class MentorUpdate implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println();
		System.out.println("====멘토 정보 수정 페이지====");
		System.out.println("아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();

		MentorDAO mentorDAO = new MentorDAO();
		MentorDTO mentorDTO = mentorDAO.idFind(id);

		if (mentorDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			MentorMain.main(null);
		} else {
			mentorDTO = mentorDAO.select(id);
			System.out.println("수정할 회원 정보입니다.");
			System.out.println("현재 국가 : " + mentorDTO.getNation());
			System.out.print("새로운 국가 : ");
			String nation = bufferedReader.readLine();
			System.out.println("현재 교육 언어 : " + mentorDTO.getLanguage());
			System.out.print("새로운 교육 언어 : ");
			String language = bufferedReader.readLine();
			System.out.println("현재 자기 소개 : " + mentorDTO.getIntroduceMySelf());
			System.out.print("새로운 자기 소개 : ");
			String introduceMySelf = bufferedReader.readLine();
			mentorDAO.update(id, nation, language, introduceMySelf);
		}

	}

}
