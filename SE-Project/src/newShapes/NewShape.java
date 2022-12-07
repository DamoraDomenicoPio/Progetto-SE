 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package newShapes;

/**
 * An interface that contains helper methods for a shape.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public interface NewShape {
    
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
    
    public double getRotationAngle(); 
    
    public void setRotationAngle(double rotationAngle); 
}
