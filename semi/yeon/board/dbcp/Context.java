package yeon.board.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class Context {
	public BasicDataSource basicDataSource; //�ν��Ͻ� ��������
	public Context( ) { basicDataSource = new BasicDataSource( );
	basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	basicDataSource.setUsername("unlimited");
	basicDataSource.setPassword("1234");
	basicDataSource.setInitialSize(4); //�ʱ� Ŀ�ؼ� ��ü���� 
	basicDataSource.setMaxIdle(100);// �����ϴ� Ŀ�ؼ� ��ü�� �����ִ밳��
	basicDataSource.setMinIdle(5); //�����ϴ� Ŀ�ؼǰ�ü �����ּҰ���
}
}