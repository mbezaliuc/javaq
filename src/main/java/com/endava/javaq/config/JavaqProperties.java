package com.endava.javaq.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class JavaqProperties {

    @Value("${java.questions.amount}")
    private int numberOfQuestions;

}
