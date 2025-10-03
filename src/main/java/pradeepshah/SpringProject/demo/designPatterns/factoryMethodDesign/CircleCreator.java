package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class CircleCreator extends ShapeFactory2{
    @Override
    public Shape createShapeInstance() {
        return new Circle();
    }
}
