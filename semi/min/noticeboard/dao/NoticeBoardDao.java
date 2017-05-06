package min.noticeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import min.noticeboard.dbcp.Context;
import min.noticeboard.model.NoticeBoardDTO;

public class NoticeBoardDao {

	private static ResultSet resultSet;
	private static PreparedStatement preparedstatement;
	private Connection connection = null;
	private String sql;

	public ArrayList<NoticeBoardDTO> select() { //정민규, 0421, 데이터베이스에서 공지목록다읽어오기, 앞으로 구현할게 페이지당 공지 20개씩 페이지를 나눠서 표시하기를 하겠습니다.  
		//NoticeList에서 쓰는 공지사항목록 다 불러오기
		NoticeBoardDTO noticeBoardDTO;
		ArrayList<NoticeBoardDTO> articleList = new ArrayList<NoticeBoardDTO>();
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from noticeboard ";
			preparedstatement = connection.prepareStatement(sql);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				int noticeNumber = resultSet.getInt("notice_number");
				String id = resultSet.getString("id");
				String noticeTitle = resultSet.getString("notice_title");
				String noticeContents = resultSet.getString("notice_contents");
				String noticeDate = resultSet.getString("notice_date");
				int noticeViewNumber = resultSet.getInt("notice_view_number");

				noticeBoardDTO = new NoticeBoardDTO(noticeNumber, id, noticeTitle, noticeDate, noticeViewNumber,
						noticeContents);
				articleList.add(noticeBoardDTO);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close(); 
				preparedstatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return articleList; //모든 공지목록들을 articleList에 담아서 리턴

	}

	public void insert(NoticeBoardDTO noticeBoardDTO) { //정민규, 0421, 데이터베이스에 공지글 입력하는 기능, 구현할거미정
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "insert into noticeboard ";
			sql += " values(?,?,sysdate,0,?,noticeboard_seq.nextval)";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, noticeBoardDTO.getId());
			preparedstatement.setString(2, noticeBoardDTO.getNoticeTitle());
			preparedstatement.setString(3, noticeBoardDTO.getNoticeContents());
			int count = preparedstatement.executeUpdate();
			if (count > 0) {
				System.out.println("글을 등록하였습니다.");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int noticeNumber) { //정민규, 0421, 데이터베이스의 공지글 삭제하는 기능, 구현할거 미정

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from noticeboard ";
			sql += "where notice_number = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, noticeNumber);
			int deleteCount = preparedstatement.executeUpdate();
			if (deleteCount > 0) {
				System.out.println("삭제했습니다.");
				System.out.println();
			} else {
				System.out.println("해당번호의 공지가 없습니다.");
				System.out.println();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}

	}

	public NoticeBoardDTO selectone(int noticeNumber) { //정민규 0421 공지사항 내용 보기 구현할거미정
		// TODO Auto-generated method stub
		NoticeBoardDTO noticeBoardDTO = null;
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from noticeboard ";
			sql += " where notice_number = ?";

			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, noticeNumber);
			resultSet = preparedstatement.executeQuery();
			int noticeViewNumber;
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String noticeTitle = resultSet.getString("notice_title");
				String noticeContents = resultSet.getString("notice_contents");
				String noticeDate = resultSet.getString("notice_date");
				noticeViewNumber = resultSet.getInt("notice_view_number") + 1;
				noticeBoardDTO = new NoticeBoardDTO(noticeNumber, id, noticeTitle, noticeDate, noticeViewNumber,
						noticeContents);

				sql = "update noticeboard set notice_view_number = ? ";
				sql += "where notice_number = ? ";
				// 조회수를 올려주고 데이터베이스에 조회수를 수정해줍니다.
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setInt(1, noticeViewNumber);
				preparedstatement.setInt(2, noticeNumber);
				preparedstatement.executeUpdate();
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close(); // 자원해제역순으로
				preparedstatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return noticeBoardDTO;

	}

	public void update(int noticeNumber, NoticeBoardDTO noticeBoardDTO) { //정민규 0421 데이터베이스에 있는 공지사항을 수정해줍니다. 구현할거 미정
		// TODO Auto-generated method stub
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "update noticeboard set id = ?, notice_title = ?,  notice_contents = ?";
			sql += " where notice_number = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, noticeBoardDTO.getId());
			preparedstatement.setString(2, noticeBoardDTO.getNoticeTitle());
			preparedstatement.setString(3, noticeBoardDTO.getNoticeContents());
			preparedstatement.setInt(4, noticeNumber);
			int count = preparedstatement.executeUpdate();
			if (count > 0) {
				System.out.println("글을 수정하였습니다.");
				System.out.println();
			}else {
				System.out.println("해당공지가 없습니다.");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}