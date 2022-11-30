/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 *
 * @author gianl
 */
public class ChangeColorCommand implements Command{
    
    private Shape shape;
    private Paint oldStroke, oldFill; 
    private Paint newStroke, newFill; 

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
