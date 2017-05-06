package yeon.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import yeon.board.dbcp.Context;
//. 
public class BoardDAOdelete {
	public int delete(int study_post_index, String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;  // 초기화 
		int deleteCount = 0;
		try {
			Context context = new Context();  //생성
			BasicDataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from unlimited ";  //삭제하는 sql문
			sql += " where study_post_index = ? and id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, study_post_index);
			preparedStatement.setString(2, id);
			deleteCount = preparedStatement.executeUpdate();
			if (deleteCount > 0) {
				System.out.println("삭제 하였습니다.");//삭제됬을경우 출력값
				connection.commit();
			} else {
				System.out.println("삭제할 번호가 없습니다.");//아닐경우 출력값
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();//자원해제
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deleteCount;
	}
}
