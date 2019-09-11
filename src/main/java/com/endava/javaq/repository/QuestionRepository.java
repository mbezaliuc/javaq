package com.endava.javaq.repository;

import com.endava.javaq.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuestionRepository extends MongoRepository<Question, Long> {
}
