package pradeepshah.SpringProject.demo.threadPool;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinService {
    private LoggerConfig logger  = LoggerConfig.getLoggerInstance();
    void forJoinThreadPoolExecution() {
        long FJPStart = System.currentTimeMillis();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new ComputeSumTask(0, 100000000));
        try {
            int result = future.get(); // wait for task to finish
            long FJPEnd = System.currentTimeMillis();

            logger.info("item total: " + result + " processing time: " + (FJPEnd - FJPStart));
        } catch (Exception ex) {
            logger.info("exception while performing thread pool operation" + ex.getLocalizedMessage());
        }

        int count = 0;
        long loopStart = System.currentTimeMillis();
        for (int i = 0; i <= 100000000; i++) {
            count += i;
        }
        long loopEnd = System.currentTimeMillis();
        logger.info("item2 total: " + count + " processing time: " + (loopEnd - loopStart));

    }

}
