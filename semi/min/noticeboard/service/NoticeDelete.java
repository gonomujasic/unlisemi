package min.noticeboard.service;

import min.noticeboard.dao.NoticeBoardDao;

public class NoticeDelete {
	//정민규 0421 DB에서 삭제하는 객체를 생성하고 메서드를 호출한다.
	public void execute(int noticeNumber) {  //삭제 번호를 받기위해 action인터페이스에서 상속받지않았음
		// TODO Auto-generated method stub
		
		NoticeBoardDao noticeBoardDao = new NoticeBoardDao();
		noticeBoardDao.delete(noticeNumber); //dao객체를 생성하고 삭제메서드에 번호를 넣어준다.
		
		
	}
	

}
