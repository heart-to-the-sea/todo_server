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
    @PostMapping("/login")
    public R<?> login(@RequestBody UserBo userBo) {
       return userService.login(userBo);
    }
    @PostMapping("/logout")
    public R<?> logout(@RequestBody UserBo userBo) {
        return userService.logout(userBo);
    }

    @PostMapping("/list")
    public R<?> list(@RequestBody UserBo userBo) {
        return userService.list(userBo);
    }
    @PostMapping("/insert")
    public R<?> insert(@RequestBody UserBo userBo) {
        return userService.addUser(userBo);
    }
    @PostMapping("/update")
    public R<?> update(@RequestBody UserBo userBo) {
        return userService.updateUser(userBo);
    }
    @PostMapping("/delete")
    public R<?> delete(@RequestBody UserBo userBo) {
        return userService.deleteUser(userBo);
    }
    @PostMapping("/updatePassword")
    public R<?> updatePassword(@RequestBody UserBo userBo) {
        return userService.updatePassword(userBo);
    }
    @PostMapping("/info")
    public R<?> info(@RequestBody UserBo userBo) {
        return userService.userInfo(userBo);
    }

}
