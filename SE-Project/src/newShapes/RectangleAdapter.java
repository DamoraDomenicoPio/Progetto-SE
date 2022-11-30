/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import static java.lang.Math.abs;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * The RectangleAdapter class creates and manages a rectangle.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */
public class RectangleAdapter extends Rectangle implements NewShape{

    private double resizeX;
    private double resizeY;
    
    /**
     * Creates a new instance of Rectangle with the given position and size.
     * @param d horizontal position of the rectangle
     * @param d1 vertical position of the rectangle
     * @param d2 width of the rectangle
     * @param d3 height of the rectangle
     */
    public RectangleAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        this.resizeX=d;
        this.resizeY=d1;
    }
    
    /**
     * Creates a new instance of Rectangle with the given position and size.
     * @param d horizontal position of the rectangle
     * @param d1 vertical position of the rectangle
     * @param d2 width of the rectangle
     * @param d3 height of the rectangle
     * @param fill the fill color of the rectangle
     * @param stroke the stroke color of the rectangle.
     * @param strokeWidth the width of the stroke of the rectangle.
     */
    public RectangleAdapter(double d, double d1, double d2, double d3, Paint fill, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setFill(fill);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }

    /**
     * Returns a string representation of this {@code RectangleAdapter} object.
     * @return a string representation of this {@code RectangleAdapter} object.
     */
    @Override
    public String toString() {
        return "Rectangle;" + this.getX() + ";" + this.getY() + ";" + this.getWidth() + ";" + this.getHeight() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getStrokeWidth();
    }

    /**
     * Return a Rectangle from a string.
     * @param string String representing the object.
     * @return a Rectangle Object
     */
    public static Rectangle stringToRectangle(String string) {
        String[] values=string.split(";");
        return new RectangleAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Double.parseDouble(values[3]),
                Paint.valueOf(values[4]),
                Paint.valueOf(values[5]),
                Double.parseDouble(values[6]));
    }

    /**
     * Method that allows you to move the rectangle
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    @Override
    public void move(double x, double y) {
        System.out.println("Move rettangle");
        this.setX(x);
        this.setY(y);
        this.resizeX=x;
        this.resizeY=y;
    }

    /**
     * Method that allows you to resize the rectangle
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    
    
    
    
    @Override
    public void stretch(double x, double y) {
        System.out.println("RESIZE RETTANGLE");
        super.setHeight(abs(resizeY-y));
        super.setWidth(abs(resizeX-x));
        
        if(resizeX<x){
            x=resizeX;
        }
        
        if(resizeY<y){
            y=resizeY;
        }
        
        super.setX(x);
        super.setY(y);
        
    }
    
    

}
