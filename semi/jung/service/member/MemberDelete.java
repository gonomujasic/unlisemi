package jung.service.member;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
import jung.register.view.MemberMain;
import min.main.Mmain;
//정해선
//20170421작성
//회원 탈퇴 클래스
//아이디 확인후 탈퇴여부를 확인해, 탈퇴한다면 memberDAO클래스의 delete메소드를 호출한다
public class MemberDelete implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {

		System.out.println();
		System.out.println("====회원 탈퇴====");
		System.out.println("아이디와 패스워드를 입력하세요.");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();
		System.out.print("패스워드 : ");
		String pw = bufferedReader.readLine();
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.login(id, pw);

		if (memberDTO == null) {
			System.out.println("아이디와 패스워드가 존재하지 않습니다.");
			MemberMain.main(null);
		} else {

			if (memberDTO.getId().equals(id)) {
				System.out.print("탈퇴 하시겠습니까?(y/n)");
				String choice = bufferedReader.readLine();
				switch (choice) {
				case "y":
					memberDAO.delete(id);
					Mmain mmain = new Mmain();
					mmain.main(null);
					break;
				case "n":
					System.out.println("메인 화면으로 넘어갑니다.");
					MemberMain.main(null);
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}

			}
		}

	}
}
