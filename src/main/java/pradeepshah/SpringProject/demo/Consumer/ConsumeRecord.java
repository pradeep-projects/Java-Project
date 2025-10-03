package pradeepshah.SpringProject.demo.Consumer;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;
import pradeepshah.SpringProject.demo.Config.SharedResource;

public class ConsumeRecord {
    private SharedResource sharedResource;
    public ConsumeRecord(SharedResource instance){
        sharedResource = instance;
    }
    private LoggerConfig logger = LoggerConfig.getLoggerInstance();
    public void consumeRecord(){
        logger.info("in consumer block");
        sharedResource.removeRecord();
    }
}
