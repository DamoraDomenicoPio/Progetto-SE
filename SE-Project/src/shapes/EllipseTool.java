/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import static java.lang.Math.abs;
import javafx.scene.shape.Shape;
import newShapes.EllipseAdapter;


/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * The EllipseTool allows you to create a new ellipse
 */
public class EllipseTool extends ShapeTool{
    private double radiusX;
    private double radiusY;
    
    
    @Override
    /**
     * Creates a new instance of EllipseAdapter.
     */
    
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
