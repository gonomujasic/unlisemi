package jung.service.member;

import java.io.BufferedReader;
import java.io.IOException;

import jung.register.DAO.MemberDAO;
import jung.register.control.RegisterAction;
import jung.register.model.MemberDTO;
//정해선
//20170421작성
//회원 가입 클래스
//필요한 정보를 입력받아 memberDAO클래스의 insert메소드를 호출한다
public class MemberInsert implements RegisterAction {

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		MemberDAO memberDAO = new MemberDAO();
		System.out.println();
		System.out.println("=====회원 가입 페이지====");
		System.out.print("아이디 : ");
		String id = bufferedReader.readLine();
		System.out.print("비밀번호 : ");
		String pw = bufferedReader.readLine();
		System.out.print("이름 : ");
		String name = bufferedReader.readLine();
		System.out.print("닉네임 : ");
		String nickName = bufferedReader.readLine();
		System.out.print("생년월일(ex_20170420) : ");
		String birth = bufferedReader.readLine();
		System.out.print("핸드폰 번호(ex_01012345678) : ");
		String hp = bufferedReader.readLine();
		System.out.print("이메일 : ");
		String email = bufferedReader.readLine();
		System.out.print("성별(F/M) : ");
		String gender = bufferedReader.readLine();

		MemberDTO memberDTO = new MemberDTO();// 입력한 정보를 저장
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setNickName(nickName);
		memberDTO.setBirth(birth);
		memberDTO.setHp(hp);
		memberDTO.setEmail(email);
		memberDTO.setGender(gender);
		memberDAO.insert(memberDTO);// MemberDAO클래스의 insert 메소드로 정보를 넘겨줌
	}

}
