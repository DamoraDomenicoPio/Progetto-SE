/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import newShapes.ShapeAdapter;

/**
 * Class that allows you to mirror a shape vertically
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class MirrorVerticalCommand implements Command {
    private ShapeAdapter shape; 
    
    /**
     * Creates a new instance of MirrorVerticalCommand
     * @param shape the figure to be mirrored
     */
    public MirrorVerticalCommand(ShapeAdapter shape) {
        this.shape = shape; 
    }
    
    @Override 
    public void execute() {
        shape.mirrorVertical();
    }
    
    @Override
    public void undo() {
        this.shape.mirrorVertical();
    }
    
}
