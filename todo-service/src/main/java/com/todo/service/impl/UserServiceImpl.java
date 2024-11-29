package com.todo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.todo.domain.User;
import com.todo.domain.bo.UserBo;
import com.todo.domain.vo.UserVo;
import com.todo.mapper.UserMapper;
import com.todo.service.UserService;
import com.todo.utils.R;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* @author xing
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-29 11:20:49
*/
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    public R<?> list(UserBo user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<UserVo> userVoList=userMapper.selectPageList(user);
        PageInfo<UserVo> pageInfo=new PageInfo<>(userVoList);
        return R.success(pageInfo);
    }
}
