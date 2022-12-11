/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 * Class that allows you to cut a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class CutCommand implements Command {
    private Clipboard clipboard; 
    private Shape shape; // The shape that has to be cutted 

    /**
     * Creates a new instance of cutCommand
     * @param clipboard clipboard that allows you to make the cop
     * @param shape the shape to be cut
     */
    public CutCommand(Clipboard clipboard, Shape shape) {
        this.clipboard = clipboard;
        this.shape = shape; 
    }
    
    @Override 
    public void execute() {
        this.clipboard.cut(shape);
    }
    
    @Override 
    public void undo() {
        this.clipboard.paste();
    }
    
}
