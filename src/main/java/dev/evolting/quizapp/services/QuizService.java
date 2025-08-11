package dev.evolting.quizapp.services;

import dev.evolting.quizapp.dtos.QuestionDTO;
import dev.evolting.quizapp.entities.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    public ResponseEntity<List<Quiz>> getAllQuiz();
    public ResponseEntity<Quiz> getQuizById(Integer id);
    ResponseEntity<String> addQuiz(String category, Integer numQ, String title);
    ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id);
}
