/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import static java.lang.Math.abs;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * The TextAdapter class creates and manages a text.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public class TextAdapter extends Text implements NewShape{
    private double rotationAngle = 0; 
    
    /**
     * Creates a new instance of Text with the given position and text.
     * @param x horizontal position of the text.
     * @param y vertical position of the text.
     * @param value text contained in the Text object.
     */
    public TextAdapter(double x, double y, String value){
        super(x, y, value);
    }
    
    /**
     * 
     * Creates a new instance of Text with the given position and text.
     * @param x horizontal position of the text.
     * @param y vertical position of the text.
     * @param value text contained in the Text object.
     * @param fill the fill color of the text.
     * @param stroke the stroke color of the text.
     * @param font tho font of the text.
     */
    public TextAdapter(double x, double y, String value, Paint fill, Paint stroke, Font font){
        super(x, y, value);
        this.setFill(fill);
        this.setStroke(stroke);
        this.setFont(font);
    }
    
    /**
     * Returns a string representation of this {@code TextAdapter} object.
     * @return a string representation of this {@code TextAdapter} object.
     */
    @Override
    public String toString() {
        return "Text;" + this.getX() + ";" + this.getY() + ";" + this.getText() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getFont().getSize()+ ";" + this.getRotate();
    }

    /**
     * Return a Text from a string.
     * @param string String representing the object.
     * @return a Text Object.
     */
    public static Text stringToText(String string) {
        String[] values=string.split(";");
        TextAdapter t= new TextAdapter(Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                values[2],
                Paint.valueOf(values[3]),
                Paint.valueOf(values[4]),
                Font.font(Double.parseDouble(values[5])));
        t.setRotate(Double.parseDouble(values[6]));
        return t;
    }

    /**
     * Method that allows you to move the text.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void move(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Method that allows you to stretch the text.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void stretch(double x, double y) {
        this.setFont(Font.font(2*(x-this.getX())/this.getText().length()));
    }

    /**
     * Method that allows you to resize the text.
     * @param r resize factor.
     */
    @Override
    public void newResize(double r) {
        this.setFont(Font.font(this.getFont().getSize()*r));
    }

    /**
     * Method that allows you to rotate the text.
     * @param r angle in degrees.
     */
    @Override
    public void rotate(double r) {
        this.setRotate(r);
        
    }
    
    @Override
    public double getRotationAngle() {
        return this.rotationAngle; 
    }
    
    
    
    @Override
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle; 
        this.rotate(rotationAngle); 
    }

    @Override
    public void mirrorVertical() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mirrorHorizontal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
