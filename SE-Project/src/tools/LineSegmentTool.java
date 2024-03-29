/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.shape.Shape;
import newShapes.LineAdapter;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * The LineSegmentTool allows you to create a new line
 */
public class LineSegmentTool extends Tool{
    /**
     * Returns a shape representing the line
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     * @return a shape representing the line
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        this.xEnd=x;
        this.yEnd=y;
        
        return new LineAdapter(this.xStart, this.yStart, this.xEnd, this.yEnd);
    }
}
