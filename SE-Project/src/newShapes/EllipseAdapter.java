/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import static java.lang.Math.abs;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Domenico
 */
public class EllipseAdapter extends Ellipse implements NewShape{

    public EllipseAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
    }

    public EllipseAdapter(double d, double d1, double d2, double d3, Paint fill, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setFill(fill);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }
    @Override
    public String toString() {
        return "Ellipse;" + this.getCenterX()+ ";" + this.getCenterY() + ";" + this.getRadiusX() + ";" + this.getRadiusY() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getStrokeWidth();
    }

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

    @Override
    public void move(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);    
    }

    @Override
    public void newResize(double x, double y) {
        double centerX = super.getCenterX(); 
        double centerY = getCenterY(); 
        
        super.setRadiusX(abs(centerX-x));
        super.setRadiusY(abs(centerY-y));
    }    
    
    
    
}
