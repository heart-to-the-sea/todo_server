package com.todo.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
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
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

/**
* @author xing
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-29 11:20:49
*/
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    public R<?> login(UserBo userBo) {
        if("admin".equals(userBo.getName()) && "123456".equals(userBo.getPassword())) {
            StpUtil.login(userBo.getId());
            System.out.println(StpUtil.getLoginId());
            return R.success("登录成功: "+StpUtil.getTokenValue());
        }
        return R.fail("登陆失败");
    }
    public R<?> logout(UserBo userBo) {
        StpUtil.logout();
        return R.success("退出成功");
    }

    public R<?> list(UserBo user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<UserVo> userVoList=userMapper.selectPageList(user);
        PageInfo<UserVo> pageInfo=new PageInfo<>(userVoList);
        return R.success(pageInfo);
    }

    @Override
    public R<?> addUser(UserBo userBo) {
        if(Objects.nonNull(userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, userBo.getPhone())))) {
            return R.fail("该手机号已被添加");
        }
        if(Objects.nonNull(userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getAccount, userBo.getAccount())))) {
            return R.fail("该账户已被添加");
        }
        User user=new User();
        user.setAccount(userBo.getAccount());
        user.setPassword(SaSecureUtil.md5(userBo.getPassword()));
        user.setName(userBo.getName());
        user.setPhone(userBo.getPhone());
        return R.success(userMapper.insert(user));
    }

    @Override
    public R<?> userInfo(UserBo userBo) {
        return R.success(userMapper.selectUserById(userBo.getId()));
    }

    @Override
    public R<?> deleteUser(UserBo userBo) {
        return R.success(userMapper.delete(userBo.getId()));
    }

    @Override
    public R<?> updateUser(UserBo userBo) {
        if(Objects.nonNull(userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, userBo.getPhone())))) {
            return R.fail("该手机号已被添加");
        }
        if(Objects.nonNull(userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getAccount, userBo.getAccount())))) {
            return R.fail("该账户已被添加");
        }
        return R.success(userMapper.update(userBo));
    }

    @Override
    public R<?> updatePassword(UserBo userBo) {
        return R.success(userMapper.updatePassword(userBo.getId(),userBo.getPassword()));
    }
}
