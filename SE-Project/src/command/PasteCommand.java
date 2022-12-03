/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.Group;
import utility.Clipboard;
import javafx.scene.shape.Shape;

/**
 *
 * @author assun
 */
public class PasteCommand implements Command{
    private Group group; 
    private Clipboard clipboard;
    private Shape pastedShape;  
    
    public PasteCommand(Group group, Clipboard clipboard) {
        this.clipboard = clipboard; 
        this.group = group; 
    }
    
    @Override
    public void execute() {
        this.pastedShape = this.clipboard.paste();
    }
    
    @Override 
    public void undo() {
        group.getChildren().remove(this.pastedShape);
    }
    
}
