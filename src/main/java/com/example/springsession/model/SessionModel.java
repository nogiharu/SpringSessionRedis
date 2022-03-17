package com.example.springsession.model;


import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("SessionModel")
public class SessionModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
}