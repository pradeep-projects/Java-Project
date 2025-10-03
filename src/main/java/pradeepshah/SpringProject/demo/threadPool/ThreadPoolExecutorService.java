package pradeepshah.SpringProject.demo.threadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.concurrent.*;

public class ThreadPoolExecutorService {
    private LoggerConfig logger  = LoggerConfig.getLoggerInstance();

//    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.Hours,
//            new ArrayBlockingQueue<>(10), new ThreadFactory() {
//        @Override
//        public Thread newThread(Runnable r) {
//            return null;
//        }
//    }, new RejectedExecutionHandler() {
//        /**
//         * Method that may be invoked by a {@link ThreadPoolExecutor} when
//         * {@link ThreadPoolExecutor#execute execute} cannot accept a
//         * task.  This may occur when no more threads or queue slots are
//         * available because their bounds would be exceeded, or upon
//         * shutdown of the Executor.
//         *
//         * <p>In the absence of other alternatives, the method may throw
//         * an unchecked {@link RejectedExecutionException}, which will be
//         * propagated to the caller of {@code execute}.
//         *
//         * @param r        the runnable task requested to be executed
//         * @param executor the executor attempting to execute this task
//         * @throws RejectedExecutionException if there is no remedy
//         */
//        @Override
//        public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
//
//        }
//    });

//    ExecutorService poolExecutor2 = Executors.newFixedThreadPool(5); // manually set
//    poolExecutor2.submit(() -> "this is an async task");
//
//    ExecutorService poolExecutor3 = Executors.newCachedThreadPool(); // dynamically create
//    poolExecutor3.submit(() -> "this is an async task");
//
//    ExecutorService poolExecutor3 = Executors.newWorkStealingPool();
//    poolExecutor3.submit(() -> "this is an async task");

}
