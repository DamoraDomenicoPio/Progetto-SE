/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import utility.Clipboard;
import javafx.scene.shape.Shape;

/**
 * Class that allows you to paste a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class PasteCommand implements Command{
    private Group group; 
    private Clipboard clipboard;
    private Shape pastedShape;  

    /**
     * Creates a new instance of PasteCommand
     * @param group Object that contains the shapes
     * @param clipboard clipboard that allows you to make the copy
     */
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
