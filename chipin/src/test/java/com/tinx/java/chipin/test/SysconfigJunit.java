package com.tinx.java.chipin.test;

import com.tinx.java.chipin.entity.Sysconfig;
import com.tinx.java.chipin.service.SysconfigService;
import com.tinx.java.chipin.utils.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tinx
 * @date 2018-10-7 21:36
 */
public class SysconfigJunit extends LotteryApplicationTests {

    @Autowired
    private SysconfigService sysconfigService;
    @Test
    public void testRandom(){
        Sysconfig sysconfig = sysconfigService.getValue("LOTTERY","JINJIU");
        int i = 0;
        while(i<20){
            String url = RandomUtils.getUrl(sysconfig.getCfgValue());
            System.out.println(url);
            i++;
        }

    }
}
