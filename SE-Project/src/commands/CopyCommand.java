/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 * Class that allows you to copy a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class CopyCommand implements Command{
    private Clipboard clipboard; 
    private Shape newCopied; 
    private Shape oldCopied; 

    /**
     * Creates a new instance of AddCommand
     * @param clipboard clipboard that allows you to make the copy
     * @param newCopied the shape to be copied
     */
    public CopyCommand(Clipboard clipboard, Shape newCopied) {
        this.clipboard = clipboard;
        this.newCopied = newCopied;
        this.oldCopied = clipboard.getCopiedShape();
    }

    
    
    @Override
    public void execute() {
        this.clipboard.copy(newCopied); 
    }

    @Override
    public void undo() {
        this.clipboard.copy(oldCopied);
    }
    
}
