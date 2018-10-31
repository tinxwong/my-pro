package com.tinx.java.junit.main;

import com.tinx.java.chipin.enums.RoleEnum;
import com.tinx.java.chipin.enums.SexEnum;
import com.tinx.java.chipin.utils.StringUtil;
import com.tinx.java.common.response.enums.VisibilityEnum;
import com.tinx.java.junit.MainApplicationTests;
import com.tinx.java.main.entity.User;
import com.tinx.java.main.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tinx
 * @date 2018-10-29 22:44
 */
public class UserJunit extends MainApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        User user = new User();
        user.setPwd(StringUtil.MD5("chipin@123456"));
        user.setUserName("admin");
        user.setTrueName("管理员");
        user.setRoleId(RoleEnum.ADMIN.getCode());
        user.setRoleName(RoleEnum.ADMIN.getName());
        user.setSex(""+SexEnum.MALE.getCode());
        user.setVisibility(VisibilityEnum.CAN_USE.getCode());
        userService.insert(user);
    }
}
