package com.springboot.app.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.quiz.models.Quiz;
import com.springboot.app.quiz.repository.QuizRepository;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	@Autowired
	private QuizRepository quizRepository;
	
	@GetMapping("")
	public List<Quiz> allUsers(){
		return (List<Quiz>) quizRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Quiz> findById(@PathVariable Long id) {
		return quizRepository.findById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz create(@RequestBody Quiz quiz) {
		return quizRepository.save(quiz);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz update(@RequestBody Quiz quiz, @PathVariable Long id) {
		Quiz quizDb = quizRepository.findById(id).get();
		quizDb.setTitle(quiz.getTitle());
		quizDb.setCreatedAt(quiz.getCreatedAt());
		return quizRepository.save(quizDb);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		quizRepository.deleteById(id);
	}
}
