package com.endava.javaq.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Question {

    @Id
    private Long id;

    private String question;

    private Set<Answer> answers;

}
