/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import static java.lang.Math.abs;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Domenico
 */
public class RectangleTool {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;
    private double height;
    private double weight;
    
    public void setStartPoint(double x, double y){
        this.xStart=x;
        this.yStart=y;
    }
    
    public Rectangle setEndPoint(double x, double y){
        this.xEnd=x;
        this.yEnd=x;
        this.height=abs(xStart-xEnd);
        this.weight=abs(yStart-yEnd);
        return new Rectangle(xStart, yStart, height, weight);
    }

    public double getxStart() {
        return xStart;
    }

    public void setxStart(double xStart) {
        this.xStart = xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    public double getxEnd() {
        return xEnd;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
