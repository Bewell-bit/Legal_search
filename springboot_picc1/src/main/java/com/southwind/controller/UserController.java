package com.southwind.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.southwind.entity.SaveRecord;
import com.southwind.entity.User;
import com.southwind.form.CreatJwt;
import com.southwind.form.LoginForm;
import com.southwind.service.UserService;
import com.southwind.until.ResultVOUtil;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody LoginForm loginForm, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone_num", loginForm.getPhoneNum());
        queryWrapper.eq("password", loginForm.getPassword());
        User user = this.userService.getOne(queryWrapper);
        if(user != null) {
            //若有这个用户则返回一个新生成的token
            String token = CreatJwt.getoken(user);
            response.setHeader("token", token);
            map.put("token", token);
            map.put("username", user.getUsername());
            return ResultVOUtil.success(map);
        }
        return ResultVOUtil.fail();
    }

    @PostMapping("/register")
    //手机号若已注册过则返回错误信息code=-1
    public ResultVO register(@RequestBody User user){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<User> phone_wrapper = new QueryWrapper<>();
        QueryWrapper<User> username_wrapper = new QueryWrapper<>();
        phone_wrapper.eq("phone_num", user.getPhoneNum());
        username_wrapper.eq("username", user.getUsername());
        List<User> list_phone = this.userService.list(phone_wrapper);
        List<User> list_username = this.userService.list(username_wrapper);
        if(list_phone.size()==0) {
            if(list_username.size()==0) {
                boolean save = this.userService.save(user);
                if(save) return ResultVOUtil.success(null);
            }else {
                resultVO.setCode(1);
                resultVO.setData(null);
                return resultVO;
            }
        }
        return ResultVOUtil.fail();
    }
}

