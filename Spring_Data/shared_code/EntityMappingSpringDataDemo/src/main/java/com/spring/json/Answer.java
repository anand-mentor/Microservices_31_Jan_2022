package com.spring.json;

public class Answer {

	private Long ansId;
	
	private String answer;

	public Answer() {}
	
	public Answer(String answer) {
		this.answer = answer;
	}
	public Answer(Long ansId, String answer) {
		this.ansId = ansId;
		this.answer = answer;
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
	public String toString() {
		return "Answer: " + ansId + " - " + answer;
	}
}
