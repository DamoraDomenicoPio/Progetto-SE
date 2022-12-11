/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 * Class that allows you to paste a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
*/
public class PasteInPositionCommand implements Command{
    private Group group; 
    private Clipboard clipboard;
    private Shape pastedShape;  
    private double x, y; // coordinates where paste the shape
    
    /**
     * Creates a new instance of PasteCommand
     * @param group Object that contains the shapes
     * @param clipboard clipboard that allows you to make the copy
     * @param x horizontal coordinate to copy to
     * @param y vertical coordinate to copy to
     */
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
