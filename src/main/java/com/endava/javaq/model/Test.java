package com.endava.javaq.model;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Test {

    private Long id;
    private String email;
    private Set<Question> questions;
    private TestResult testResult;

}
