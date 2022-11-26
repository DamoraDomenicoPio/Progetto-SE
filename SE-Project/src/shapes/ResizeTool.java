/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Shape;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */

public class ResizeTool extends ObjectTool{
    /**
     * Returns a shape with the modified components
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     * @return a shape with the modified components
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        if (this.shape != null){
            super.shape.newResize(x, y);
        }
        return (Shape) super.shape; 
    }
    
}
