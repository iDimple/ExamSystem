package nju.wqy.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exam")
public class ExamData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "courseId")
	private Integer courseId;


	@Column(name = "configId")
	private Integer configId;

	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name = "QJson")
	private String QJson;

	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name = "UJson")
	private String UJson;

	@Column(name = "isTestGenerated")
	private Boolean isTestGenerated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getQJson() {
		return QJson;
	}

	public void setQJson(String QJson) {
		this.QJson = QJson;
	}

	public String getUJson() {
		return UJson;
	}

	public void setUJson(String UJson) {
		this.UJson = UJson;
	}

	public Boolean isTestGenerated() {
		return isTestGenerated != null && isTestGenerated;
	}

	public void setTestGenerated(Boolean testGenerated) {
		isTestGenerated = testGenerated;
	}
}
