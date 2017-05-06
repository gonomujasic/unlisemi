package min.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import min.notice.db.NoticeContext;
import min.notice.model.NoticeDTO;

public class NoticeDAO {

	NoticeContext noticeContext;

	public NoticeDAO() {

		noticeContext = new NoticeContext();

	}
	//등록DAO
	public boolean insertDAO(NoticeDTO noticeDTO) {

		boolean isSuccess = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		DataSource dataSource = noticeContext.basicDataSource;

		try {
			connection = dataSource.getConnection();
			String sql = "insert into noticeboard2 (noticenum, title, content, writer) ";
			sql += "values (noticenum.nextval -1, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, noticeDTO.getTitle());
			preparedStatement.setString(2, noticeDTO.getContent());
			preparedStatement.setString(3, noticeDTO.getWriter());
			int num = preparedStatement.executeUpdate();

			if (num > 0) {
				isSuccess = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return isSuccess;
	}
	//리스트DAO
	public ArrayList<NoticeDTO> listDAO() {
		ArrayList<NoticeDTO> arrayList = new ArrayList<NoticeDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataSource dataSource = noticeContext.basicDataSource;

		try {
			connection = dataSource.getConnection();
			String sql = "select * from noticeboard2";
			sql += " order by noticenum desc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				NoticeDTO noticeDTO = new NoticeDTO();

				noticeDTO.setNoticeNum(resultSet.getInt("noticenum"));
				noticeDTO.setTitle(resultSet.getString("title"));
				noticeDTO.setContent(resultSet.getString("content"));
				noticeDTO.setWriter(resultSet.getString("writer"));
				noticeDTO.setWriteDate(resultSet.getDate("writeDate"));
				noticeDTO.setUpdateDate(resultSet.getDate("updateDate"));
				noticeDTO.setReadNum(resultSet.getInt("readnum"));

				arrayList.add(noticeDTO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return arrayList;
	}
	//읽기DAO
	public NoticeDTO readDAO(int num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataSource dataSource = noticeContext.basicDataSource;
		NoticeDTO noticeDTO = null;

		try {
			connection = dataSource.getConnection();
			String sql = "update noticeboard2 set readnum = readnum +1";
			sql += " where noticenum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			preparedStatement.executeUpdate();

			preparedStatement.close();
			sql = "select * from noticeboard2";
			sql += " where noticenum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setNoticeNum(resultSet.getInt("noticenum"));
				noticeDTO.setTitle(resultSet.getString("title"));
				noticeDTO.setContent(resultSet.getString("content"));
				noticeDTO.setWriter(resultSet.getString("writer"));
				noticeDTO.setWriteDate(resultSet.getDate("writedate"));
				noticeDTO.setUpdateDate(resultSet.getDate("updatedate"));
				noticeDTO.setReadNum(resultSet.getInt("readnum"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return noticeDTO;
	}
	//수정DAO
	public boolean updateDAO(NoticeDTO noticeDTO) {

		boolean isSuccess = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		DataSource dataSource = noticeContext.basicDataSource;

		try {
			connection = dataSource.getConnection();
			String sql = "update noticeboard2 set title = ?, content = ?, writer = ?, updatedate = sysdate ";
			sql += "where noticenum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, noticeDTO.getTitle());
			preparedStatement.setString(2, noticeDTO.getContent());
			preparedStatement.setString(3, noticeDTO.getWriter());
			preparedStatement.setInt(4, noticeDTO.getNoticeNum());
			int num = preparedStatement.executeUpdate();

			if (num > 0) {
				isSuccess = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return isSuccess;

	}
	
	//삭제DAO 프로시저로 구현함.
	public boolean deleteDAO(int num){
		boolean isSuccess = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		DataSource dataSource = noticeContext.basicDataSource;
		
		try {
			connection = dataSource.getConnection();
			String sql = "execute del_notice(?); ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			int done = preparedStatement.executeUpdate();
			
			if(done>0){
				
				isSuccess = true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		return isSuccess;
				
		}

}
