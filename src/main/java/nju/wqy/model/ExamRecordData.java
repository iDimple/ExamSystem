package nju.wqy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exam_record")
public class ExamRecordData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "exam_id")
	private Integer exam_id;

	@NotNull
	@Column(name = "uid")
	private Integer uid;
	
	@NotNull
	@Column(name = "question_order")
	private String question_order;
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExam_id() {
		return exam_id;
	}

	public void setExam_id(Integer exam_id) {
		this.exam_id = exam_id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getQuestion_order() {
		return question_order;
	}

	public void setQuestion_order(String question_order) {
		this.question_order = question_order;
	}

	public String getOption_order() {
		return option_order;
	}

	public void setOption_order(String option_order) {
		this.option_order = option_order;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getTotal_point() {
		return total_point;
	}

	public void setTotal_point(Integer total_point) {
		this.total_point = total_point;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@NotNull
	@Column(name = "option_order")
	private String option_order;
	
	@NotNull
	@Column(name = "answer")
	private String answer;
	
	@NotNull
	@Column(name = "total_point")
	private Integer total_point;

	@NotNull
	@Column(name = "score")
	private Integer score;
	
}
