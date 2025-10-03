package pradeepshah.SpringProject.demo.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerUsingBlockingQueue {
    public void producerConsumerDemo(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // capacity 5

        // Producer
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i); // blocks if queue is full
                    System.out.println(Thread.currentThread().getName() + " produced: " + i);
                    Thread.sleep(200); // simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer
        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int value = queue.take(); // blocks if queue is empty
                    System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                    Thread.sleep(300); // simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start threads
        new Thread(producer, "Producer-1").start();
        new Thread(consumer, "Consumer-1").start();
    }
}

