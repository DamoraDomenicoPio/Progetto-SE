/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Shape;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * Class representing the move action
 */

public class MoveTool extends ObjectTool{

    /**
     * Returns a shape with modified coordinates
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     * @return a shape with modified coordinates
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        if (this.shape != null) {
            this.shape.move(x, y);
        }
        return (Shape) this.shape;
    }
    
}