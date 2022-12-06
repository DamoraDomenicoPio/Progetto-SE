/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;


import javafx.scene.shape.Shape;
import tools.ObjectTool;

/**
 *
 * @author assun
 */
public class ObjectToolCommand implements Command {
    private double oldX, oldY; 
    private double newX, newY;
    private ObjectTool tool; 
    private Shape shape; 

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
