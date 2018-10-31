package com.tinx.java.main.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.tinx.java.chipin.entity.ChipinEntity;
import lombok.Data;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author tinx123
 * @since 2018-08-11
 */
@Data
public class User extends ChipinEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 真实名
     */
    @TableField("true_name")
    private String trueName;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 电话
     */
    private String phone;
    /**
     * 性别
     */
    private String sex;
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;

}
