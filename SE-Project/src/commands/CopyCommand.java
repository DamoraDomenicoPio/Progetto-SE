/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import utility.Clipboard;

/**
 *
 * @author assun
 */
public class CopyCommand implements Command{
    private Clipboard clipboard; 
    private Shape newCopied; 
    private Shape oldCopied; 

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
