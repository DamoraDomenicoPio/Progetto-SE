/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import static java.lang.Math.abs;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

/**
 * The EllipseAdapter class creates and manages an ellipse.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */
public class EllipseAdapter extends Ellipse implements NewShape{

    /**
     * Creates an instance of Ellipse of the given position and size.
     * @param d the horizontal position of the center of the ellipse in pixels
     * @param d1 the vertical position of the center of the ellipse in pixels
     * @param d2 the horizontal radius of the ellipse in pixels
     * @param d3 the vertical radius of the ellipse in pixels
     */
    public EllipseAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
    }

    /**
     * Creates an instance of Ellipse of the given position and size.
     * @param d the horizontal position of the center of the ellipse in pixels
     * @param d1 the vertical position of the center of the ellipse in pixels
     * @param d2 the horizontal radius of the ellipse in pixels
     * @param d3 the vertical radius of the ellipse in pixels
     * @param fill the fill color of the ellipse
     * @param stroke the stroke color of the ellipse.
     * @param strokeWidth the width of the stroke of the ellipse.
     */
    public EllipseAdapter(double d, double d1, double d2, double d3, Paint fill, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setFill(fill);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }
    
    /**
     * Returns a string representation of this {@code EllipseAdapter} object.
     * @return a string representation of this {@code EllipseAdapter} object.
     */
    @Override
    public String toString() {
        return "Ellipse;" + this.getCenterX()+ ";" + this.getCenterY() + ";" + this.getRadiusX() + ";" + this.getRadiusY() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getStrokeWidth();
    }

    /**
     * Return a Ellipse from a string.
     * @param string String representing the object.
     * @return a Ellipse Object
     */
    public static Ellipse stringToEllipse(String string) {
        String[] values=string.split(";");
        return new EllipseAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Double.parseDouble(values[3]),
                Paint.valueOf(values[4]),
                Paint.valueOf(values[5]),
                Double.parseDouble(values[6]));
    }

    /**
     * Method that allows you to move the ellipse
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    @Override
    public void move(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);    
    }

    /**
     * Method that allows you to resize the ellipse
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    @Override
    public void newResize(double x, double y) {
        double centerX = super.getCenterX(); 
        double centerY = getCenterY(); 
        
        super.setRadiusX(abs(centerX-x));
        super.setRadiusY(abs(centerY-y));
    }    
    
    
    
}
