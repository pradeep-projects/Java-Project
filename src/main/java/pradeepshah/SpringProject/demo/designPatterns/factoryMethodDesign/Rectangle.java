package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class Rectangle implements Shape{
    @Override
    public void computeArea(){
        System.out.println("Rectangle area");
    }
    @Override
    public void draw(){
        System.out.println("Rectangle");
    }
}
