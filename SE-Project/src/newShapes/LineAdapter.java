/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 *
 * @author Domenico
 */
public class LineAdapter extends Line implements NewShape{
    private double lengthX;
    private double lengthY;

    public LineAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        this.lengthX=d-d2;
        this.lengthY=d1-d3;
    }

    public LineAdapter(double d, double d1, double d2, double d3, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }
    
    @Override
    public String toString() {
        return "Line;" + this.getStartX()+ ";" + this.getStartY() + ";" + this.getEndX()+ ";" + this.getEndY() + ";" + this.getStroke() + ";" + this.getStrokeWidth();
    }


    public static Line stringToLine(String string) {
        String[] values=string.split(";");
        return new LineAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Double.parseDouble(values[3]),
                Paint.valueOf(values[4]),
                Double.parseDouble(values[5]));
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

    @Override
    public void move(double x, double y) {
        this.setStartX(x);
        this.setStartY(y);
        this.setEndX(x+this.lengthX);
        this.setEndY(y+this.lengthY);    
    }

    @Override
    public void newResize(double x, double y) {
        this.setEndX(x);
        this.setEndY(y);
    }
    
    
    

        
}
