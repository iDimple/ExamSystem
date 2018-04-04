package  nju.wqy.constants;

import java.util.List;

public class Question {
	public String title;
	public int score;
	public boolean isSingleOption;
	public List<Option> options;
	
	public Question(){}
	public Question(String title, int score, boolean isSingleOption, List<Option> options) {
		super();
		this.title = title;
		this.score = score;
		this.isSingleOption = isSingleOption;
		this.options = options;
	}
	@Override
	public String toString() {
		return "Question [title=" + title + ", score=" + score + ", isSingleOption=" + isSingleOption + ", options="
				+ options + "]";
	}
	
}
