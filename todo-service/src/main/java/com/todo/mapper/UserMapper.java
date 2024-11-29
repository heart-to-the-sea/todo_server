package com.todo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.todo.domain.User;
import com.todo.domain.bo.UserBo;
import com.todo.domain.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @author xing
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-29 11:20:49
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserVo> selectPageList(@Param("param") UserBo userBo);
    int insert(User user);
    int update(UserBo userBo);
    int delete(@Param("id") Long id);
    UserVo selectUserById(@Param("id") Long id);
    UserVo selectUserByPhone(@Param("phone") String phone);
    int updatePassword(@Param("id") Long id, @Param("password") String password);
}
