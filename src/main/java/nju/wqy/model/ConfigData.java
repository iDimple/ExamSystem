package nju.wqy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "config")
public class ConfigData {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    @NotNull
	    @Column(name = "startTime")
	    private Date startTime;

	    @NotNull
	    @Column(name = "endTime")
	    private Date endTime;


	    @NotNull
	    @Column(name = "questionNumber")
	    private Integer questionNumber;

	    @NotNull
	    @Column(name = "isQuestionRandom")
	    private Boolean isQuestionRandom;

	    @NotNull
	    @Column(name = "isOptionRandom")
	    private Boolean isOptionRandom;


	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Date getStartTime() {
	        return startTime;
	    }

	    public void setStartTime(Date startTime) {
	        this.startTime = startTime;
	    }

	    public Date getEndTime() {
	        return endTime;
	    }

	    public void setEndTime(Date endTime) {
	        this.endTime = endTime;
	    }

	    public Integer getQuestionNumber() {
	        return questionNumber;
	    }

	    public void setQuestionNumber(Integer questionNumber) {
	        this.questionNumber = questionNumber;
	    }

	    public Boolean isQuestionRandom() {
	        return isQuestionRandom;
	    }

	    public void setQuestionRandom(Boolean questionRandom) {
	        isQuestionRandom = questionRandom;
	    }

	    public Boolean isOptionRandom() {
	        return isOptionRandom;
	    }

	    public void setOptionRandom(Boolean optionRandom) {
	        isOptionRandom = optionRandom;
	    }
}
