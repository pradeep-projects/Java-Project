package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

public class RectangleCreator extends ShapeFactory2{
    @Override
    public Shape createShapeInstance() {
        return new Rectangle();
    }
}
