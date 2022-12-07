/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;
import tools.*; 

/**
 *
 * @author assun
 */
public class ToolBox {
    private LineSegmentTool lineSegmentTool; 
    private EllipseTool ellipseTool; 
    private RectangleTool rectangleTool; 
    private MoveTool moveTool; 
    private StretchTool stretchTool; 
    
    private double scaleFactor;
    
    public ToolBox(double scaleFactor){
        this.scaleFactor = scaleFactor; 
        
        this.lineSegmentTool = new LineSegmentTool(); 
        this.ellipseTool = new EllipseTool(); 
        this.rectangleTool = new RectangleTool(scaleFactor);
        this.moveTool = new MoveTool(); 
        this.stretchTool = new StretchTool(); 
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        // this.rectangleTool.setScaleFactor; 
    }
    
    public Tool getShapeTool(String tool) {
        if(tool.equalsIgnoreCase("RECTANGLE")){
            return this.rectangleTool;
        }
        else if(tool.equalsIgnoreCase("ELLIPSE")){
            return this.ellipseTool;
        }
        else if(tool.equalsIgnoreCase("LINE")){
            return this.lineSegmentTool;
        }
        return null;
    }
    
    public ObjectTool getObjectTool(String tool) {
        if(tool.equalsIgnoreCase("MOVE")){
            return this.moveTool; 
        }
        else if(tool.equalsIgnoreCase("STRETCH")){   //  || actionName.equalsIgnoreCase("ADD")) { 
            return new StretchTool(); 
        }
        return null;
    }
    

    public LineSegmentTool getLineSegmentTool() {
        return lineSegmentTool;
    }

    public EllipseTool getEllipseTool() {
        return ellipseTool;
    }

    public RectangleTool getRectangleTool() {
        return rectangleTool;
    }

    public MoveTool getMoveTool() {
        return moveTool;
    }

    public StretchTool getStretchTool() {
        return stretchTool;
    }
    
    
    
}
