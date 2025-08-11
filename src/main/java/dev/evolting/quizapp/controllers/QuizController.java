package dev.evolting.quizapp.controllers;

import dev.evolting.quizapp.dtos.QuestionDTO;
import dev.evolting.quizapp.entities.Quiz;
import dev.evolting.quizapp.entities.Response;
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

    @GetMapping("get-question/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.addQuiz(category, numQ, title);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateResult(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
