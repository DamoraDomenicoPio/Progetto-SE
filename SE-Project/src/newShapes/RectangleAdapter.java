/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Domenico
 */
public class RectangleAdapter extends Rectangle {

    
    
    public RectangleAdapter(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
        
        this.setOnMouseDragged(event->{
            if(event.isSecondaryButtonDown()){
                this.setX(event.getX());
                this.setY(event.getY());
            }
        });
    }
    
    public RectangleAdapter(double d, double d1, double d2, double d3, Paint fill, Paint stroke, double strokeWidth) {
        this(d, d1, d2, d3);
        this.setFill(fill);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }

    @Override
    public String toString() {
        return "Rectangle;" + this.getX() + ";" + this.getY() + ";" + this.getWidth() + ";" + this.getHeight() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getStrokeWidth();
    }

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

}
