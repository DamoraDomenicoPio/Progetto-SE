/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Class that allows you to change the color of a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class ChangeColorCommand implements Command{
    
    private Shape shape;
    private Paint oldStroke, oldFill; 
    private Paint newStroke, newFill; 

    /**
     * Creates a new instance of ChangeColorCommand
     * @param shape the shape to perform the action on
     * @param newStroke the stroke color of the shape
     * @param newInterior the fill color of the shape
     */
    public ChangeColorCommand(Shape shape, Paint newStroke, Paint newInterior) {
        this.shape = shape;
        this.oldStroke = shape.getStroke();
        this.oldFill = shape.getFill(); 
        this.newStroke = newStroke; 
        this.newFill = newInterior; 
    }
    
    

    @Override
    public void execute() {
       shape.setStroke(newStroke);
       shape.setFill(newFill);
    }

    @Override
    public void undo() {
        shape.setStroke(oldStroke);
        shape.setFill(oldFill);
    }
    
}
