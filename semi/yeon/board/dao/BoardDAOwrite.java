package yeon.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import yeon.board.dbcp.Context;

public class BoardDAOwrite {
public void write(String id, String study_post_title, String study_post_contents) {
Connection connection = null;
PreparedStatement preparedStatement = null;
//BoardDTO boardDTO = new BoardDTO(study_post_index, id, study_post_date, study_post_title, study_post_contents);
//boardDTO.setId(id);
//boardDTO.setNum(study_post_index);
//boardDTO.setstudy_post_title(study_post_title);
//boardDTO.setstudy_post_contents(study_post_contents);2
String sql = null;
Context context = new Context();
try {
	DataSource dataSource = context.basicDataSource;
	connection = dataSource.getConnection();
	sql = "insert into unlimited";
	sql += " values(unlimited_seq.nextval,?,?,sysdate,0,?)";
	preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, id);
	preparedStatement.setString(2, study_post_title);
//	preparedStatement.setString(3, sysdate);
	preparedStatement.setString(3, study_post_contents);
	int count = preparedStatement.executeUpdate();
	if (count > 0) {
		System.out.println("글을 등록하였습니다.");
	}
	
} catch (Exception e) {
    e.printStackTrace();
}finally {
	try {
		preparedStatement.close();
		connection.close();
			} catch (SQLException e) {
		
			e.printStackTrace();
	}
	}
	
}
}