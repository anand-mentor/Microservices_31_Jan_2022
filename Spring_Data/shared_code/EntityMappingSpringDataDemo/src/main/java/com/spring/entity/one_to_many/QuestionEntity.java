package com.spring.entity.one_to_many;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION_BANK")
public class QuestionEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long qusId;
	
	@Column(name="description")
	private String qusDesc;
	
	@OneToMany(cascade={CascadeType.ALL}, 
			fetch=FetchType.LAZY, mappedBy = "question")
	private List<AnswerEntity> answers;
	
	public QuestionEntity() {}
	
	public QuestionEntity(String qusDesc) {
		this.qusDesc = qusDesc;
	}
	public QuestionEntity(String qusDesc, List<AnswerEntity> answers) {
		this.qusDesc = qusDesc;
		this.answers = answers;
	}

	public Long getQusId() {
		return qusId;
	}

	public void setQusId(Long qusId) {
		this.qusId = qusId;
	}

	public String getQusDesc() {
		return qusDesc;
	}

	public void setQusDesc(String qusDesc) {
		this.qusDesc = qusDesc;
	}

	public List<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerEntity> answers) {
		this.answers = answers;
	}
	
	public String toString() {
		return qusId + " - " + qusDesc + " - " + answers;
	}
}
