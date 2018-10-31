package com.tinx.java.chipin.test;

import com.tinx.java.chipin.core.Authent;
import com.tinx.java.chipin.core.JinJiuAuthent;
import com.tinx.java.chipin.core.rule.ChipinRule;
import com.tinx.java.chipin.core.rule.PeriodNumberChipinRule;
import com.tinx.java.chipin.entity.Lottery;
import com.tinx.java.chipin.entity.Task;
import com.tinx.java.chipin.entity.UserLottery;
import com.tinx.java.chipin.service.LotteryService;
import com.tinx.java.chipin.service.TaskExecutorService;
import com.tinx.java.chipin.service.TaskService;
import com.tinx.java.chipin.service.UserLotteryService;
import com.tinx.java.chipin.thread.entity.DemoTaskJob;
import com.tinx.java.chipin.utils.FileUtils;
import com.tinx.java.chipin.utils.RandomUtils;
import com.tinx.java.common.utils.SpringContextHolder;
import org.apache.http.client.CookieStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * @author tinx
 * @date 2018-10-20 15:17
 */
public class TaskJunit extends LotteryApplicationTests {

    @Autowired
    private TaskExecutorService taskExecutorService;

    @Autowired
    private JinJiuAuthent jinJiuAuthent;

    @Autowired
    private PeriodNumberChipinRule periodNumberChipinRule;

    @Autowired
    private TaskService taskService;

    @Autowired
    private LotteryService lotteryService;

    @Autowired
    private UserLotteryService userLotteryService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Test
    public void testStartJob(){
        taskExecutorService.startJob(5l);
    }

    @Test
    public void testExecute(){
        Task task = taskService.selectById(4);
        Lottery lottery = lotteryService.selectById(task.getLotteryId());
        UserLottery userLottery = userLotteryService.selectByUserId(task.getUserId());
        String rootUrl = RandomUtils.getUrl(lottery.getRootUrl());
        Authent authent = (Authent) SpringContextHolder.getBean(lottery.getAuthentClassName());
        authent.setRootUrl(rootUrl);
        authent.init(task,lottery,userLottery);
        authent.simulateLogin();
        authent.simulateAgreement();
        ChipinRule chipinRule = (ChipinRule) SpringContextHolder.getBean(task.getRuleName());
        while(true) {
            chipinRule.setRootUrl(rootUrl);
            chipinRule.execute(authent);
        }
    }

    @Test
    public void testMatch(){
        long startTime = System.currentTimeMillis();
        System.out.println("strart:"+startTime);

        Task task = taskService.selectById(4);
        Lottery lottery = lotteryService.selectById(task.getLotteryId());
        UserLottery userLottery = userLotteryService.selectByUserId(task.getUserId());
        List<String> list = FileUtils.fileContentToList(task.getChipinFilePath());

        String rootUrl = RandomUtils.getUrl(lottery.getRootUrl());
        System.out.println("list"+list);
        jinJiuAuthent.init(task,lottery,userLottery);
        jinJiuAuthent.setRootUrl(rootUrl);
        jinJiuAuthent.simulateLogin();
        jinJiuAuthent.simulateAgreement();

        periodNumberChipinRule.init(task,lottery,userLottery);
        periodNumberChipinRule.setRootUrl(rootUrl);
        while(true){
            periodNumberChipinRule.execute(jinJiuAuthent);
        }

//        List<String> drawNoTables = periodNumberChipinRule.getDrawNoTable(lottery.getDrawNoTableUrl(),0);
//        System.out.println("size:"+drawNoTables.size());
//        memberPrints.add("19022");
//        memberPrints.add("11003");
//        memberPrints.add("62596");
//        memberPrints.add("30268");
//        memberPrints.add("37066");
//        memberPrints.add("07556");
//        memberPrints.add("54820");
//
//        boolean isTrue = false;
//        for(String str:drawNoTables){
//            for(String ci:list){
//                for(int i = 0;i < ci.length(); i++){
//                    if (!Character.isDigit(ci.charAt(i))){
//                        continue;
//                    }
//                    if(ci.charAt(i)!=str.charAt(i)){
//                        isTrue = false;
//                        break;
//                    }
//                    isTrue = true;
//                }
//                if(isTrue){
//                    System.out.println("匹配成功,下注码:"+ci+";历史码:"+str);
//                    break;
//                }
//
//            }
//            if(isTrue){
//                break;
//            }
//        }
    }


    @Test
    public void testTimeTask(){
        try{
            DemoTaskJob demoTaskJob = new DemoTaskJob();
            FutureTask task = new FutureTask(demoTaskJob);
            taskExecutor.submit(task);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
