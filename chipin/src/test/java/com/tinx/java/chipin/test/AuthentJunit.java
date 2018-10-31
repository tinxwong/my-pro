package com.tinx.java.chipin.test;

import com.tinx.java.chipin.core.DefaultAuthent;
import com.tinx.java.chipin.core.rule.ChipinRule;
import com.tinx.java.chipin.core.rule.Rule;
import com.tinx.java.chipin.entity.Sysconfig;
import com.tinx.java.chipin.service.SysconfigService;
import com.tinx.java.chipin.utils.FileUtils;
import org.junit.Test;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author tinx
 * @date 2018-10-8 22:26
 */
public class AuthentJunit extends LotteryApplicationTests {

    @Autowired
    private SysconfigService sysconfigService;

    @Test
    public void testReflect(){
        Reflections reflections = new Reflections("com.tinx.java.chipin.core");
        Set<Class<? extends DefaultAuthent>> subTypes = reflections.getSubTypesOf(DefaultAuthent.class);

        for (Class<? extends DefaultAuthent> clz : subTypes) {
            System.out.println("======"+clz.getName());
            try{
                Method method = clz.getMethod("getAuthentName");
                String authentName = (String)method.invoke(clz.newInstance());
                System.out.println("authentName : "+authentName);
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testCreateFile(){
        Sysconfig sysconfig = sysconfigService.getValue("LOTTERY","TEMP");
        String rooPath = sysconfig.getCfgValue();
        String path = rooPath+"/1/1/";
        FileUtils.createFile(path,"11.txt");
    }

    @Test
    public void testCreateFile1(){
        Sysconfig sysconfig = sysconfigService.getValue("LOTTERY","TEMP");
        String rooPath = sysconfig.getCfgValue();
        File file = new File(rooPath+"/users/mkyong/filename.txt");
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // if file doesnt exists, then create it

    }
}
