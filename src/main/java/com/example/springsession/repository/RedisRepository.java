package com.example.springsession.repository;

import com.example.springsession.model.SessionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RedisRepository extends CrudRepository<SessionModel,Integer>{
    
}