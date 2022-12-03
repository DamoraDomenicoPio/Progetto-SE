/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import tools.ShapeFactory;

/**
 *
 * @author assun
 */
public class Clipboard {
    private Group group; 
    private Shape copiedShape;

    public Clipboard(Group group) {
        this.group = group;
    }
    
    public boolean isEmpty() {
        return copiedShape == null;
    }
    
    public void copy(Shape shape) {
        this.copiedShape = duplicate(shape); 
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
    
    public Shape getCopiedShape() {
        return this.copiedShape;
    }
    
    
    public void cut(Shape shape) {
        System.out.println("Cutting shape...");
        if (shape != null) {
            this.copy(shape);
            group.getChildren().remove(shape);
        }
    }
}
