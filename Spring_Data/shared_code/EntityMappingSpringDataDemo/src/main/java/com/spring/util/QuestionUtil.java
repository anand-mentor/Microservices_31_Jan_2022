package com.spring.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.spring.entity.one_to_many.AnswerEntity;
import com.spring.entity.one_to_many.QuestionEntity;
import com.spring.json.Answer;
import com.spring.json.Question;

public class QuestionUtil {

	public static Answer convertAnswerEntityIntoAnswer(AnswerEntity answerEntity) {
		return new Answer(answerEntity.getAnsId(), answerEntity.getAnswer());
	}
	
	public static AnswerEntity convertAnswerIntoAnswerEntity(Answer answer, QuestionEntity questionEntity) {
		return new AnswerEntity(answer.getAnswer(), questionEntity);
	}
	
	public static Question convertQuestionEntityIntoQuestion(QuestionEntity questionEntity) {
		List<AnswerEntity> answerEntities = questionEntity.getAnswers();
		List<Answer> answers = new ArrayList<Answer>();
		Question question = new Question(questionEntity.getQusDesc());
		for(AnswerEntity answerEntity: answerEntities)
			answers.add(convertAnswerEntityIntoAnswer(answerEntity));
		question.setQusId(questionEntity.getQusId());
		question.setAnswers(answers);
		return question;
	}

	public static QuestionEntity convertQuestionIntoQuestionEntity(Question question) {
		QuestionEntity questionEntity = new QuestionEntity(question.getQusDesc());
		List<Answer> answers = question.getAnswers();
		List<AnswerEntity> answerEntities = new ArrayList<AnswerEntity>();
		for(Answer answer: answers)
			answerEntities.add(convertAnswerIntoAnswerEntity(answer, questionEntity));
		questionEntity.setAnswers(answerEntities);
		return questionEntity;
	}

	public static List<Question> convertQuestionEntityListIntoQuestionList(List<QuestionEntity> questionEntityList) {
		List<Question> questions = new ArrayList<Question>();
		for(QuestionEntity questionEntity: questionEntityList) {
			questions.add(convertQuestionEntityIntoQuestion(questionEntity));
		}
		return questions;
	}
}
