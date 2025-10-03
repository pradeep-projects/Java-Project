package pradeepshah.SpringProject.demo.DSA.InterviewAsked;

public class expedia {

    public static int minOperation(int x, int y){
        int countOperation = 0;
        while(y > x){
            y /= 2;
            countOperation++;
        }
        countOperation += (x - y);
        return countOperation;
    }

    public static void main(String[] args){
        System.out.println(minOperation(40,10));
    }


}
