/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

/**
 * Class that allows you to delete a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class DeleteCommand implements Command{
    
    private Shape shape;
    private Group group; 

    /**
     * Creates a new instance of DeleteCommand
     * @param group Object that contains the shapes
     * @param shape the shape to be deleted
     */
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
        this.group.getChildren().add(shape);
    }
    
}
