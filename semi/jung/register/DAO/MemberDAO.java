package jung.register.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jung.register.dbcp.Context;
import jung.register.model.MemberDTO;
//정해선
//20170421작성
//login 로그인 처리
//insert 회원 가입 처리
//select 회원 정보 리스트 처리
//update 회원 정보 수정 처리
//delete 회원 탈퇴 처리

public class MemberDAO {

	// 로그인
	public MemberDTO login(String id, String pw) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MemberDTO memberDTO = null;
		String sql = null;
		Context context = new Context();

		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select id,pw from member";
			sql += " where id=? and pw=?  "; // 테이블에서 입력받은 id,pw와 일치하는 정보를 찾음.
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);// 첫번째 값이 id, 두번째 값이 pw.
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {// 값이 있는동안 반복한다.
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
				memberDTO = new MemberDTO();// id,pw를 꺼내 memberDTO에 넣어줌
				memberDTO.setId(id);
				memberDTO.setPw(pw);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
	// 회원 가입

	public void insert(MemberDTO memberDTO) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();

		try {

			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "insert into member(id,pw,name,nickName,birth,hp,email,gender) ";// 넣어야
																					// 할
																					// 값들
			sql += "  values (?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());// 입력받은 값들의 정보를
																// 넘겨받아서 넣어준다.
			preparedStatement.setString(2, memberDTO.getPw());
			preparedStatement.setString(3, memberDTO.getName());
			preparedStatement.setString(4, memberDTO.getNickName());
			preparedStatement.setString(5, memberDTO.getBirth());
			preparedStatement.setString(6, memberDTO.getHp());
			preparedStatement.setString(7, memberDTO.getEmail());
			preparedStatement.setString(8, memberDTO.getGender());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("회원가입이 완료되었습니다.");
				connection.commit();
			} else {
				connection.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원 리스트
	public MemberDTO select(String id, String pw) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		MemberDTO memberDTO = null;

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from member ";
			sql += "where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);// id,pw로 sql문을
																	// 꺼내서 저장한다.
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// 저장된 정보들을 불러서 각 변수에 저장
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String nickName = resultSet.getString("nickName");
				String birth = resultSet.getString("birth");
				String hp = resultSet.getString("hp");
				String email = resultSet.getString("email");
				String gender = resultSet.getString("gender");
				// memberDTO에 저장된 정보를 저장한다.
				memberDTO = new MemberDTO();
				memberDTO.setId(id);
				memberDTO.setPw(pw);
				memberDTO.setName(name);
				memberDTO.setNickName(nickName);
				memberDTO.setBirth(birth);
				memberDTO.setHp(hp);
				memberDTO.setEmail(email);
				memberDTO.setGender(gender);

				// System.out.println(memberDTO); 입력이 제대로 되었는지 확인

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	// 회원 정보 수정

	public void update(String id, String pw, String name, String nickName, String birth, String hp, String email,
			String gender) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();

		try {

			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();

			sql = " update member set pw=?, name=?, nickName=? , birth=?, hp=? ,email=?, gender=?";
			sql += "  where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pw); // 수정할 값들, ?에 맞게 차례대로 넣어준다
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, nickName);
			preparedStatement.setString(4, birth);
			preparedStatement.setString(5, hp);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, gender);
			preparedStatement.setString(8, id);
			preparedStatement.executeUpdate();
			System.out.println("회원 정보를 수정하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원 삭제
	public MemberDTO delete(String id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		MemberDTO memberDTO = new MemberDTO();

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from member ";
			sql += " where id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			System.out.println("회원 탈퇴 처리가 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

}
