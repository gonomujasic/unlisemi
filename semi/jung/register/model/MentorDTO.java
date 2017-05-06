package jung.register.model;
//정해선
//20170421작성
//member에 필요한 변수 선언 
//get,set메소드 및 tostring으로 확인
public class MentorDTO {
	String id;
	String nation;
	String language;
	String introduceMySelf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIntroduceMySelf() {
		return introduceMySelf;
	}

	public void setIntroduceMySelf(String introduceMySelf) {
		this.introduceMySelf = introduceMySelf;
	}

	@Override
	public String toString() {
		return "MentorDAO [id=" + id + ", nation=" + nation + ", language=" + language + ", introduceMySelf="
				+ introduceMySelf + "]";
	}

}
