package ua.jackson.sweater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

       /* Queue<Integer> q = new CQ<Integer>();

        q.add(2);
        q.add(2);
        q.add(2);
        q.add(2);*/



        SpringApplication.run(Main.class,args);
    }
}
