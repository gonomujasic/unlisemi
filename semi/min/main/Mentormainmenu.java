package min.main;

import java.io.IOException;
import java.util.Scanner;

import jung.register.view.MentorMain;
import min.notice.main.Main;
import min.noticeboard.view.NoticeBoardMain;
import ryu.studyboard.view.StudyboardView;

public class Mentormainmenu {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		boolean isCon = true;
		while (isCon) {
			System.out.println("메인입니다. 원하시는 메뉴를 선택해주세요");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.회원정보");
			// System.out.println("2.회원가입");
			System.out.println("3.언어재능교환입장"); // 공사
			System.out.println("4.언어재능교환검색"); // 공사
			System.out.println("5.공지사항");
			System.out.println("6.공지사항");
			System.out.println("7.공부게시판");
			System.out.println("8.종료");
			int sign = scanner.nextInt();

			switch (sign) {
			case 1:
				MentorMain mentorMain = new MentorMain();
				mentorMain.main(args);
				break;
			// case 2:
			//
			// break;
			case 3:
				// Chatent chatent = new Chatent();
				// chatent.main(); //공사중
				System.out.println("공사중");
				break;
			case 4:
				// Chatres chatres = new Chatres();
				// chatres.main(); //공사중
				System.out.println("공사중");
				break;
			case 5:
				NoticeBoardMain noticeBoardMain = new NoticeBoardMain();
				noticeBoardMain.main(args);
				break;
			case 6:
				Main main = new Main();
				main.main(args);
				break;
			case 7:
				StudyboardView studyboardView = new StudyboardView();
				studyboardView.main(args);

				break;
			case 8:
				System.out.println("종료");
				// isCon = false;
				System.exit(0);
				break;

			default:
				System.out.println("잘못입력");
				break;
			}

		}
	}
}
