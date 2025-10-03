package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class SquareCreator extends ShapeFactory2{
    @Override
    public Shape createShapeInstance() {
        return new Square();
    }
}