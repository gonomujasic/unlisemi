package min.notice.model;

import java.util.Date;

//공지사항 DTO
public class NoticeDTO {

	int noticeNum;
	String title;
	String content;
	String writer;
	Date writeDate;
	Date updateDate;
	int readNum = 0;
	
	
	
	public NoticeDTO() {
	}

	public NoticeDTO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	
	
	public NoticeDTO(int noticeNum, String title, String content, String writer) {
		super();
		this.noticeNum = noticeNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public NoticeDTO(int noticeNum, String title, String content, String writer, Date writeDate, Date updateDate,
			int readNum) {
		this.noticeNum = noticeNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.readNum = readNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
