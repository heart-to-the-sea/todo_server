package com.todo.api.controller;

import com.todo.domain.bo.UserBo;
import com.todo.service.UserService;
import com.todo.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/list")
    public R<?> list(@RequestBody UserBo userBo) {
        return userService.list(userBo);
    }
}
