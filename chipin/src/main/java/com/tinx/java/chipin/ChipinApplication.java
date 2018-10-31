package com.tinx.java.chipin;

import com.tinx.java.common.utils.SpringContextHolder;
import com.tinx.java.common.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author tinx
 * @date 2018-8-27 22:29
 */
//@SpringBootApplication
public class ChipinApplication {

    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(ChipinApplication.class, args);
        SpringContextUtils.setApplicationContext(app);
    }
}
