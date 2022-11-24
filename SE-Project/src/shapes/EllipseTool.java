/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import static java.lang.Math.abs;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import newShapes.EllipseAdapter;

/**
 *
 * @author Domenico
 */
public class EllipseTool extends ShapeTool{
    private double radiusX;
    private double radiusY;
    
    
    @Override
    public Shape setEndPoint(double x, double y){
        
        this.xEnd=x;
        this.yEnd=y;
        this.radiusX=abs(xStart-xEnd);
        this.radiusY=abs(yStart-yEnd);
        return new EllipseAdapter(this.xStart, this.yStart, this.radiusX, this.radiusY);
    }

    public double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }


    
}
