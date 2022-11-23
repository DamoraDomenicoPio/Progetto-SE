/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;


/**
 *
 * @author Domenico
 */

public class ShapeFactory {
    public static ShapeTool getShape(String shapeName){
        if(shapeName.equalsIgnoreCase("RECTANGLE")) return new RectangleTool();
        if(shapeName.equalsIgnoreCase("ELLIPSE")) return new EllipseTool();
        if(shapeName.equalsIgnoreCase("LINE")) return new LineSegmentTool();
        return null;
    }
}
