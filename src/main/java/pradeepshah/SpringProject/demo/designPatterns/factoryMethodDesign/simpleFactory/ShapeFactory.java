package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign.simpleFactory;

import pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign.*;

public class ShapeFactory {
    public static Shape createShapeInstance(ShapeType shapeType){
        if(shapeType==null){
            return null;
        }
        return switch (shapeType){
            case CIRCLE -> new Circle();
            case SQUARE -> new Square();
            case RECTANGLE -> new Rectangle();
            default -> throw new IllegalStateException("ShapeType doesn't exist");
        };
    }
}
