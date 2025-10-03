package pradeepshah.SpringProject.demo.threadPool;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalService {
    private LoggerConfig logger  = LoggerConfig.getLoggerInstance();

    void testThreadLocal(){
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        threadLocalObj.set(Thread.currentThread().getName());

        ExecutorService pool = Executors.newFixedThreadPool(5);

        pool.submit(()->{
            threadLocalObj.set(Thread.currentThread().getName());
            // work completed then clean up
        });
        for(int i=0;i<15;i++){
            pool.submit(()->{
                logger.info("current thread" + threadLocalObj.get());
            });
        }
    }

}
