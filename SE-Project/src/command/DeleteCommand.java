/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.shape.Shape;

/**
 *
 * @author gianl
 */
public class DeleteCommand implements Command{
    
    private Shape shape;

    public DeleteCommand(Shape shape) {
        this.shape = shape;
    }
    
    @Override
    public void execute() {
       
    }

    @Override
    public void undo() {
        
    }
    
}
