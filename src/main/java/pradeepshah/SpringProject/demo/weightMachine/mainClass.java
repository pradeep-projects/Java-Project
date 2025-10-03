package pradeepshah.SpringProject.demo.weightMachine;

import pradeepshah.SpringProject.demo.weightMachine.Adaptee.WeightMachineBabies;
import pradeepshah.SpringProject.demo.weightMachine.Adapter.WeightMachineAdapter;
import pradeepshah.SpringProject.demo.weightMachine.Adapter.WeightMachineAdapterImpl;

public class mainClass {
    public static void main(String[] args)  {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineBabies());
        System.out.println( "Weight in Kg: " + weightMachineAdapter.getWeightInKg());
    }
}
