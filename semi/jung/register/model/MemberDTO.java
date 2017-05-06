package jung.register.model;
//정해선
//20170421작성
//member에 필요한 변수 선언 
//get,set메소드 및 tostring으로 확인
public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String nickName;
	private String birth;
	private String hp;
	private String email;
	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", nickName=" + nickName + ", birth=" + birth
				+ ", hp=" + hp + ", email=" + email + ", gender=" + gender + "]";
	}
}
