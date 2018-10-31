package com.tinx.java.permission;

import com.tinx.java.common.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author tinx
 * @date 2018-8-27 22:29
 */
//@SpringBootApplication
public class PermissionApplication {

    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(PermissionApplication.class, args);
        SpringContextUtils.setApplicationContext(app);
    }
}
