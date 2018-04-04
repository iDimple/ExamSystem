package nju.wqy.model;

public class Exam {
	private int examId;
	private int courseId;
	private int ConfigId;
	private String QFile;
	private String UFile;

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getConfigId() {
		return ConfigId;
	}

	public void setConfigId(int configId) {
		ConfigId = configId;
	}

	public String getQFile() {
		return QFile;
	}

	public void setQFile(String qFile) {
		QFile = qFile;
	}

	public String getUFile() {
		return UFile;
	}

	public void setUFile(String uFile) {
		UFile = uFile;
	}

}
