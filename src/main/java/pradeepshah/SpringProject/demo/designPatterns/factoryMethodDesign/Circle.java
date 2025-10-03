package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class Circle implements Shape{
    @Override
    public void computeArea(){
        System.out.println("Circle area");
    }
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}
