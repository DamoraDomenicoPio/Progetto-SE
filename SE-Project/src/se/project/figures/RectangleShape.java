/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.project.figures;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author assun
 */
public class RectangleShape implements Shape {
    private int height; 
    private int width; 
    private Rectangle rectangle; 
    
    public void RectangleShape() {
        this.height = 50; 
        this.width = 50; 
        
        this.rectangle = new Rectangle(this.height, this.width);
    }
    
}
