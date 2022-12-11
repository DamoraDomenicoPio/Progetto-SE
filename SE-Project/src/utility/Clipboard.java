/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import newShapes.NewShape;

/**
 * The Clipboard allows you to copy and paste a shape
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */
public class Clipboard {
    private Group group; 
    private Shape copiedShape;  // String that repredents the copied shape in the moment it gets copied 
    private boolean pasted;  // true if the copied shape has already been pasted 

    /**
     * Creates a new instance of Clipboard
     * @param group Object that contains the shapes
     */
    public Clipboard(Group group) {
        this.group = group;
    }
    
    /**
     * Method that returns true if a shape was copied previously, otherwise false
     * @return true if a shape was copied previously, otherwise false
     */
    public boolean isEmpty() {
        return copiedShape == null;
    }
    
    /**
     * Method that allows you to copy a shape
     * @param shape the copied shape
     */
    public void copy(Shape shape) {
        this.copiedShape = duplicate(shape);
        this.pasted = false; 
    }
    
    /**
     * Method that allows you to duplicate a shape
     * @param shape the duplicated shape
     */
    private Shape duplicate(Shape shape) {
        String shapeString = shape.toString(); 
        return NewShape.stringToShape(shapeString);
    }
    
    /**
     * Method that allows you to paste a shape
     * @return the copied shape
     */
    public Shape paste() {
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
    
    /**
     * Method that allows you to paste a shape
     * @param x horizontal coordinate in which to copy the shape
     * @param y vertical coordinate in which to copy the shape
     * @return the copied shape
     */
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
    
    /**
     * Method that returns the copied figure
     * @return the copied figure
     */
    public Shape getCopiedShape() {
        return this.copiedShape;
    }
    
    /**
     * Method that allows you to cut a shape
     * @param shape the cutted shape 
     */
    public void cut(Shape shape) {
        if (shape != null) {
            this.copy(shape);
            group.getChildren().remove(shape);
        }
    }
}
