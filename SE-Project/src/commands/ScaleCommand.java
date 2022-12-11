/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.shape.Shape;
import newShapes.ShapeAdapter;

/**
 * Class that allows you to scale a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/
public class ScaleCommand implements Command {
    private double scaleFactor; 
    private ShapeAdapter shape;

    /**
     * Creates a new instance of ScaleCommand
     * @param scaleFactor the scale factor
     * @param shape the shape to be scaled
     */
    public ScaleCommand(double scaleFactor, Shape shape) {
        this.scaleFactor = scaleFactor;
        this.shape = (ShapeAdapter) shape;
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
