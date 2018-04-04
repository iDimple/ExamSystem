package nju.wqy.constants;

import java.util.List;

public class NameList {
	public List<Integer> students; //namelist only keeps the UIDs of students participating this exam
	public NameList(){}
	public NameList(List<Integer> students) {
		super();
		this.students = students;
	}
	@Override
	public String toString() {
		return "NameList [students=" + students + "]";
	}
	
}
