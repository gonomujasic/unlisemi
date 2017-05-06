package ryu.studyboard.control;

import java.io.BufferedReader;
import java.io.IOException;

public interface StudyboardAction {
public void execute(BufferedReader bufferedReader) throws IOException;
}