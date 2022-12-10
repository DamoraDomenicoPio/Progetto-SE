/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import static java.lang.Math.abs;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import newShapes.TextAdapter;

/**
 *
 * @author Domenico
 */
public class TextTool extends Tool{
    private String text;
    
    public TextTool(){
        this.text="";
    }
    

    @Override
    public Shape setEndPoint(double x, double y) {
        this.xEnd=x;
        this.yEnd=y;
        
        TextAdapter t=new TextAdapter(xStart, yStart, text);
        t.setFont(Font.font(abs(xStart-xEnd)));
        return t;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
