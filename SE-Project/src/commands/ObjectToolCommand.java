/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;


import javafx.scene.shape.Shape;
import tools.ObjectTool;

/**
 * Class that allows you to do actions on a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/
public class ObjectToolCommand implements Command {
    private double oldX, oldY; 
    private double newX, newY;
    private ObjectTool tool; 
    private Shape shape; 

    /**
     * Creates a new instance of ObjectToolCommand
     * @param oldX represents the horizontal coordinate before the action
     * @param oldY represents the vertical coordinate before the action
     * @param newX represents the horizontal coordinate after the action
     * @param newY represents the vertical coordinate after the action
     * @param tool represents the ObjectTool object
     * @param shape represents the shape on which the action is performed
     */
    public ObjectToolCommand(double oldX, double oldY, double newX, double newY, ObjectTool tool, Shape shape) {
        this.oldX = oldX;
        this.oldY = oldY;
        this.newX = newX;
        this.newY = newY;
        this.tool = tool; 
        this.shape = shape;
    }
    
    @Override 
    public void execute() {
        tool.setShape(shape);
        tool.setEndPoint(newX, newY);
    }
    
    @Override 
    public void undo() {
        tool.setEndPoint(oldX, oldY);
    }
    
}
