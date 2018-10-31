package com.tinx.java.junit.sysconfig;

import com.tinx.java.junit.MainApplicationTests;
import com.tinx.java.permission.entity.SysConfig;
import com.tinx.java.permission.service.SysConfigService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tinx
 * @date 2018-10-29 20:23
 */
public class SysconfigJunit extends MainApplicationTests {

    @Autowired
    private SysConfigService sysConfigService;

    @Test
    public void testAdd(){
        SysConfig sysconfig = new SysConfig();
        sysconfig.setCfgKeyPrefix("INTERCEPTOR");
        sysconfig.setCfgKeySuffix("APP");
        sysconfig.setCfgValue("chipin,permission");
        sysConfigService.insert(sysconfig);
    }
}
