package pradeepshah.SpringProject.demo.Config;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SharedResource {
    private Queue<Integer> bufferQueue;
    private Integer bufferSize;
    private Boolean isBufferEmpty = true;
    private LoggerConfig logger  = LoggerConfig.getLoggerInstance();
    public SharedResource(Integer bufferSize){
        this.bufferSize = bufferSize;
        this.bufferQueue = new LinkedList<>();
        // thread safe, only one thread can access the block
        //  thread safe, if it is full wait until space is available
    }
    public synchronized void addRecord(Integer record){
       try {
           logger.info("add record : current thread" + record +  Thread.currentThread().getName());
           while(bufferQueue.size() == bufferSize){
               logger.info("queue is full waiting for consumer to consume" );
               wait();// wait till there space available
           }
           bufferQueue.add(record);
           logger.info("data produced: " + record);
           isBufferEmpty = false;
           notifyAll(); //  notify all other thread waiting for this resource to release
       }catch (Exception ex){
           logger.error("Exception while adding to buffer:" +  ex.getLocalizedMessage());
       }
    }
    public synchronized void removeRecord(){
        try {
            logger.info("remove record : current thread" + Thread.currentThread().getName());
            while(isBufferEmpty){
                logger.info("buffer is empty, wait for producer to produce some data");
                wait();
            }
            logger.info("data consumed: " + bufferQueue.poll());
            notifyAll(); //  notify all other thread waiting for this resource to release
        }catch (Exception e){
            logger.error("Exception while adding to buffer:" +  e.getLocalizedMessage());
        }

    }

}
