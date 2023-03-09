package com.southwind.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.form.LoginForm;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author admin
 * @since 2022-09-07
 */
public interface UserService extends IService<User> {
}
