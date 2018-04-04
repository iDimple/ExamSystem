package  nju.wqy.constants;

import java.util.List;

public class QuestionSet {

	public List<Question> questions;
	public QuestionSet(){}
	public QuestionSet(List<Question> questions) {
		super();
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "QuestionSet [questions=" + questions + "]";
	}
	
}
