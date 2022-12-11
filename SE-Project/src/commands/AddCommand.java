/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Class that allows you to change the color of a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class AddCommand implements Command{
    
    private Group group;
    private Paint borderColor, insideColor; 
    private Shape newShape; 

    /**
     * Creates a new instance of AddCommand
     * @param group Object that contains the shapes
     * @param borderColor the stroke color of the shape
     * @param insideColor the fill color of the shape
     * @param newShape the new shape that needs to be added
     */
    public AddCommand(Group group, Paint borderColor, Paint insideColor, Shape newShape) {
        this.group = group;
        this.borderColor = borderColor;
        this.insideColor = insideColor;
        this.newShape = newShape;
    }

    
    
    @Override
    public void execute() {
        this.newShape.getStrokeDashArray().add(0d);  // Replaces the dotted line with a continuous 
        this.newShape.setStroke(this.borderColor);
        this.newShape.setFill(this.insideColor);
    }

    @Override
    public void undo() {
        this.group.getChildren().remove(this.newShape);  // Deletes the added shape 
    }
    
}
