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
public class MirrorVerticalCommand implements Command {
    private NewShape shape; 
    
    public MirrorVerticalCommand(NewShape shape) {
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
