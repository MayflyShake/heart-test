package com.example.heart;

import com.example.heart.dao.TestOrderDao;
import com.example.heart.pojo.TestOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HeartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HeartApplication.class, args);
        TestOrderDao testOrderDao = context.getBean(TestOrderDao.class);
        String param = "{\"param1\":\"value1\"}";
        TestOrder t1 = new TestOrder();
        t1.setCreateTime("2024-02-29 09:53:00");
        t1.setParams(param);

        TestOrder t2 = new TestOrder();
        t2.setCreateTime("2024-02-29 09:53:00");
        t2.setParams(param);

        TestOrder t3 = new TestOrder();
        t3.setCreateTime("2024-02-29 09:53:00");
        t3.setParams(param);

        System.out.println("start test");

        new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long begin = System.currentTimeMillis();
            testOrderDao.save(t1);
            long cost1 = System.currentTimeMillis() - begin;
            System.out.println("cost1:" + cost1);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long begin2 = System.currentTimeMillis();
            testOrderDao.save(t2);
            long cost2 = System.currentTimeMillis() - begin2;
            System.out.println("cost2:" + cost2);

        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long begin3 = System.currentTimeMillis();
            testOrderDao.save(t3);
            long cost3 = System.currentTimeMillis() - begin3;
            System.out.println("cost3:" + cost3);

        }).start();


        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
