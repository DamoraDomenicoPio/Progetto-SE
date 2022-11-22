/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Domenico
 */
public class RectangleShape {
    private Rectangle rectangle;

    public RectangleShape() {
        this.rectangle = new Rectangle(100,100);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    
    
}
