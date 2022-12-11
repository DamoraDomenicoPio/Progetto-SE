/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import newShapes.TextAdapter;

/**
 * The TextTool allows you to create a new text
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public class TextTool extends Tool{
    /**
     * Represents the text inside the Text object.
     */
    private String text="";

    
    /**
     * Returns a shape representing the text
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     * @return a shape representing the text
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        this.xEnd=x;
        this.yEnd=y;
        
        TextAdapter t=new TextAdapter(xStart, yStart, text);
        t.setFont(Font.font(1));
        return t;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
