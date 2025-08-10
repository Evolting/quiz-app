package dev.evolting.quizapp.repositories;

import dev.evolting.quizapp.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
