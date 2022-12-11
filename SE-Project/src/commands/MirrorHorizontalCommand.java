/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import newShapes.NewShape;

/**
 *
 * @author assun
 */
public class MirrorHorizontalCommand implements Command{
    private NewShape shape; 

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
