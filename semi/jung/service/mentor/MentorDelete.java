package jung.service.mentor;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MentorDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MentorDTO;
import jung.register.view.MemberMain;
import jung.register.view.MentorMain;
//정해선
//20170421작성
//멘토 정보 삭제 클래스
//아이디 확인후, 멘토 정보를 삭제 한다면 mentorDAO클래스의 delete메소드를 호출한다
public class MentorDelete implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println();
		System.out.println("====멘토 정보 삭제 페이지====");
		System.out.println("아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();

		MentorDAO mentorDAO = new MentorDAO();
		MentorDTO mentorDTO = mentorDAO.idFind(id);

		if (mentorDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			MentorMain.main(null);
		} else {
			if (mentorDTO.getId().equals(id)) {
				System.out.print("멘토 정보를 삭제 하시겠습니까?(y/n)");
				String choice = bufferedReader.readLine();
				switch (choice) {
				case "y":
					mentorDAO.delete(id);
					break;
				case "n":
					System.out.println("메인 화면으로 넘어갑니다.");
					MentorMain.main(null);
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}

			}
		}
	}
}
