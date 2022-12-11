/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.transform.Scale;

/**
 *
 * @author assun
 */
public class ZoomInCommand implements Command {
    private Group group; 
    
    
    public ZoomInCommand(Group group) {
        this.group = group; 
    }
    
    @Override 
    public void execute() {
        Scale scale = new Scale(1.1, 1.1, 0, 0); 
        group.getTransforms().add(scale); 
    }
    
    @Override 
    public void undo() {
        Scale scale = new Scale(0.9, 0.9, 0, 0); 
        group.getTransforms().add(scale); 
    }
}
