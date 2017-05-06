package jung.register.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jung.service.member.MemberDelete;
import jung.service.member.MemberInsert;
import jung.service.member.MemberList;
import jung.service.member.MemberUpdate;
import jung.service.mentor.MentorDelete;
import jung.service.mentor.MentorInsert;
import jung.service.mentor.MentorList;
import jung.service.mentor.MentorUpdate;
//정해선
//20170421작성
//멘토의 메인 화면
//로그인 후 멘토의 화면을 보여줌
public class MentorMain {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		boolean isStop = false;
		do {
			System.out.println();
			System.out.println("====멘토 회원 창입니다====");
			System.out.println("메뉴를 선택하세요. ");
			System.out.print("1. 멘토 회원 정보 등록 ");
			System.out.print("2. 멘토 회원 정보 보기 ");
			System.out.print("3. 멘토 회원 정보 수정 ");
			System.out.print("4. 멘토 회원 정보 삭제 ");
			System.out.println("5. 메인으로");
			System.out.print("메뉴 번호 : ");

			String menu = null;
			menu = bufferedReader.readLine();

			switch (menu) {
			case "1":
				MentorInsert mentorInsert = new MentorInsert();
				mentorInsert.execute(bufferedReader);
				break;
			case "2":
				MentorList mentorList = new MentorList();
				mentorList.execute(bufferedReader);
				break;
			case "3":
				MentorUpdate mentorUpdate = new MentorUpdate();
				mentorUpdate.execute(bufferedReader);
				break;
			case "4":
				MentorDelete mentorDelete = new MentorDelete();
				mentorDelete.execute(bufferedReader);
				break;
			case "5":
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
