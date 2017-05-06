package yeon.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import yeon.board.dbcp.Context;
//������� !!
public class BoardDAOupdate {
	public int update(String study_post_title, String study_post_contents) {
		Connection connection = null; // �ʱ�ȭ 
		PreparedStatement preparedStatement = null;
		String sql = null;
		int updateCount = 0;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "update unlimited";
			sql += " set study_post_title = ?, study_post_contents=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, study_post_title);
			preparedStatement.setString(2, study_post_contents);
			updateCount = preparedStatement.executeUpdate();
			if (updateCount > 0) {
				System.out.println("�����Ͽ����ϴ�.");
				connection.commit();
			} else {
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
		return updateCount;
	}

	
}
