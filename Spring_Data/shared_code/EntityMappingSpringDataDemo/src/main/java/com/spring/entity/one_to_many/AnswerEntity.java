package com.spring.entity.one_to_many;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
public class AnswerEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long ansId;
	
	@Column(name="answer")
	private String answer;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="question_id")
	private QuestionEntity question;

	public AnswerEntity() {}
	
	public AnswerEntity(String answer) {
		this.answer = answer;
	}
	public AnswerEntity(String answer, QuestionEntity question) {
		this.answer = answer;
		this.question = question;
	}
	public Long getAnsId() {
		return ansId;
	}
	public void setAnsId(Long ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public QuestionEntity getQuestion() {
		return question;
	}
	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
	public String toString() {
		return "Answer: " + ansId + " - " + answer;
	}
}
