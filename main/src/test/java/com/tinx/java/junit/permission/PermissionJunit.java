package com.tinx.java.junit.permission;

import com.baomidou.mybatisplus.mapper.Condition;
import com.tinx.java.junit.MainApplicationTests;
import com.tinx.java.permission.entity.ModelMsg;
import com.tinx.java.permission.service.ModelMsgService;
import com.tinx.java.permission.service.ObjPermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author tinx
 * @date 2018-10-29 23:24
 */
public class PermissionJunit extends MainApplicationTests {

    @Autowired
    private ModelMsgService modelMsgService;

    @Autowired
    private ObjPermissionService objPermissionService;
    @Test
    public void addPermission(){
        List<ModelMsg> list = modelMsgService.selectList(Condition.create().eq("app_name","chipin").eq("module_name","userLottery"));
        for(ModelMsg modelMsg:list){

        }
    }
}
