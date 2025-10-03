package pradeepshah.SpringProject.demo.weightMachine.Adapter;

import pradeepshah.SpringProject.demo.weightMachine.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }
    @Override
    public Double getWeightInKg(){
        Double weightInPound = weightMachine.getWeightInPound();
        return weightInPound * 0.45;
    }
}
