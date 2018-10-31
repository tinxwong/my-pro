package com.tinx.java.chipin.test;

import com.tinx.java.chipin.core.rule.ChipinRule;
import com.tinx.java.chipin.core.rule.Rule;
import org.junit.Test;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author tinx
 * @date 2018-10-7 22:40
 */
public class ChipinRuleJunit extends  LotteryApplicationTests{

    @Test
    public void testReflect(){
        Reflections reflections = new Reflections("com.tinx.java.chipin.core");
        Set<Class<? extends ChipinRule>> subTypes = reflections.getSubTypesOf(ChipinRule.class);

        for (Class<? extends Rule> clz : subTypes) {
            System.out.println("======"+clz.getName());
            try{
                Method method = clz.getMethod("getRuleName");
                String ruleName = (String)method.invoke(clz.newInstance());
                System.out.println("ruleName : "+ruleName);
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

}
