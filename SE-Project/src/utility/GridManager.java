/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.layout.GridPane;

/**
 * Class that allows you to manage a grid
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class GridManager {
    private GridPane grids[];
    private int currentGridIndex; 
    private boolean gridOn; 

    /**
     * Creates a new instance of GridManager
     * @param grids the grid array
     */
    public GridManager(GridPane[] grids) {
        this.grids = grids;
        this.currentGridIndex = grids.length/2;
        this.gridOn = false; 
        
        for(int i=0; i<grids.length; i++) {
            grids[i].setOpacity(0.3);
        }
        
    }
    
    /**
     * Method that makes the grid larger
     */
    public void getBigger() {
        if(gridOn) {
            if (currentGridIndex < grids.length-1) {
                currentGridIndex++;
                grids[currentGridIndex-1].setGridLinesVisible(false);
                grids[currentGridIndex].setGridLinesVisible(true); 
            }
        }
    }
    
    /**
     * Method that makes the grid smaller
     */
    public void getSmaller() {
        if(gridOn) {
            if (currentGridIndex > 0) {
                currentGridIndex--;
                grids[currentGridIndex+1].setGridLinesVisible(false); 
                grids[currentGridIndex].setGridLinesVisible(true); 
            }
        }
    }
    
    /**
     * Method that allows you to show/hide the grid
     */
    public void gridSwitch() {
        if(gridOn == true){
            gridOn = false; 
            grids[currentGridIndex].setGridLinesVisible(false);
        }
        else {
            gridOn = true; 
            grids[currentGridIndex].setGridLinesVisible(true);
        }
        
    }
    
}
