/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 *
 * @author Domenico
 */
public class LineSegmentTool extends ShapeTool{

    @Override
    public Shape setEndPoint(double x, double y) {
        this.xEnd=x;
        this.yEnd=y;
        return new Line(this.xStart, this.yStart, this.xEnd, this.yEnd);
    }
    
}
