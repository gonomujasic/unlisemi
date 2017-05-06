package ryu.studyboard.model;

public class StudyboardDTO {
	private int study_board_index;
	private String id;
	private String passwd;
	private String study_board_title;
	private String study_board_contents;
	private String study_board_date;

	public int getStudy_board_index() {
		return study_board_index;
	}

	public void setStudy_board_index(int study_board_index) {
		this.study_board_index = study_board_index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStudy_board_title() {
		return study_board_title;
	}

	public void setStudy_board_title(String study_board_title) {
		this.study_board_title = study_board_title;
	}

	public String getStudy_board_contents() {
		return study_board_contents;
	}

	public void setStudy_board_contents(String study_board_contents) {
		this.study_board_contents = study_board_contents;
	}

	public String getStudy_board_date() {
		return study_board_date;
	}

	public void setStudy_board_date(String study_board_date) {
		this.study_board_date = study_board_date;
	}
}