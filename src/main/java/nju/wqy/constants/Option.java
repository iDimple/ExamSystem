package  nju.wqy.constants;

public class Option {

	public boolean isCorrect;
	public String title;
	public String content;
	public Option(){}
	public Option(boolean isCorrect, String title, String content) {
		super();
		this.isCorrect = isCorrect;
		this.title = title;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Option [isCorrect=" + isCorrect + ", title=" + title + ", content=" + content + "]";
	}
}
