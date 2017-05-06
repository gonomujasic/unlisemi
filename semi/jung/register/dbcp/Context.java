package jung.register.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
//정해선
//20170421작성
//데이터 베이스 연결을 위한 주요 내용
public class Context {

	public BasicDataSource basicDataSource;

	public Context() {

		basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		basicDataSource.setUsername("unlimited");
		basicDataSource.setPassword("1234");
		basicDataSource.setInitialSize(4);
		basicDataSource.setMaxIdle(100);
		basicDataSource.setMinIdle(5);

	}
}
