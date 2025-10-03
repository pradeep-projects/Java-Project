package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class Square implements Shape{
    @Override
    public void computeArea(){
        System.out.println("Square area");
    }
    @Override
    public void draw(){
        System.out.println("Square");
    }
}
