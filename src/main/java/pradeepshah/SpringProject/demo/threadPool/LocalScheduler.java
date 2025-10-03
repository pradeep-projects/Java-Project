package pradeepshah.SpringProject.demo.threadPool;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LocalScheduler {
    private LoggerConfig logger  = LoggerConfig.getLoggerInstance();
    void localSchedularExample() {
        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);
        // if need to return a value than use callable
        Future<?> future2 = poolObj.scheduleAtFixedRate(() -> {
            logger.info("Hello scheduler1");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception ex) {
                logger.info("ddd" + ex);
            }
            logger.info(" task1 completed ");
        }, 5, 4, TimeUnit.SECONDS);

        Thread t1 = new Thread(() -> {
            LoggerConfig loggerConfig = LoggerConfig.getLoggerInstance();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception ex) {

            }

        });
        logger.info("before thread one execution");
        t1.start();
        logger.info("after thread one execution");
    }
}
