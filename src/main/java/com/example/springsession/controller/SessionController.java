package com.example.springsession.controller;

import javax.servlet.http.HttpSession;

import com.example.springsession.model.SessionModel;
import com.example.springsession.repository.RedisRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SessionController {

    private final RedisRepository redisRepository;
    

    private final HttpSession session;
    
    @GetMapping("/")
    public String test1(SessionModel sessionModel,Model model) {
        sessionModel = (SessionModel)session.getAttribute("sessionModel");
        if (sessionModel == null || redisRepository.findById(sessionModel.getId()) == null){
            session.setAttribute("sessionModel", sessionModel);   
        }else{
            redisRepository.save(sessionModel);
        }
        model.addAttribute("id", session.getId());
        return "hello";
    }
    @PostMapping("/")
    public String test2(SessionModel sessionModel) {
        session.setAttribute("sessionModel", sessionModel);
        return "redirect:/";
    }
    
}