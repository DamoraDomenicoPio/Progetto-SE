/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import utility.GridManager;

/**
 Class that allows you to show/hide the grid
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class GridSwitchCommand implements Command {
    private GridManager gridManager; 

    /**
     * Creates a new instance of GridSwitchCommand
     * @param gridManager the GridManager object that manages the grid
     */
    public GridSwitchCommand(GridManager gridManager) {
        this.gridManager = gridManager;
    }
    
    
    @Override
    public void execute() {
        gridManager.gridSwitch();
    }
    
    @Override 
    public void undo() {
        gridManager.gridSwitch(); 
    }
    
}
