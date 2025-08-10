package dev.evolting.quizapp.services.impl;

import dev.evolting.quizapp.entities.Question;
import dev.evolting.quizapp.repositories.QuestionRepository;
import dev.evolting.quizapp.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}
