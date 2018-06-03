package cn.doublehh.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author 胡昊
 * Date: 2018/4/29
 * Time: 14:13
 * Create: DoubleH
 */
@Service
public class TaskTest {

    @Scheduled(cron = "00 18 14 * * ?")
    public void test1() throws InterruptedException {
        while (true){
            System.out.println(Thread.currentThread().getName()+": 111");
            Thread.sleep(1000);
        }
    }

    @Scheduled(cron = "05 18 14 * * ?")
    public void test2() throws InterruptedException {
        while (true){
            System.out.println(Thread.currentThread().getName()+": 222");
            Thread.sleep(1000);
        }
    }
}
