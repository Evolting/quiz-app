package dev.evolting.quizapp.controllers;

import dev.evolting.quizapp.entities.Question;
import dev.evolting.quizapp.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all-question")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

}
