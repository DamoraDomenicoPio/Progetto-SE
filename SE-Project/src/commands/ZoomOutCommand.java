/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.transform.Scale;

/**
 * Class that allows you to zoom out on the sheet.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/
public class ZoomOutCommand implements Command {
    private Group group; 
    
    /**
     * Creates a new instance of ZoomOutCommand
     * @param group Object that contains the shapes
     */
    public ZoomOutCommand(Group group) {
        this.group = group; 
    }
    
    @Override 
    public void execute() {
        Scale scale = new Scale(0.9, 0.9, 0, 0); 
        group.getTransforms().add(scale); 
    }
    
    @Override 
    public void undo() {
        Scale scale = new Scale(1.1, 1.1, 0, 0); 
        group.getTransforms().add(scale); 
    }
}
