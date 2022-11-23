/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;


/**
 *
 * @author Domenico
 */

public class ShapeFactory {
    public static ShapeTool getShape(String shapeName){
        if(shapeName.equalsIgnoreCase("RECTANGLE")) return new RectangleTool();
        else if(shapeName.equalsIgnoreCase("ELLIPSE")) return new EllipseTool();
        else if(shapeName.equalsIgnoreCase("LINE")) return new LineSegmentTool();
        return null;
    }
    
    public static Shape shapeCreate(String shapeString){
        String nameShape=shapeString.split(";")[0];
        String values=shapeString.split(";")[1];
        values=values.replace("fill=", "").replace("stroke=", "").replace("strokeWidth=", "");
        if(nameShape.equalsIgnoreCase("RECTANGLE")){
            values=values.replace("x=", "").replace("y=", "").replace("width=", "").replace("height=", "");
            String[] valuesRectangle=values.split(", ");
            Rectangle r= new Rectangle(Double.parseDouble(valuesRectangle[0]),Double.parseDouble(valuesRectangle[1]),Double.parseDouble(valuesRectangle[2]),Double.parseDouble(valuesRectangle[3]));
            r.setFill(Paint.valueOf(valuesRectangle[4]));
            r.setStroke(Paint.valueOf(valuesRectangle[5]));
            r.setStrokeWidth(Double.parseDouble(valuesRectangle[6]));
            return r;
        }
        else if(nameShape.equalsIgnoreCase("ELLIPSE")){
            values=values.replace("centerX=", "").replace("centerY=", "").replace("radiusX=", "").replace("radiusY=", "");
            String[] valuesEllipse=values.split(", ");
            Ellipse e= new Ellipse(Double.parseDouble(valuesEllipse[0]),Double.parseDouble(valuesEllipse[1]),Double.parseDouble(valuesEllipse[2]),Double.parseDouble(valuesEllipse[3]));
            e.setFill(Paint.valueOf(valuesEllipse[4]));
            e.setStroke(Paint.valueOf(valuesEllipse[5]));
            e.setStrokeWidth(Double.parseDouble(valuesEllipse[6]));
            return e;
        }
        else if(nameShape.equalsIgnoreCase("LINE")){
            values=values.replace("startX=", "").replace("startY=", "").replace("endX=", "").replace("endY=", "");
            String[] valuesLine=values.split(", ");
            Line l= new Line(Double.parseDouble(valuesLine[0]),Double.parseDouble(valuesLine[1]),Double.parseDouble(valuesLine[2]),Double.parseDouble(valuesLine[3]));
            l.setStroke(Paint.valueOf(valuesLine[4]));
            l.setStrokeWidth(Double.parseDouble(valuesLine[5]));
            return l;
        }
        return null;
    }
}
