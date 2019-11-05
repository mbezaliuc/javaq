package com.endava.javaq.controller;

import com.endava.javaq.model.Question;
import com.endava.javaq.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/save")
    public void save(@RequestBody Question question) {
        questionService.save(question);
    }

    @GetMapping("/")
    public List<Question> getTest() {
        return questionService.findAll();
    }

    @GetMapping("/question/by-id/{id}")
    public Question getQuestionById(@PathVariable(name = "id") Long id) {
        return questionService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No value present"));
    }

    @GetMapping("/generate/test")
    public List<Question> generateTest() {
        return questionService.generateTest();
    }

}
