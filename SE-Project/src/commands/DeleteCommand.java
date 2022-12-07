/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

/**
 *
 * @author assun
 */
public class DeleteCommand implements Command{
    
    private Shape shape;
    private Group group; 

    public DeleteCommand(Group group, Shape shape) {
        this.group = group; 
        this.shape = shape;
    }
    
    @Override
    public void execute() {
       if(shape != null){
            group.getChildren().remove(shape);
        }
    }

    @Override
    public void undo() {
        System.out.println("undo delete command");
        this.group.getChildren().add(shape);
    }
    
}
