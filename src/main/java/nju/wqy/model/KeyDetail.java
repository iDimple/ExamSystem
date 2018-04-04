package nju.wqy.model;

public class KeyDetail {
private String key;
private int uid;
private int examId;

public KeyDetail(String key) {
	super();
	this.key = key;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getExamId() {
	return examId;
}
public void setExamId(int examId) {
	this.examId = examId;
}

}
