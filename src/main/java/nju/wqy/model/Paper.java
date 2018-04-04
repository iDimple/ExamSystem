package nju.wqy.model;

import java.util.ArrayList;
import java.util.List;

public class Paper {
List<QuestionVO> questions=new ArrayList<QuestionVO>();

public List<QuestionVO> getQuestions() {
	return questions;
}

public void setQuestions(List<QuestionVO> questions) {
	this.questions = questions;
}

}
