/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 *
 * @author assun
 */
public class CutCommand implements Command {
    private Clipboard clipboard; 
    private Shape shape; // The shape that has to be cutted 

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
