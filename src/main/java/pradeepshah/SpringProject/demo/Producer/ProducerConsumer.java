package pradeepshah.SpringProject.demo.Producer;

import pradeepshah.SpringProject.demo.Config.SharedResource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    public void testProducerConsumer(){
        SharedResource res = new SharedResource(5);
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<10;i++){
            int temp = i;
            Thread producer = new Thread(()->{
                try{
                    Thread thread = new Thread(() -> res.addRecord(temp));
                    thread.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            producer.start();
            threads.add(producer);

        }
        for(int i=0; i<10;i++){
            Thread consumer = new Thread(()->{
                try{
                    res.removeRecord();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            consumer.start();
            threads.add(consumer);
        }
        // wait all thread to finish the task
        for(Thread t : threads){
            try{
                t.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public void testProducerConsumer2() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SharedResource res = new SharedResource(5);
        for (int i = 0; i < 10; i++) {
            int temp = 1;
            executorService.submit(() -> res.addRecord(temp));
        }
        for (int i = 0; i < 10; i++) {
            executorService.submit(res::removeRecord);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void testProducerConsumer3(){
        SharedResource res = new SharedResource(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                res.addRecord(i);
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                res.removeRecord();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void testProducerConsumer4(){
        SharedResource res = new SharedResource(5);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    res.addRecord(id * 100 + j);
                }
            }, "Producer-" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 15; j++) {
                    res.removeRecord();
                }
            }, "Consumer-" + i).start();
        }

    }


}
