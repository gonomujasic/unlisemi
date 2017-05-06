package jung.service.member;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
import jung.register.view.LoginMain;
import jung.register.view.MemberMain;
import jung.register.view.MentorMain;
import min.main.Membermainmenu;
import min.main.Mentormainmenu;
//정해선
//20170421작성
//로그인 클래스
//회원정보가 없으면 회원가입 여부를 묻고, 로그인에 성공하면 멘토메인 or 멘티 메인으로 넘어간다.
public class MemberLogin implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		boolean isStop = false;

		do {
			System.out.println();
			System.out.println("====로그인 페이지====");
			System.out.println("아이디와 패스워드를 입력하세요.");
			System.out.print("아이디 : ");
			String id = bufferedReader.readLine();
			System.out.print("패스워드 : ");
			String pw = bufferedReader.readLine();
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = memberDAO.login(id, pw);// memberDAO객체의
															// login메소드에 id,pw를
															// 넣어 memberDTO에 저장
			if (memberDTO == null) {// memberDTO가 아무것도 없으면, id, pw가 없는것!
				System.out.println("입력하신 정보의 회원이 없습니다.");
				System.out.print("회원 가입 하시겠습니까?(y/n) : ");
				String choice = bufferedReader.readLine();
				switch (choice) {
				case "y":
					MemberInsert memberInsert = new MemberInsert();
					memberInsert.execute(bufferedReader);
					break;
				case "n":
					LoginMain.main(null);
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} else {
				System.out.println("로그인에 성공하였습니다.");
				System.out.println("메뉴를 선택하세요.");
				System.out.print("1. 멘티 회원 ");
				System.out.println("2. 멘토 회원 ");
				System.out.print("메뉴 번호 : ");
				String menu = bufferedReader.readLine();
				switch (menu) {
				case "1":
					Membermainmenu membermainmenu = new Membermainmenu();
					membermainmenu.main(null);
					break;
				case "2":
					Mentormainmenu mentormainmenu = new Mentormainmenu();
					mentormainmenu.main(null);
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}
		} while (!isStop);

	}

}
