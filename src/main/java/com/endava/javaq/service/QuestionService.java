package com.endava.javaq.service;

import com.endava.javaq.config.JavaqProperties;
import com.endava.javaq.model.Question;
import com.endava.javaq.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.*;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final JavaqProperties javaqProperties;

    public List<Question> generateTest() {
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions);
        return questions.stream()
                .limit(javaqProperties.getNumberOfQuestions())
                .collect(toList());
    }


    public void deleteAll() {
        questionRepository.deleteAll();
    }


    public boolean save(Question question) {
        return !isNull(questionRepository.save(question));
    }


    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

}
