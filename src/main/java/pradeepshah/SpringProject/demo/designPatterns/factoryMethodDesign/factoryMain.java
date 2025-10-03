package pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;
import pradeepshah.SpringProject.demo.designPatterns.factoryMethodDesign.simpleFactory.ShapeFactory;

/*
* The Factory Method Pattern is used when we want to encapsulate object creation,
instantiation, and all related business logic in one place.
*
*Factory Method vs Simple Factory
*
Simple Factory (shown in the example):
Static method that creates objects based on parameters
Not a true design pattern, more of a programming idiom
Violates the Open/Closed principle when adding new types
*
Factory Method Pattern (shown in the example):
*
Uses inheritance and polymorphism
Each concrete creator handles one product type
Follows the Open/Closed principle perfectly
The Factory Method Pattern is especially useful in frameworks and libraries that require extension points for
users to customize object creation behavior.
* */
public class factoryMain {
    public static  void main(String[] args){
        // simple factory design method
        LoggerConfig logger = LoggerConfig.getLoggerInstance();
        logger.info("Simple factory design pattern");
        ShapeType shapeType = ShapeType.CIRCLE;
        Shape shape = ShapeFactory.createShapeInstance(shapeType);
        shape.computeArea();
        shape.draw();

        ShapeType shapeTypeSq = ShapeType.SQUARE;
        Shape shape2 = ShapeFactory.createShapeInstance(shapeTypeSq);
        shape2.computeArea();
        shape2.draw();


        logger.info("Factory method design pattern");
        Shape square = getShapeInstance(shapeTypeSq);
        square.computeArea();
        square.draw();
    }

    private static Shape getShapeInstance(ShapeType shapeType){
        Shape shape = null;
        if(shapeType == null){
            return null;
        }
        switch (shapeType) {
            case CIRCLE -> {
                ShapeFactory2 circleCreator = new CircleCreator();
                shape = circleCreator.createShapeInstance();
            }
            case SQUARE -> {
                ShapeFactory2 squareCreator = new SquareCreator();
                shape = squareCreator.createShapeInstance();
            }
            case RECTANGLE -> {
                ShapeFactory2 rectangleCreator = new RectangleCreator();
                shape = rectangleCreator.createShapeInstance();
            }
            default -> throw new IllegalStateException("ShapeType doesn't exist.");
        }
        return shape;
    }
}
