package nju.wqy.model;

import java.util.List;

public class QuestionVO {

	private String title;
	private boolean isSingleOption;
	private int value;
	private List<OptionVO> optionVOs;

	public List<OptionVO> getOptionVOs() {
		return optionVOs;
	}
	public void setOptionVOs(List<OptionVO> optionVOs) {
		this.optionVOs = optionVOs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSingleOption() {
		return isSingleOption;
	}
	public void setSingleOption(boolean isSingleOption) {
		this.isSingleOption = isSingleOption;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


}
