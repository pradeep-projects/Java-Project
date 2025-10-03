package pradeepshah.SpringProject.demo.Service;

public class MultiThreadingService extends Thread{
    @Override
    public void run(){
        System.out.println("code executed by thread: " + Thread.currentThread().getName());
    }
}
