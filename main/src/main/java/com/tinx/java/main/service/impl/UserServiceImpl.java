package com.tinx.java.main.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tinx.java.main.entity.User;
import com.tinx.java.main.mapper.UserDao;
import com.tinx.java.main.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author tinx123
 * @since 2018-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


}
