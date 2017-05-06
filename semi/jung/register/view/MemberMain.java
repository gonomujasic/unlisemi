package jung.register.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jung.service.member.MemberDelete;
import jung.service.member.MemberInsert;
import jung.service.member.MemberList;
import jung.service.member.MemberLogin;
import jung.service.member.MemberUpdate;
//정해선
//20170421작성
//멘티의 메인 화면
//로그인 후 멘티의 화면을 보여줌
public class MemberMain {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		boolean isStop = false;
		do {
			System.out.println();
			System.out.println("====멘티 회원 창입니다====");
			System.out.println("메뉴를 선택하세요. ");
			System.out.print("1. 멘티 회원 정보 보기 ");
			System.out.print("2. 멘티 회원 정보 수정 ");
			System.out.print("3. 멘티 회원 탈퇴 ");
			System.out.println("4. 메인으로");
			System.out.print("메뉴 번호 : ");

			String menu = null;
			menu = bufferedReader.readLine();

			switch (menu) {

			case "1":
				MemberList memberList = new MemberList();
				memberList.execute(bufferedReader);
				break;
			case "2":
				MemberUpdate memberUpdate = new MemberUpdate();
				memberUpdate.execute(bufferedReader);
				break;
			case "3":
				MemberDelete memberDelete = new MemberDelete();
				memberDelete.execute(bufferedReader);
				break;
			case "4":
				System.out.println("메인으로");
				// System.exit(0);
				isStop = true;

				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (!isStop);
	}
}
