package min.notice.controller;

import java.util.ArrayList;

import min.notice.dao.NoticeDAO;
import min.notice.model.NoticeDTO;
import min.notice.view.NoticeMenuView;
import min.notice.view.NoticeViews;

public class NoticeController {

	NoticeDAO noticeDAO;
	NoticeMenuView noticeMenuView;
	NoticeViews noticeViews;

	public NoticeController() {

		// 싱글톤 패턴 활용
		noticeDAO = new NoticeDAO();
		noticeMenuView = new NoticeMenuView(this);
		noticeViews = new NoticeViews(this);
	}

	// 메뉴뷰 호출
	public void requestNoticeMenuView() {

		noticeMenuView.noticeMenu();

	}

	// 공지사항 등록뷰 호출
	public void requestInsertView() {

		noticeViews.insertView();

	}

	// 공지사항 등록DAO호출
	public boolean requestInsertDAO(NoticeDTO noticeDTO) {

		boolean isSuccess = noticeDAO.insertDAO(noticeDTO);

		return isSuccess;
	}

	// 공지사항 리스트뷰 호출
	public void requestListView() {

		noticeViews.listView();

	}

	// 공지사항 리스트DAO 호출
	public ArrayList<NoticeDTO> requestListDAO() {

		ArrayList<NoticeDTO> arrayList = noticeDAO.listDAO();

		return arrayList;
	}

	// 공지사항 읽기뷰 호출
	public void requestReadView() {

		noticeViews.readView();
	}

	// 공지사항 읽기DAO 호출
	public NoticeDTO requestReadDAO(int num) {
		NoticeDTO noticeDTO = new NoticeDTO();

		noticeDTO = noticeDAO.readDAO(num);

		return noticeDTO;
	}

	// 공지사항 수정뷰 호출
	public void requestUpdateView(int num) {

		noticeViews.updateView(num);

	}

	// 공지사항 수정DAO 호출
	public boolean requestUpdateDAO(NoticeDTO noticeDTO) {

		boolean isSuccess = noticeDAO.updateDAO(noticeDTO);

		return isSuccess;
	}

	// 공지사항 삭제뷰 호출
	public void requestDeleteView(int num) {

		noticeViews.deleteView(num);

	}

	// 공지사항 삭제DAO 호출
	public boolean requestDeleteDAO(int num) {

		boolean isSuccess = noticeDAO.deleteDAO(num);

		return isSuccess;

	}

}
