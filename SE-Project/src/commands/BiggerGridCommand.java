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
public class BiggerGridCommand implements Command {
    private GridManager gridManager; 

    public BiggerGridCommand(GridManager gridManager) {
        this.gridManager = gridManager;
    }
    
    @Override 
    public void execute() {
        gridManager.getBigger();
    }
    
    @Override 
    public void undo() {
        gridManager.getSmaller();
    }
    
}
