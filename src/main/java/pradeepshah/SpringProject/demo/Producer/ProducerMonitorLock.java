package pradeepshah.SpringProject.demo.Producer;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

public class ProducerMonitorLock implements Runnable{
    private LoggerConfig logger = LoggerConfig.getLoggerInstance();
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
       logger.info("before producer starts");
    }
}
