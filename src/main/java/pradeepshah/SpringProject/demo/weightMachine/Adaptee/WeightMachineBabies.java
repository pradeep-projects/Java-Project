package pradeepshah.SpringProject.demo.weightMachine.Adaptee;

public class WeightMachineBabies implements WeightMachine{
    @Override
    public Double getWeightInPound(){
        return (double)28;
    }
}
