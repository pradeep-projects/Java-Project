package pradeepshah.SpringProject.demo.Producer;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;
import pradeepshah.SpringProject.demo.Config.SharedResource;

import java.util.Queue;

public class ProduceRecord {

    private SharedResource sharedResource;
    public ProduceRecord(SharedResource instance){
        sharedResource = instance;
    }
    private LoggerConfig logger = LoggerConfig.getLoggerInstance();
    public void produceRecord(Integer record){
        logger.info("in producer block");
        sharedResource.addRecord(record);
    }
}
