/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import static java.lang.Math.abs;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Shape;
import newShapes.RectangleAdapter;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * The RectangleTool allows you to create a new rectangle
 */

public class RectangleTool extends ShapeTool{
    /**
     * Represents the height of the rectangle.
     */
    private double height;
    /**
     * Represents the width of the rectangle.
     */
    private double width;
    /**
     *  
     * @param x double which contains the x coordinate of the ending point.
     * @param y double which contains the y coordinate of the ending point.
     * @return a Shape.
     */
    @Override
    public Shape setEndPoint(double x, double y){
        
        this.xEnd=x;
        this.yEnd=y;
        this.width=abs(xStart-xEnd);
        this.height=abs(yStart-yEnd);
        if(xStart > xEnd) {
            double t=xStart;
            xStart=xEnd;
            xEnd=t;
        }
        if(yStart > yEnd) {
            double t=yStart;
            yStart=yEnd;
            yEnd=t;
        }
        RectangleAdapter r=new RectangleAdapter(this.xStart, this.yStart, this.width, this.height);
        
        
        return r;
    }

    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }



}
