/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author assun
 */
public class Grid {
    private GridPane grids[]; 
    private Pane parent; 
    private static int N_GRIDS = 5; // Number of grids
    private int currentGrid = 2; 
    
    
    public Grid(Pane parent) {
        grids[0] = createGrid(10, 6, new GridPane()); 
//        grids[1] = createGrid(12, 7); 
//        grids[2] = createGrid(14, 8); 
//        grids[3] = createGrid(15, 9); 
//        grids[4] = createGrid(17, 10); 
        this.parent = parent; 
        
        grids[currentGrid].setGridLinesVisible(true); 
        
        parent.getChildren().add(grids[0]); 
        parent.getChildren().add(grids[1]); 
        parent.getChildren().add(grids[2]); 
        parent.getChildren().add(grids[3]); 
        parent.getChildren().add(grids[4]); 
    }
    
    public void getBigger(){
        if (currentGrid < N_GRIDS-1) {
            currentGrid++; 
            System.out.println("Smaller squares"+currentGrid);
            grids[currentGrid-1].setGridLinesVisible(false); 
            grids[currentGrid].setGridLinesVisible(true); 
        }
    }
    
    public void getSmaller() {
        if (currentGrid > 0) {
            currentGrid--;
            System.out.println("Bigger squares" + currentGrid);
            grids[currentGrid+1].setGridLinesVisible(false); 
            grids[currentGrid].setGridLinesVisible(true); 
        }
    }
    
    
    private GridPane createGrid(int nCols, int nRows, GridPane newGrid) {
        System.out.println("Creando una nuova griglia...");
        
        //GridPane newGrid = new GridPane(); 
        System.out.println("Nuova griglia creata"+newGrid.getClass());
        for(int i=0; i<nCols; i++) {
            ColumnConstraints column = new ColumnConstraints(); 
            column.setPercentWidth(100/nCols);
            newGrid.getColumnConstraints().add(column);
        }
        System.out.println("colonne ok");
        for(int i=0; i<nRows; i++) {
            System.out.println("Nuova riga");
            RowConstraints row = new RowConstraints(); 
            row.setPercentHeight(100/nRows);
            newGrid.getRowConstraints().add(row);
        }
        System.out.println("righe ok");
        System.out.println("Nuova griglia creata"+newGrid.getClass());
        newGrid.setOpacity(0.3);
        return newGrid; 
    }
    
    
}
