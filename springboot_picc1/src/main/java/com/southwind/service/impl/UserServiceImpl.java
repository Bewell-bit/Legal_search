package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.User;
import com.southwind.form.LoginForm;
import com.southwind.mapper.UserMapper;
import com.southwind.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-09-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


}
