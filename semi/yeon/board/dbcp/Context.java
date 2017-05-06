package yeon.board.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class Context {
	public BasicDataSource basicDataSource; //인스턴스 변수선언
	public Context( ) { basicDataSource = new BasicDataSource( );
	basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	basicDataSource.setUsername("unlimited");
	basicDataSource.setPassword("1234");
	basicDataSource.setInitialSize(4); //초기 커넥션 객체개수 
	basicDataSource.setMaxIdle(100);// 사용안하는 커넥션 객체의 저장최대개수
	basicDataSource.setMinIdle(5); //사용안하는 커넥션객체 저장최소개수
}
}