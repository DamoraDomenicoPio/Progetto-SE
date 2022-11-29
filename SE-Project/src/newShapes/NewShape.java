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
     * Method that allows you to resize the selected shape
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     */
    public void newResize(double x, double y);
    
    
}
