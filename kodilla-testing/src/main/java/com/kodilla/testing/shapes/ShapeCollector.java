package com.kodilla.testing.shapes;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public int getShapeCount() {
        return shapes.size();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure (int n){
        return shapes.get(n);
    }

    public String showFigures (){
        StringBuilder allShapes = new StringBuilder();
        Boolean firstIteration = true;
        for (Shape shape : shapes) {
            if (firstIteration) {
                firstIteration = false;
            } else {
                allShapes.append(", ");
            }
            allShapes.append(shape.getShapeName());
        }
        return allShapes.toString();
    }

}


