/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import static java.lang.Math.ceil;
import javafx.scene.layout.GridPane;

/**
 *
 * @author assun
 */
public class GridManager {
    private GridPane grids[];
    private int currentGridIndex; 
    private boolean gridOn; 

    public GridManager(GridPane[] grids) {
        this.grids = grids;
        this.currentGridIndex = grids.length/2;
        this.gridOn = false; 
        
        for(int i=0; i<grids.length; i++) {
            grids[i].setOpacity(0.3);
        }
        
    }
    
    public void getBigger() {
        if(gridOn) {
            if (currentGridIndex < grids.length-1) {
                currentGridIndex++; 
                System.out.println("Smaller squares"+currentGridIndex);
                grids[currentGridIndex-1].setGridLinesVisible(false);
                grids[currentGridIndex].setGridLinesVisible(true); 
            }
        }
    }
    
    public void getSmaller() {
        if(gridOn) {
            if (currentGridIndex > 0) {
                currentGridIndex--;
                System.out.println("Bigger squares" + currentGridIndex);
                grids[currentGridIndex+1].setGridLinesVisible(false); 
                grids[currentGridIndex].setGridLinesVisible(true); 
            }
        }
    }
    
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
