/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Domenico
 */
public class EllipseAdapter extends Ellipse{

    public EllipseAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        
        this.setOnMouseDragged(event->{
            if(event.isSecondaryButtonDown()){
                this.setCenterX(event.getX());
                this.setCenterY(event.getY());
            }
            
        });
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
    
}
