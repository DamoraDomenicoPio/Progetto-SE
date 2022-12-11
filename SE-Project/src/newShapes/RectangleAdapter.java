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
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public class RectangleAdapter extends Rectangle implements ShapeAdapter{

    private double fixedPointX;
    private double fixedPointY;
    
    private double rotationAngle = 0; 
    
    
    /**
     * Creates a new instance of Rectangle with the given position and size.
     * @param d horizontal position of the rectangle.
     * @param d1 vertical position of the rectangle.
     * @param d2 width of the rectangle.
     * @param d3 height of the rectangle.
     */
    public RectangleAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        this.fixedPointX=d;
        this.fixedPointY=d1;
    }
    
    /**
     * Creates a new instance of Rectangle with the given position and size.
     * @param d horizontal position of the rectangle.
     * @param d1 vertical position of the rectangle.
     * @param d2 width of the rectangle.
     * @param d3 height of the rectangle.
     * @param fill the fill color of the rectangle.
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
        return "Rectangle;" + this.getX() + ";" + this.getY() + ";" + this.getWidth() + ";" + this.getHeight() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getStrokeWidth()+ ";" + this.getRotate();
    }

    /**
     * Return a Rectangle from a string.
     * @param string String representing the object.
     * @return a Rectangle Object.
     */
    public static Rectangle stringToRectangle(String string) {
        String[] values=string.split(";");
        RectangleAdapter r= new RectangleAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Double.parseDouble(values[3]),
                Paint.valueOf(values[4]),
                Paint.valueOf(values[5]),
                Double.parseDouble(values[6]));
        r.setRotate(Double.parseDouble(values[7]));
        return r;
    }

    /**
     * Method that allows you to move the rectangle.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void move(double x, double y) {
        this.setX(x);
        this.setY(y);
        
        this.fixedPointX=x;
        this.fixedPointY=y;
    }

    /**
     * Method that allows you to stretch the rectangle.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void stretch(double x, double y) {
        super.setHeight(abs(this.fixedPointY-y));
        super.setWidth(abs(this.fixedPointX-x));
        if(this.fixedPointX<x){
            x=this.fixedPointX;
        }
        
        if(this.fixedPointY<y){
            y=this.fixedPointY;
        }
        
        super.setX(x);
        super.setY(y);
        
    }

    /**
     * Method that allows you to resize the rectangle.
     * @param r resize factor.
     */
    @Override
    public void newResize(double r) {
        this.setHeight(this.getHeight()*r);
        this.setWidth(this.getWidth()*r);
        
    }
    
    /**
     * Method that allows you to rotate the rectangle.
     * @param r angle in degrees.
     */
    @Override
    public void rotate(double r) {
        this.setRotate(r);
        
    }
    
    @Override
    public double getRotationAngle() {
        return this.rotationAngle; 
    }
    
    
    
    @Override
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle; 
        this.rotate(rotationAngle); 
    }
    
    /**
     * method that allows you to mirror vertically
     */
    @Override
    public void mirrorVertical(){
        this.setRotationAngle(-this.getRotate());
    }
    
    /**
     * method that allows you to mirror horizontally
     */
    @Override
    public void mirrorHorizontal(){
        this.setRotationAngle(180-this.getRotate());
    }
    
    /**
     * method that moves the pasted shape by one offset
     * @param r the offset
     */
    @Override
    public void moveOffset(double r) {
        this.move(this.getX()+r, this.getY()+r);
    }
}
