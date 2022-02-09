package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.one_to_many.QuestionEntity;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long>{

}
