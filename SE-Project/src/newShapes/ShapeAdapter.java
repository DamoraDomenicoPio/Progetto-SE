 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package newShapes;

import javafx.scene.shape.Shape;

/**
 * An interface that contains helper methods for a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public interface ShapeAdapter {
    
    /**
     * Method that allows you to move the selected shape
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    public void move(double x, double y);
    
    
    /**
     * Method that allows you to stretch the selected shape
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    public void stretch(double x, double y);
    
    /**
     * Method that allows you to resize the selected shape
     * @param r resize factor
     */
    public void newResize(double r);
    
    
    /**
     * Method that rotates the shape without updating the rotationAngle attribute
     * @param r rotation angle 
     * 
     * This method is supposed to be used to create animation 
     * and the setRotationAngle() method should be called once the animation ends
     */
    public void rotate(double r);
    
    /**
     * Method that returns the rotation angle
     * @return the angle of rotation
     */
    public double getRotationAngle(); 
    
    /**
     * Method that sets the rotation angle
     * @param rotationAngle the angle of rotation
     */
    public void setRotationAngle(double rotationAngle); 
    
    /**
     * method that allows you to mirror vertically
     */
    public void mirrorVertical();
    
    /**
     * method that allows you to mirror horizontally
     */
    public void mirrorHorizontal();
    
    /**
     * method that moves the pasted shape by one offset
     * @param r the offset
     */
    public void moveOffset(double r);
    
    /**
     * Method that restores a shape from its formatString 
     * @param formatString string containing the shape to create
     * @return a shape given a string
     * 
     * The formatter string can be ottained unsing the toString method
     */
    public static Shape stringToShape(String formatString) {
        String[] values=formatString.split(";", 2);
        
        if(values[0].equalsIgnoreCase("RECTANGLE")){
            return RectangleAdapter.stringToRectangle(values[1]);
        }
        else if(values[0].equalsIgnoreCase("ELLIPSE")){
            return EllipseAdapter.stringToEllipse(values[1]);
        }
        else if(values[0].equalsIgnoreCase("LINE")){
            return LineAdapter.stringToLine(values[1]);
        }
        else if(values[0].equalsIgnoreCase("POLYGON")){
            return PolygonAdapter.stringToPolygon(values[1]);
        }
        else if(values[0].equalsIgnoreCase("TEXT")){
            return TextAdapter.stringToText(values[1]);
        }
        return null;
    }
}
