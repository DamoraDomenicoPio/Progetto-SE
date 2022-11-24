/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Shape;

/**
 *
 * @author assun
 * A Tool that executes a trasformation on a give object 
 */
public abstract class ObjectTool extends ShapeTool{
    private Shape shape; //The shape on which the trasformation will be executed

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
    
    
}
