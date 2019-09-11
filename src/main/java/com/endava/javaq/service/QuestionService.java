package com.endava.javaq.service;

import com.endava.javaq.config.JavaqProperties;
import com.endava.javaq.model.Question;
import com.endava.javaq.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.*;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final JavaqProperties javaqProperties;

    public List<Question> generateTest() {
        // bad implementation
        Random rand = new Random();
        return
                IntStream.generate(() -> rand.nextInt(11))
                        .peek(System.out::println)
                        .mapToObj(x -> questionRepository.findById((long)x).orElse(null))
                        .filter(el -> !isNull(el))
                        .limit(javaqProperties.getNumberOfQuestions())
                        .collect(toList());
    }
}
