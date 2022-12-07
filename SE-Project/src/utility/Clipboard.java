/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import newShapes.NewShape;
import tools.ShapeFactory;

/**
 *
 * @author assun
 */
public class Clipboard {
    private Group group; 
    private Shape copiedShape;
    private NewShape newShape; 

    public Clipboard(Group group) {
        this.group = group;
    }
    
    public boolean isEmpty() {
        return copiedShape == null;
    }
    
    public void copy(Shape shape) {
        this.copiedShape = duplicate(shape); 
        if (shape instanceof NewShape) {
            this.newShape = (NewShape) shape; 
        }
        else {
            throw new RuntimeException("The shape is not a newshape");
        }
    }
    
    private Shape duplicate(Shape shape) {
        String shapeString = shape.toString(); 
        return ShapeFactory.shapeCreate(shapeString);
    }
    
    public Shape paste() {
        if (! this.isEmpty()) { // If a shape has been selected
            group.getChildren().add(this.copiedShape);
            return this.copiedShape;
        }
        else{
            return null; 
        }
    }
    
    //Overload del metodo paste che prende in ingresso anche le coordinate dove incollare la forma 
    public Shape paste (double x, double y) {
        if (! this.isEmpty()){
            if (this.copiedShape instanceof NewShape) {
                ((NewShape) this.copiedShape).move(x, y);
            }
            group.getChildren().add(this.copiedShape);
            return this.copiedShape; 
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
