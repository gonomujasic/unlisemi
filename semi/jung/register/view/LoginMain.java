package jung.register.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jung.service.member.MemberInsert;
import jung.service.member.MemberLogin;
//정해선
//20170421작성
//Login 화면
//첫 로그인 화면을 보여줌
public class LoginMain {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		boolean isStop = false;
		do {
			System.out.println();
			System.out.println("메뉴를 선택하세요. ");
			System.out.print("1. 로그인 ");
			System.out.print("2. 회원가입 ");
			System.out.println("3. 종료");
			System.out.print("메뉴 번호 : ");
			String menu = null;
			menu = bufferedReader.readLine();

			switch (menu) {
			case "1":
				MemberLogin memberLogin = new MemberLogin();
				memberLogin.execute(bufferedReader);
				break;
			case "2":
				MemberInsert memberInsert = new MemberInsert();
				memberInsert.execute(bufferedReader);
				break;
			case "3":
				System.out.println("종료합니다");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (!isStop);

	}

}
