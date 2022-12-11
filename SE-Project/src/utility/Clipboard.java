/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import newShapes.NewShape;

/**
 *
 * @author assun
 */
public class Clipboard {
    private Group group; 
    private Shape copiedShape;  // String that repredents the copied shape in the moment it gets copied 
    private boolean pasted;  // true if the copied shape has already been pasted 

    public Clipboard(Group group) {
        this.group = group;
    }
    
    public boolean isEmpty() {
        return copiedShape == null;
    }
    
    public void copy(Shape shape) {
        this.copiedShape = duplicate(shape);
        this.pasted = false; 
    }
    
    private Shape duplicate(Shape shape) {
        String shapeString = shape.toString(); 
        return NewShape.stringToShape(shapeString);
    }
    
    public Shape paste() {
        System.out.println("Incollando...");
        if (! this.isEmpty()) {
            if (pasted == true) { // if the shape has been already pasted once
                this.copiedShape = duplicate(copiedShape);  // it create a new shape to paste 
                
            }
            ((NewShape) this.copiedShape).moveOffset(5.0);
            group.getChildren().add(copiedShape); 
            pasted = true; 
            return copiedShape; 
        }
        else{
            return null; 
        }
    }
    
    //Overload del metodo paste che prende in ingresso anche le coordinate dove incollare la forma 
    public Shape paste (double x, double y) {
        if (! this.isEmpty()) {
            if (pasted == true) { // if the shape has been already pasted once
                this.copiedShape = duplicate(copiedShape);  // it create a new shape to paste 
            }
            if (copiedShape instanceof NewShape) {  // moves the pasted shape to the desidered position 
                ((NewShape) copiedShape).move(x, y);
            }
            group.getChildren().add(copiedShape); 
            pasted = true; 
            return copiedShape; 
        }
        else{
            return null; 
        }
        
    }
    
    public Shape getCopiedShape() {
        return this.copiedShape;
    }
    
    
    public void cut(Shape shape) {
        if (shape != null) {
            this.copy(shape);
            group.getChildren().remove(shape);
        }
    }
}
