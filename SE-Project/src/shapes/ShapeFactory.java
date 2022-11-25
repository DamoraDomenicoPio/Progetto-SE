/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import newShapes.*;


/**
 *
 * @author Domenico
 */

public class ShapeFactory {
    public static ShapeTool getShape(String shapeName){
        if(shapeName.equalsIgnoreCase("RECTANGLE")){
            return new RectangleTool();
        }
        else if(shapeName.equalsIgnoreCase("ELLIPSE")){
            return new EllipseTool();
        }
        else if(shapeName.equalsIgnoreCase("LINE")){
            return new LineSegmentTool();
        }
        else if(shapeName.equalsIgnoreCase("MOVE")){
            return new MoveTool(); 
        }
        else if(shapeName.equalsIgnoreCase("RESIZE")){
            System.out.println("Nuovo resize tool");
            return new ResizeTool(); 
        }
        return null;
    }
    
    public static Shape shapeCreate(String shapeString){
        String[] values=shapeString.split(";", 2);
        
        if(values[0].equalsIgnoreCase("RECTANGLE")){
            return RectangleAdapter.stringToRectangle(values[1]);
        }
        else if(values[0].equalsIgnoreCase("ELLIPSE")){
            return EllipseAdapter.stringToEllipse(values[1]);
        }
        else if(values[0].equalsIgnoreCase("LINE")){
            return LineAdapter.stringToLine(values[1]);
        }
        
        return null;
    }
}
