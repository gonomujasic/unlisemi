package jung.service.member;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
import jung.register.view.MemberMain;
//정해선
//20170421작성
//회원 정보 수정 클래스
//아이디, 패스워드 확인 후 현재 정보를 보여주면서 변경할 내용에 대해 입력을 받음.
//입력을 전부 마치면 memberDAO클래스의 update메소드를 호출한다.
public class MemberUpdate implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {

		System.out.println();
		System.out.println("====회원 정보 수정 페이지====");
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
			memberDTO = memberDAO.select(id, pw);
			System.out.println("수정할 회원 정보입니다.");
			System.out.println("현재 패스워드 : " + memberDTO.getPw());
			System.out.print("새로운 패스워드 : ");
			pw = bufferedReader.readLine();
			System.out.println("현재 이름 : " + memberDTO.getName());
			System.out.print("새로운 이름 : ");
			String name = bufferedReader.readLine();
			System.out.println("현재 닉네임 : " + memberDTO.getNickName());
			System.out.print("새로운 닉네임 : ");
			String nickName = bufferedReader.readLine();
			System.out.println("현재 생년월일 : " + memberDTO.getBirth());
			System.out.print("새로운 생년월일 : ");
			String birth = bufferedReader.readLine();
			System.out.println("현재 핸드폰 번호 : " + memberDTO.getHp());
			System.out.print("새로운 핸드폰 번호 : ");
			String hp = bufferedReader.readLine();
			System.out.println("현재 이메일 : " + memberDTO.getEmail());
			System.out.print("새로운 이메일 : ");
			String email = bufferedReader.readLine();
			System.out.println("현재 성별 : " + memberDTO.getGender());
			System.out.print("새로운 성별 : ");
			String gender = bufferedReader.readLine();

			memberDAO.update(id, pw, name, nickName, birth, hp, email, gender);

		}
	}
}
