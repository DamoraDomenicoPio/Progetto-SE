/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

/**
 * Class that allows you to go front a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class GoFrontCommand implements Command {
    
    private Group group; 
    private Shape shape; 
    private int index;   // Z-order of the shape 

    /**
     * Creates a new instance of GoFrontCommand
     * @param group Object that contains the shapes
     * @param shape Represents the shape that should go to the front
     */
    public GoFrontCommand(Group group, Shape shape) {
        this.group = group;
        this.shape = shape;
        this.index = group.getChildren().indexOf(shape);  
    }
    
    @Override 
    public void execute(){
        shape.toFront();
    }
    
    @Override
    public void undo() {
        group.getChildren().remove(shape);  // removes  the shape
        group.getChildren().add(index, shape);  // Inserts the shape into the previously saved position
    }
}
