package dev.evolting.quizapp.services;

import dev.evolting.quizapp.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    public ResponseEntity<List<Question>> getAllQuestion();
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category);
    public ResponseEntity<String> addQuestion(Question question);
}
