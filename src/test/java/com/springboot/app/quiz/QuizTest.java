package com.springboot.app.quiz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.app.quiz.models.Quiz;
import com.springboot.app.quiz.repository.QuizRepository;

@DataJpaTest
public class QuizTest {

	@Autowired
    private QuizRepository quizRepository;
	
	@Test
	void testAllQuiz() {
		List<Quiz> quiz = (List<Quiz>) quizRepository.findAll();
	    assertThat(quiz).size().isGreaterThan(0);
	}	

	@Test
	void testFindById() {
		Optional<Quiz> quiz = quizRepository.findById(1L);
		assertThat(quiz).isNotNull();
	}

	@Test
	void testCreate() {
		Quiz quiz = new Quiz();
		quiz.setTitle("Test title");
		quiz.setCreatedAt(new Date());
		Quiz savedQuiz = quizRepository.save(quiz);
	    assertThat(savedQuiz.getId()).isGreaterThan(0);
	}

	@Test
	void testDelete() {
		Quiz quiz = quizRepository.findById(1L).get();
		quizRepository.deleteById(quiz.getId());
		
		Optional<Quiz> quizDeleted = quizRepository.findById(1L); 
	    assertThat(quizDeleted).isEmpty();  
	}
	
}
