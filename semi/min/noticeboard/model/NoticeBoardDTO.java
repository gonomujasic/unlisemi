package min.noticeboard.model;

public class NoticeBoardDTO {

	String id;
	String noticeTitle;
	String noticeDate;
	int noticeViewNumber;
	String noticeContents;
	int noticeNumber;
	//0421 	정민규		데이터입력,출력할때 필드값들을 편하게 옮기기위해 객체로 단일로? 저장해줍니다.		id는 회원정보에서 불러오기

	
	public NoticeBoardDTO(String id, String noticeTitle, String noticeContents) {
		super();
		this.id = id;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
	} //수정할때를 위한 생성자

	public NoticeBoardDTO(int noticeNumber, String id, String noticeTitle, String noticeDate, int noticeViewNumber,
			String noticeContents) {
		super();
		this.id = id;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeViewNumber = noticeViewNumber;
		this.noticeContents = noticeContents;
		this.noticeNumber = noticeNumber;
	} //그냥 작성할때를위한 필드생성자
	
	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeViewNumber() {
		return noticeViewNumber;
	}
	public void setNoticeViewNumber(int noticeViewNumber) {
		this.noticeViewNumber = noticeViewNumber;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	//그냥 겟셋들

	@Override
	public String toString() {
		return "공지번호="+noticeNumber + "\t 작성자 =" + id +"\n"+" 공지제목=" + noticeTitle + "\n 공지일=" + noticeDate
				+ "\t 조회수=" + noticeViewNumber + "\n 내용=" + noticeContents ;
	}
	//공지글 내용보기에 쓰이는 투스트링
	

}
