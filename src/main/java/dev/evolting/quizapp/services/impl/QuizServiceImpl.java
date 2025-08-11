package dev.evolting.quizapp.services.impl;

import dev.evolting.quizapp.dtos.QuestionDTO;
import dev.evolting.quizapp.entities.Question;
import dev.evolting.quizapp.entities.Quiz;
import dev.evolting.quizapp.repositories.QuestionRepository;
import dev.evolting.quizapp.repositories.QuizRepository;
import dev.evolting.quizapp.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(
            QuizRepository quizRepository
            , QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return new ResponseEntity<>(quizRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Quiz> getQuizById(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (!quiz.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(quiz.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addQuiz(String category, Integer numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Boolean isAdded = quizRepository.save(quiz) != null;

        return isAdded ?
                new ResponseEntity<>("Quiz Added Successfully", HttpStatus.CREATED)
                : new ResponseEntity<>("Quiz Not Added", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (!quiz.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : quiz.get().getQuestions()) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestionTitle(question.getQuestionTitle());
            questionDTO.setOption1(question.getOption1());
            questionDTO.setOption2(question.getOption2());
            questionDTO.setOption3(question.getOption3());
            questionDTO.setOption4(question.getOption4());

            questionDTOS.add(questionDTO);
        }
        return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
    }
}
