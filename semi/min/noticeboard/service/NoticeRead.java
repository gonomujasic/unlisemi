package min.noticeboard.service;

import java.util.Scanner;

import min.noticeboard.dao.NoticeBoardDao;
import min.noticeboard.model.NoticeBoardDTO;

public class NoticeRead {

	public void execute(Scanner scanner) {    //0421 	정민규		 공지글내용보기	구현할거글쎼요
		// TODO Auto-generated method stub
		int sign;
		System.out.println("읽으실 공지의 글번호를 입력해주세요");
		int noticeNumber = scanner.nextInt();
		NoticeBoardDao noticeBoardDao = new NoticeBoardDao();
		NoticeBoardDTO noticeBoardDTO = noticeBoardDao.selectone(noticeNumber);
		System.out.println(noticeBoardDTO);
		boolean isCon = true;
		while (isCon) {
			System.out.println("1.수정  \t 2.삭제 \t 3.목록으로");
			sign = scanner.nextInt();
			if (sign == 1) {
				isCon = false;
				NoticeUpdate noticeUpdate = new NoticeUpdate(); 		//공지글 내용보기에서 수정하고 공지목록으로가기
				noticeUpdate.execute(noticeBoardDTO.getNoticeNumber());
				NoticeList noticeList = new NoticeList();
				noticeList.execute(scanner);
				
			} else if (sign == 2) {
				isCon = false;
				System.out.println("삭제할글번호입력");			//공지글 내용보기에서 삭제하고 공지목록으로가기
				int delNumber = noticeBoardDTO.getNoticeNumber();
				NoticeDelete noticeDelete = new NoticeDelete();
				noticeDelete.execute(delNumber);
				NoticeList noticeList = new NoticeList();
				noticeList.execute(scanner);
				
			} else if(sign == 3){
				isCon = false;      
				NoticeList noticeList = new NoticeList();
				noticeList.execute(scanner);
			} else {
				System.out.println("잘못입력");  //잘못선택했을때 다시 선택
			}
		}

	}

}
