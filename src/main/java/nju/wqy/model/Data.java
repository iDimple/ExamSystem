package nju.wqy.model;

import nju.wqy.constants.QuestionSet;

public class Data {
private UserData student;
private Paper paper;
private ExamDetail examDetail;

public ExamDetail getExamDetail() {
	return examDetail;
}
public void setExamDetail(ExamDetail ed) {
	this.examDetail = ed;
}
public UserData getUserData() {
	return student;
}
public void setUserData(UserData student) {
	this.student = student;
}
public Paper getPaper() {
	return paper;
}
public void setPaper(Paper paper) {
	this.paper = paper;
}

}
