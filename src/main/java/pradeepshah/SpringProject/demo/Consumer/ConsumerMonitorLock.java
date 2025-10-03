package pradeepshah.SpringProject.demo.Consumer;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

public class ConsumerMonitorLock implements Runnable{

    /**
     * Runs this operation.
     */
    private LoggerConfig logger = LoggerConfig.getLoggerInstance();

    @Override
    public void run() {
        System.out.println();
        logger.info("before producer starts");
    }
}
