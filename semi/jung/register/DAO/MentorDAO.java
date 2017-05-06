package jung.register.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jung.register.dbcp.Context;
import jung.register.model.MemberDTO;
import jung.register.model.MentorDTO;
//정해선
//20170421작성
//idFind 아이디가 있는지 확인
//insert 회원 가입 처리
//select 회원 정보 리스트 처리
//update 회원 정보 수정 처리
//delete 회원 탈퇴 처리
public class MentorDAO {

	public MentorDTO idFind(String id) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();
		MentorDTO mentorDTO = null;

		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select id from mentor";
			sql += " where id=? "; // 테이블에서 입력받은 id와 일치하는 정보를 찾음.
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getString("id");//ID를 꺼내 mentorDTO에 넣어준다.
				mentorDTO = new MentorDTO();
				mentorDTO.setId(id);

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
		return mentorDTO;
	}

	// 멘토 정보 등록
	public void insert(MentorDTO mentorDTO) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "insert into mentor(id,nation,language,introduceMySelf) ";//넣어야 할 값
			sql += "  values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mentorDTO.getId());//입력받은 값들의 정보를 넘겨받아서 넣어줌
			preparedStatement.setString(2, mentorDTO.getNation());
			preparedStatement.setString(3, mentorDTO.getLanguage());
			preparedStatement.setString(4, mentorDTO.getIntroduceMySelf());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("멘토 회원 정보가 등록되었습니다.");
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

	// 멘토 정보 보기

	public MentorDTO select(String id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		MentorDTO mentorDTO = new MentorDTO();

		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from mentor";
			sql += " where id=?  ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getString("id");
				String nation = resultSet.getString("nation");
				String language = resultSet.getString("language");
				String introduceMySelf = resultSet.getString("introduceMySelf");

				mentorDTO.setId(id);
				mentorDTO.setNation(nation);
				mentorDTO.setLanguage(language);
				mentorDTO.setIntroduceMySelf(introduceMySelf);
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
		return mentorDTO;

	}
	// 멘토 정보 수정

	public void update(String id, String nation, String language, String introduceMySelf) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();

		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = " update mentor set nation=?, language= ?,introduceMySelf=? ";
			sql += "  where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nation);
			preparedStatement.setString(2, language);
			preparedStatement.setString(3, introduceMySelf);
			preparedStatement.setString(4, id);
			preparedStatement.executeUpdate();
			System.out.println("멘토 정보가 수정되었습니다.");
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

	// 멘토 정보 삭제

	public MentorDTO delete(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();
		MentorDTO mentorDTO = new MentorDTO();

		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from mentor ";
			sql += " where id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			int i = preparedStatement.executeUpdate();
			System.out.println(" 멘토 정보를 삭제했습니다.");
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
		return mentorDTO;
	}

}
