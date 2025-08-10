package dev.evolting.quizapp.controllers;

import dev.evolting.quizapp.entities.Quiz;
import dev.evolting.quizapp.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all-quiz")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.addQuiz(category, numQ, title);
    }
}
