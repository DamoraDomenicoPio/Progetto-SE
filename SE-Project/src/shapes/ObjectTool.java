/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Shape;
import newShapes.NewShape;

/**
 *
 * @author assun
 * A Tool that executes a trasformation on a give object 
 */
public abstract class ObjectTool extends ShapeTool{
    protected NewShape shape; //The shape on which the trasformation will be executed

    public NewShape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = (NewShape) shape;
    }
    
    
}
