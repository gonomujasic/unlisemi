package yeon.board.dto;

public class BoardDTO {
	private int study_post_index;
	private String id;
	private String study_post_date;
	private String study_post_title;
	private String study_post_contents;
	
	public BoardDTO(int study_post_index, String id, String study_post_date, String study_post_title, String study_post_contents) {
		super();
		this.study_post_index = study_post_index;
		this.id = id;
		this.study_post_date = study_post_date;
		this.study_post_title = study_post_title;
		this.study_post_contents = study_post_contents;
	}
	public int getstudy_post_index( ) {
		return study_post_index;
	} 
	public void setNum(int study_post_index) {
		this.study_post_index = study_post_index;
	}
	public String getId( ) {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getstudy_post_date( ) {
		return study_post_date;
	}
	public void setstudy_post_date(String study_post_date) {
		this.study_post_date = study_post_date;
	}
	public String getstudy_post_title( ) {
		return study_post_title;
	}
	public void setstudy_post_title(String study_post_title) {
		this.study_post_title = study_post_title;
	}
	public String getstudy_post_contents( ) {
		return study_post_contents;
	}
	public void setstudy_post_contents(String study_post_contents) {
		this.study_post_contents = study_post_contents;
	}
	public Object get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}

