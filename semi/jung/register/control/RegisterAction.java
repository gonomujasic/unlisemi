package jung.register.control;

import java.io.BufferedReader;
import java.io.IOException;

//정해선
//20170421작성
//mvc패턴을 맞추기 위해 공통된 부분 인터페이스로 생성하였음.

public interface RegisterAction {
	public void execute(BufferedReader bufferedReader)throws IOException;
}
