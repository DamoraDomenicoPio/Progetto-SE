/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import newShapes.NewShape;

/**
 * Class that allows you to rotate a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/
public class RotateCommand implements Command {
    private NewShape shape;  // Shape to be roated
    private double rotationAngle; 
    private double oldAngle;  

    /**
     * Creates a new instance of RotateCommand
     * @param shape the figure that needs to be rotated
     * @param rotationAngle the angle of rotation
     */
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
