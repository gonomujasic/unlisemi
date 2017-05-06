package yeon.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import yeon.board.dbcp.Context;

import yeon.board.dto.BoardDTO;

public class BoardDAOList {

//	김재연 , 2017-04-21 , 공부게시판 

	public ArrayList<BoardDTO> select() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		ArrayList<BoardDTO> arrayList = new ArrayList<BoardDTO>();
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from unlimited";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int study_post_index = resultSet.getInt("study_post_index");
				String id = resultSet.getString("id");
				String study_post_date = resultSet.getString("study_post_date");
				String study_post_title = resultSet.getString("study_post_title");
				String study_post_contents = resultSet.getString("study_post_contents");
				BoardDTO boardDTO = new BoardDTO(study_post_index, id,study_post_date, study_post_title, study_post_contents);
				arrayList.add(boardDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrayList;//반환
	}
}

