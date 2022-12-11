/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.shape.Shape;

/**
 * Class representing a tool that creates a shape
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */
public abstract class Tool{
    public double xStart;
    public double yStart;
    public double xEnd;
    public double yEnd;
    
    /**
     * 
     * @param x double which contains the x coordinate of the starting point
     * @param y double which contains the y coordinate of the starting point
     */
    public void setStartPoint(double x, double y){
        this.xStart=x;
        this.yStart=y;
    }
    
    /**
     * 
     * @param x double which contains the x coordinate of the end point
     * @param y double which contains the y coordinate of the end point
     * @return a Shape 
     */
    public abstract Shape setEndPoint(double x, double y);
    
    
    
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
    
    
    
}
