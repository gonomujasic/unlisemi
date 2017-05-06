package ryu.studyboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ryu.studyboard.dbcp.Context;
import ryu.studyboard.model.StudyboardDTO;

public class StudyboardDAO {
	public void writeBoard(StudyboardDTO studyboardDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "insert into study_board ";
			sql += "values(studyboard_seq.nextval,?,?,?,?,sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studyboardDTO.getId());
			preparedStatement.setString(2, studyboardDTO.getPasswd());
			preparedStatement.setString(3, studyboardDTO.getStudy_board_title());
			preparedStatement.setString(4, studyboardDTO.getStudy_board_contents());
			// preparedStatement.setString(5,
			// studyboardDTO.getStudy_board_date());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("글을 등록하였습니다.");
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
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

	public void viewBoard(StudyboardDTO studyboardDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select study_board_index, study_board_title, study_board_contents, study_board_date, id from study_board";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int study_board_index = resultSet.getInt("study_board_index");
				String study_board_title = resultSet.getString("study_board_title");
				String study_board_contents = resultSet.getString("study_board_contents");
				String study_board_date = resultSet.getString("study_board_date");
				String id = resultSet.getString("id");
				System.out.print("글 번호 = " + study_board_index);
				System.out.print(", 작성자 = " + id);
				System.out.print(", 글 제목 = " + study_board_title);
				System.out.print(", 글 내용 = " + study_board_contents);
				System.out.print(", 작성일 = " + study_board_date);
				System.out.println();
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				System.out.println("작성된 글이 없습니다. 글을 등록해 주세요.");
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
	}

	public StudyboardDTO showListBoard(int study_board_index) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		StudyboardDTO studyboardDTO = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from study_board ";
			sql += "where study_board_index=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, study_board_index);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int upnum = resultSet.getInt("study_board_index");
				String id = resultSet.getString("id");
				String passwd = resultSet.getString("passwd");
				String study_board_title = resultSet.getString("study_board_title");
				String study_board_contents = resultSet.getString("study_board_contents");
				studyboardDTO = new StudyboardDTO();
				studyboardDTO.setStudy_board_index(upnum);
				studyboardDTO.setId(id);
				studyboardDTO.setPasswd(passwd);
				studyboardDTO.setStudy_board_title(study_board_title);
				studyboardDTO.setStudy_board_contents(study_board_contents);
			}
		} catch (SQLException e) {
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
		return studyboardDTO;
	}

	public int updateBoard(StudyboardDTO studyboardDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int updateCount = 0;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "update study_board ";
			sql += "set id=?, passwd=?, study_board_title=?, study_board_contents=? where study_board_index=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studyboardDTO.getId());
			preparedStatement.setString(2, studyboardDTO.getPasswd());
			preparedStatement.setString(3, studyboardDTO.getStudy_board_title());
			preparedStatement.setString(4, studyboardDTO.getStudy_board_contents());
			preparedStatement.setInt(5, studyboardDTO.getStudy_board_index());
			updateCount = preparedStatement.executeUpdate();
			if (updateCount > 0) {
				System.out.println("수정하였습니다.");
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	public int deleteBoard(int study_board_index, String passwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int deletecount = 0;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete study_board ";
			sql += "where study_board_index=? and passwd=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, study_board_index);
			preparedStatement.setString(2, passwd);
			deletecount = preparedStatement.executeUpdate();
			if (deletecount > 0) {
				System.out.println("삭제하였습니다.");
				connection.commit();
			} else {
				System.out.println("글 번호와 글 비밀번호를 확인 해주세요.");
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deletecount;
	}
}