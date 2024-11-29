package com.todo.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    @RequestMapping("/list")
    public String list(){
        return "list";
    }

    @PostConstruct
    public void construct(){
        System.out.println("construct init");
    }
}
