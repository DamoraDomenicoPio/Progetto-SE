/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.shape.Shape;
import newShapes.NewShape;

/**
 @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/

public abstract class ObjectTool extends Tool{
    /**
     * Represents the shape on which the trasformation will be executed.
     */
    protected NewShape shape; 
    
    
    public NewShape getShape() {
        return shape;
    }
    
    
    public void setShape(Shape shape) {
        this.shape = (NewShape) shape;
    }
    
}
