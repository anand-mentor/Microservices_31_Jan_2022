package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Question;
import com.spring.service.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapp")
public class QuestionAnswerController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping(value="/question", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@PostMapping(value="/question", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Question createNewQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
}
