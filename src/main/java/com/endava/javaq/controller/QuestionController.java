package com.endava.javaq.controller;

import com.endava.javaq.model.Answer;
import com.endava.javaq.model.Question;
import com.endava.javaq.repository.QuestionRepository;
import com.endava.javaq.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    private final QuestionService questionService;

    @GetMapping("/save")
    public void save() {
        questionRepository.deleteAll();
        this.init();
    }

    @GetMapping("/")
    public List<Question> getTest() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/by-id/{id}")
    public Question getQuestionById(@PathVariable(name = "id") Long id) {
        return questionRepository.findById(id).get();
    }

    @GetMapping("/generate/test")
    public List<Question> generateTest() {
        return questionService.generateTest();
    }

    private void init() {
        String[] words = {"be", "have", "go", "eat", "forget", "believe", "love", "die", "sleep", "dig"};
        AtomicLong i = new AtomicLong(1);

        Stream.of(words)
                .forEach(w -> {

                    Set<Answer> answers = Stream.of(
                            new Answer(1L, "To " + w, true),
                            new Answer(2L, "Not to " + w, false)
                    ).collect(toSet());

                    System.out.println(questionRepository.save(new Question(i.getAndIncrement(), "To " + w + " or not to " + w, answers)));
                });

    }
}
