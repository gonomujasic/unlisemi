package jung.service.mentor;
//정해선
//20170421작성
//멘토 정보 리스트클래스
//아이디, 패스워드를 확인 후 mentorDAO클래스의 select메소드를 호출한다
//호출한 메소드안에는 회원 정보가 저장되어있을 것이고, 출력이 될것.
import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.DAO.MentorDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
import jung.register.model.MentorDTO;
import jung.register.view.MemberMain;
import jung.register.view.MentorMain;

public class MentorList implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println();
		System.out.println("====멘토 회원 정보 보기====");
		System.out.println("아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();

		MentorDAO mentorDAO = new MentorDAO();
		MentorDTO mentorDTO = mentorDAO.idFind(id);
		if (mentorDAO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			MentorMain.main(null);
		} else {

			if (mentorDTO.getId().equals(id)) {
				mentorDTO = mentorDAO.select(id);
				id = mentorDTO.getId();
				String nation = mentorDTO.getNation();
				String language = mentorDTO.getLanguage();
				String introduceMySelf = mentorDTO.getIntroduceMySelf();

				System.out.println("====회원 정보는 아래와 같습니다.====");
				System.out.println("1. 아이디 : " + id + " ");
				System.out.println("2. 출신 국가 : " + nation + " ");
				System.out.println("3. 교육 언어: " + language + " ");
				System.out.println("4. 자기 소개 : " + introduceMySelf + " ");
				System.out.println();

			}

		}

	}

}