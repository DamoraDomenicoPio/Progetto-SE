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
    private TextTool textTool;
    
    private double scaleFactor;
    private String text;
    
    public ToolBox(){
        
        this.lineSegmentTool = new LineSegmentTool(); 
        this.ellipseTool = new EllipseTool(); 
        this.rectangleTool = new RectangleTool();
        this.moveTool = new MoveTool(); 
        this.stretchTool = new StretchTool();
        this.textTool = new TextTool();
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
        else if(tool.equalsIgnoreCase("POLYGON")){
            return this.ellipseTool;
        }
        else if(tool.equalsIgnoreCase("TEXT")){
            this.textTool.setText(text);
            this.text="";
            return this.textTool;
        }
        return null;
    }
    
    public ObjectTool getObjectTool(String tool) {
        if(tool.equalsIgnoreCase("MOVE")){
            return this.moveTool; 
        }
        else if(tool.equalsIgnoreCase("STRETCH") || tool.equalsIgnoreCase("ADD")){   //  || actionName.equalsIgnoreCase("ADD")) { 
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

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
