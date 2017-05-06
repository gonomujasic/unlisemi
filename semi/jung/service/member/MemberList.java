package jung.service.member;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
import jung.register.view.MemberMain;
//정해선
//20170421작성
//회원 정보 리스트클래스
//아이디, 패스워드를 확인 후 memberDAO클래스의 select메소드를 호출한다
//호출한 메소드안에는 회원 정보가 저장되어있을 것이고, 출력이 될것.
public class MemberList implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println();
		System.out.println("====회원 정보 보기====");
		System.out.println("아이디와 패스워드를 입력하세요.");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();
		System.out.print("패스워드 : ");
		String pw = bufferedReader.readLine();
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.login(id, pw);

		if (memberDTO == null) {
			System.out.println("아이디와 패스워드가 존재하지 않습니다.");
			MemberMain.main(null);
		} else {

			if (memberDTO.getId().equals(id)) {
				memberDTO = memberDAO.select(id, pw);// select로해서 저장된 값을 불러옴
				id = memberDTO.getId();
				pw = memberDTO.getPw();
				String name = memberDTO.getName();
				String nickName = memberDTO.getNickName();
				String birth = memberDTO.getBirth();
				String hp = memberDTO.getHp();
				String email = memberDTO.getEmail();
				String gender = memberDTO.getGender();

				System.out.println("====회원 정보는 아래와 같습니다.====");
				System.out.println("1. 아이디 : " + id + " ");
				System.out.println("2. 패스워드 : " + pw + " ");
				System.out.println("3. 이름 : " + name + " ");
				System.out.println("4. 닉네임 : " + nickName + " ");
				System.out.println("5. 생년월일 : " + birth + " ");
				System.out.println("6. 핸드폰 번호 : " + hp + " ");
				System.out.println("7. 이메일 : " + email + " ");
				System.out.println("8. 성별: " + gender + " ");
				System.out.println();

			}

		}

	}

}
