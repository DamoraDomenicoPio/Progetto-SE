/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 *
 * @author assun
 */
public class PasteInPositionCommand implements Command{
    private Group group; 
    private Clipboard clipboard;
    private Shape pastedShape;  
    private double x, y; // coordinates where paste the shape
    
    public PasteInPositionCommand(Group group, Clipboard clipboard, double x, double y) {
        this.clipboard = clipboard; 
        this.group = group; 
        this.x = x; 
        this.y = y; 
    }
    
    @Override
    public void execute() {
        this.pastedShape = this.clipboard.paste(x, y);
    }
    
    @Override 
    public void undo() {
        group.getChildren().remove(this.pastedShape);
    }
    
}
