/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import utility.GridManager;

/**
 *
 * @author assun
 */
public class SmallerGridCommand implements Command{
    private GridManager gridManager; 

    public SmallerGridCommand(GridManager gridManager) {
        this.gridManager = gridManager;
    }
    
    @Override 
    public void execute() {
        gridManager.getSmaller();
    }
    
    @Override 
    public void undo() {
        gridManager.getBigger();
    }
}
