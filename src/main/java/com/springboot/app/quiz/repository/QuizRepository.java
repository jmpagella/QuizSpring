package com.springboot.app.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.quiz.models.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long>{

}
