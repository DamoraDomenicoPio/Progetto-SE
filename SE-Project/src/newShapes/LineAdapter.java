/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 * The LineAdapter class creates and manages a line.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public class LineAdapter extends Line implements NewShape{
    /**
     * projection of the line on the horizontal axis.
     */
    private double lengthX;
    /**
     * projection of the line on the vertical axis.
     */
    private double lengthY;
    
    private double rotationAngle = 0; 

    /**
     * Creates a new instance of LineAdapter.
     * @param d the horizontal coordinate of the start point of the line segment.
     * @param d1 the vertical coordinate of the start point of the line segment.
     * @param d2 the horizontal coordinate of the end point of the line segment.
     * @param d3 the vertical coordinate of the end point of the line segment.
     */
    public LineAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        this.lengthX=d2-d;
        this.lengthY=d3-d1;
    }

    /**
     * Creates a new instance of LineAdapter.
     * @param d the horizontal coordinate of the start point of the line segment.
     * @param d1 the vertical coordinate of the start point of the line segment.
     * @param d2 the horizontal coordinate of the end point of the line segment.
     * @param d3 the vertical coordinate of the end point of the line segment.
     * @param stroke the stroke color of the line.
     * @param strokeWidth the width of the stroke of the line.
     */
    public LineAdapter(double d, double d1, double d2, double d3, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }
    
    /**
     * Returns a string representation of this {@code LineAdapter} object.
     * @return a string representation of this {@code LineAdapter} object.
     */
    @Override
    public String toString() {
        return "Line;" + this.getStartX()+ ";" + this.getStartY() + ";" + this.getEndX()+ ";" + this.getEndY() + ";" + this.getStroke() + ";" + this.getStrokeWidth() + ";" + this.getRotate();
    }

    /**
     * Return a Line from a string.
     * @param string String representing the object.
     * @return a Line Object.
     */
    public static Line stringToLine(String string) {
        String[] values=string.split(";");
        LineAdapter l= new LineAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Double.parseDouble(values[3]),
                Paint.valueOf(values[4]),
                Double.parseDouble(values[5]));
        l.setRotate(Double.parseDouble(values[6]));
        return l;
    }

    public double getLengthX() {
        return lengthX;
    }

    public void setLengthX(double lengthX) {
        this.lengthX = lengthX;
    }

    public double getLengthY() {
        return lengthY;
    }

    public void setLengthY(double lengthY) {
        this.lengthY = lengthY;
    }

    /**
     * Method that allows you to move the line.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void move(double x, double y) {
        this.setStartX(x);
        this.setStartY(y);
        this.setEndX(x+this.lengthX);
        this.setEndY(y+this.lengthY);    
    }

    
    
    
    /**
     * Method that allows you to stretch the line.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void stretch(double x, double y) {
        this.setEndX(x);
        this.setEndY(y);
        this.lengthX=x-this.getStartX();
        this.lengthY=y-this.getStartY();
    }

    /**
     * Method that allows you to resize the line.
     * @param r resize factor.
     */
    @Override
    public void newResize(double r) {
        this.lengthX=this.lengthX*r;
        this.lengthY=this.lengthY*r;
        this.setEndX(this.getStartX()+this.lengthX);
        this.setEndY(this.getStartY()+this.lengthY);
    }

    /**
     * Method that allows you to rotate the line.
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
        double xEndPoint=this.getEndX();
        this.setEndX(this.getStartX());
        this.setStartX(xEndPoint);
        this.setRotationAngle(-this.rotationAngle);
    }
    
    /**
     * method that allows you to mirror horizontally
     */
    @Override
    public void mirrorHorizontal(){
         double yEndPoint=this.getEndY();
        this.setEndY(this.getStartY());
        this.setStartY(yEndPoint);
        this.setRotationAngle(360-this.rotationAngle);
    }
    
    /**
     * method that moves the pasted shape by one offset
     * @param r the offset
     */
    @Override
    public void moveOffset(double r) {
        this.move(this.getStartX()+r, this.getStartY()+r);
    }
}
