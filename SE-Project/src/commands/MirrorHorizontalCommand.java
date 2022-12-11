/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import newShapes.NewShape;

/**
 * Class that allows you to mirror a shape horizontally
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class MirrorHorizontalCommand implements Command{
    private NewShape shape; 

    /**
     * Creates a new instance of MirrorHorizontalCommand
     * @param shape the figure to be mirrored
     */
    public MirrorHorizontalCommand(NewShape shape) {
        this.shape = shape;
    }
    
    @Override 
    public void execute() {
        shape.mirrorHorizontal();
    }
    
    @Override 
    public void undo() {
        shape.mirrorHorizontal();
    }
}
