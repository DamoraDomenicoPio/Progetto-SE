/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import newShapes.*;


/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * Implementation of the pattern factory method for the creation of the shapes
 */
public class ShapeFactory {
    /**
     * 
     * @param shapeName string containing the shape to create 
     * @return a shape given a string
     */
    public static Tool getShape(String shapeName, double resizeFactor){
        if(shapeName.equalsIgnoreCase("RECTANGLE")){
            return new RectangleTool(resizeFactor);
        }
        else if(shapeName.equalsIgnoreCase("ELLIPSE")){
            return new EllipseTool();
        }
        else if(shapeName.equalsIgnoreCase("LINE")){
            return new LineSegmentTool();
        }
        return null;
    }
    
    public static ObjectTool getAction(String actionName){
        if(actionName.equalsIgnoreCase("MOVE")){
            return new MoveTool(); 
        }
        else if(actionName.equalsIgnoreCase("STRETCH")|| actionName.equalsIgnoreCase("ADD")){
            return new StretchTool(); 
        }
        return null;
    }
    /**
     * 
     * @param shapeString string containing the shape to create
     * @return a shape given a string
     */
    
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
