package pradeepshah.SpringProject.demo.threadPool;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {
    int start;
    int end;

    int THRESHOLD = 4;
    public ComputeSumTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    LoggerConfig logger = LoggerConfig.getLoggerInstance();

    @Override
    protected Integer compute(){
        if(end - start <= THRESHOLD){
            int itemTotal = 0;
            for(int i = start; i <= end; i++){
                itemTotal += i;
            }
            return itemTotal;
        }else{
            // split the task
            int mid = (start + end) / 2;
            ComputeSumTask leftTask = new ComputeSumTask(start,mid);
            ComputeSumTask rightTask = new ComputeSumTask(mid + 1, end);

            // fork the subtasks for parallel execution;
            leftTask.fork();
            rightTask.fork();

            // combine the results of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine the results
            return  leftResult + rightResult;
        }
    }
}
