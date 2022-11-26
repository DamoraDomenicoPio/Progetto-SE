/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import newShapes.LineAdapter;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * The LineSegmentTool allows you to create a new line
 */
public class LineSegmentTool extends ShapeTool{
    /**
     * 
     * @param x
     * @param y
     * @return a new instance of LineAdapter.
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        this.xEnd=x;
        this.yEnd=y;
        return new LineAdapter(this.xStart, this.yStart, this.xEnd, this.yEnd);
    }
}
