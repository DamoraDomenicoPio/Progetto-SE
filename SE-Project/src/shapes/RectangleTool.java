/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import static java.lang.Math.abs;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Domenico
 */
public class RectangleTool extends ShapeTool{
    
    private double height;
    private double width;
    
    
    
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
        return new Rectangle(this.xStart, this.yStart, this.width, this.height);
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
