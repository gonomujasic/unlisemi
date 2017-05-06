package min.notice.view;

import java.util.ArrayList;
import java.util.Scanner;

import min.notice.controller.NoticeController;
import min.notice.model.NoticeDTO;

public class NoticeViews {

	Scanner scanner = new Scanner(System.in);
	NoticeController controller;

	// 컨트롤러 쓰기 위해 가져옴
	public NoticeViews(NoticeController controller) {

		this.controller = controller;

	}

	// 공지사항 등록 뷰
	public void insertView() {

		boolean isSuccess;

		System.out.println("");
		System.out.print("제목을 입력하세요: ");
		String title = scanner.nextLine();
		System.out.print("내용을 입력하세요: ");
		String content = scanner.nextLine();
		System.out.print("작성자명을 입력하세요: ");
		String writer = scanner.nextLine();

		NoticeDTO noticeDTO = new NoticeDTO(title, content, writer);
		isSuccess = controller.requestInsertDAO(noticeDTO);

		if (isSuccess == true) {

			System.out.println("공지사항을 등록하였습니다.");
		} else {
			System.out.println("공지사항 등록에 실패하였습니다.");
		}

	}

	// 공지사항 리스트 뷰
	public void listView() {

		ArrayList<NoticeDTO> arrayList = new ArrayList<NoticeDTO>();
		arrayList = controller.requestListDAO();
		System.out.println("\t\t\t\t\t***공지사항***");
		System.out.println("글번호 \t 제목 \t\t\t\t 작성자 \t 작성일 \t 조회수 ");

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print("\t" + arrayList.get(i).getNoticeNum() + "\t");
			System.out.print(arrayList.get(i).getTitle() + "\t\t");
			System.out.print(arrayList.get(i).getWriter() + "\t");
			System.out.print(arrayList.get(i).getWriteDate() + "\t\t");
			System.out.println(arrayList.get(i).getReadNum());

		}
	}

	// 공지사항 글읽기 뷰
	public void readView() {

		NoticeDTO noticeDTO = new NoticeDTO();

		System.out.println("몇 번 글을 읽으시겠습니까?");
		int num = scanner.nextInt();

		try {
			noticeDTO = controller.requestReadDAO(num);

			System.out.print("글번호: " + noticeDTO.getNoticeNum() + "\t");
			System.out.print("제목: " + noticeDTO.getTitle() + "\t");
			System.out.println("작성자: " + noticeDTO.getWriter());
			System.out.print("작성일: " + noticeDTO.getWriteDate() + "\t");
			System.out.print("수정일: " + noticeDTO.getUpdateDate() + "\t");
			System.out.println("조회수: " + noticeDTO.getReadNum());
			System.out.println("글내용:" + noticeDTO.getContent());

			// 읽기창에서 수정 삭제 메뉴
			System.out.println();
			System.out.println("1. 공지사항 수정");
			System.out.println("2. 공지사항 삭제");
			System.out.println("3. 이전 화면");
			System.out.println("번호를 입력하세요.");
			String selectNum = scanner.next();

			if (selectNum.equals("1")) {

				// 수정 화면
				controller.requestUpdateView(num);

			} else if (selectNum.equals("2")) {
				// 삭제 화면
				controller.requestDeleteView(num);

			} else {

				controller.requestNoticeMenuView();

			}
		} catch (NullPointerException e) {
			System.out.println("해당하는 글이 없습니다.");
		}

	}

	// 공지사항 수정 뷰
	public void updateView(int num) {

		boolean isSuccess = false;

		System.out.println("");
		System.out.print("제목을 입력하세요: ");
		String title = scanner.nextLine();
		System.out.print("내용을 입력하세요: ");
		String content = scanner.nextLine();
		System.out.print("작성자명을 입력하세요: ");
		String writer = scanner.nextLine();

		NoticeDTO noticeDTO = new NoticeDTO(num, title, content, writer);
		isSuccess = controller.requestUpdateDAO(noticeDTO);

		if (isSuccess == true) {

			System.out.println("공지사항을 수정하였습니다.");
		} else {
			System.out.println("공지사항 수정에 실패하였습니다.");
		}

	}

	// 공지사항 삭제 뷰
	public void deleteView(int num) {

		boolean isSuccess = false;
		isSuccess = controller.requestDeleteDAO(num);

		if (isSuccess == true) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

}
