/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.logging.Logger;
import newShapes.NewShape;

/**
 *
 * @author assun
 */


public class RotateCommand implements Command {
    private NewShape shape;  // Shape to be roated
    private double rotationAngle; 
    private double oldAngle;  

    public RotateCommand(NewShape shape, double rotationAngle) {
        this.shape = shape;
        this.rotationAngle = rotationAngle; 
    }
    
    
    @Override 
    public void execute() {
        this.oldAngle = shape.getRotationAngle();  // saves the old rotation angle of the shape
        shape.setRotationAngle(this.rotationAngle);  // Sets the new angle in the shape
    }
    
    @Override 
    public void undo() {   
        shape.setRotationAngle(oldAngle);   // restores the rotation angle value
    }
    
}
