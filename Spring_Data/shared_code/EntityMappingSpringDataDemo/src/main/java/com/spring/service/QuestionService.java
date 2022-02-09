package com.spring.service;

import java.util.List;

import com.spring.json.Question;

public interface QuestionService {
	public Question createQuestion(Question question);
	public List<Question> getAllQuestions();
}
