package com.todo.service;

import com.todo.domain.bo.UserBo;
import com.todo.domain.vo.UserVo;
import com.todo.utils.PageRequest;
import com.todo.utils.R;

import java.util.List;
/**
* @author xing
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-29 11:20:49
*/
public interface UserService {
    R<?> login(UserBo userBo);
    R<?> logout(UserBo userBo);
    R<?> list(UserBo userBo);
}
