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
		String sql = null;  // �ʱ�ȭ 
		int deleteCount = 0;
		try {
			Context context = new Context();  //����
			BasicDataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from unlimited ";  //�����ϴ� sql��
			sql += " where study_post_index = ? and id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, study_post_index);
			preparedStatement.setString(2, id);
			deleteCount = preparedStatement.executeUpdate();
			if (deleteCount > 0) {
				System.out.println("���� �Ͽ����ϴ�.");//����������� ��°�
				connection.commit();
			} else {
				System.out.println("������ ��ȣ�� �����ϴ�.");//�ƴҰ�� ��°�
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();//�ڿ�����
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deleteCount;
	}
}
