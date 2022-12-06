/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.shape.Shape;
import newShapes.NewShape;

/**
 *
 * @author assun
 */
public class ScaleCommand implements Command {
    private double scaleFactor; 
    private NewShape shape;

    public ScaleCommand(double scaleFactor, Shape shape) {
        this.scaleFactor = scaleFactor;
        this.shape = (NewShape) shape;
    }

    @Override
    public void execute() {
        shape.newResize(scaleFactor); 
    }

    @Override
    public void undo() {
        shape.newResize(1/scaleFactor);
    }
    
}
