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
    private double fixedPointX;
    private double fixedPointY;
    
    /**
     * Creates a new instance of Text with the given position and text.
     * @param x horizontal position of the text.
     * @param y vertical position of the text.
     * @param value text contained in the Text object.
     */
    public TextAdapter(double x, double y, String value){
        super(x, y, value);
        this.fixedPointX=x;
        this.fixedPointY=y;
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
        return "Text;" + this.getX() + ";" + this.getY() + ";" + this.getText() + ";" + this.getFill() + ";" + this.getStroke() + ";" + this.getFont().getSize() + ";" + this.getScaleX() + ";" + this.getScaleY() + ";" + this.getRotate();
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
        t.setScaleX(Double.parseDouble(values[6]));
        t.setScaleY(Double.parseDouble(values[7]));
        t.setRotate(Double.parseDouble(values[8]));
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
        this.fixedPointX=x;
        this.fixedPointY=y;
    }

    /**
     * Method that allows you to stretch the text.
     * @param x coordinate of the horizontal axis.
     * @param y coordinate of the vertical axis.
     */
    @Override
    public void stretch(double x, double y) {
        double len=2*(x-this.fixedPointX)/this.getText().length();
        if(len<-2 || len>2){
            this.setFont(Font.font(abs(len)));
            this.setScaleY(2*(y-this.fixedPointY)/this.getFont().getSize());
            if(this.fixedPointX>x){
                super.setX(x);
                this.setScaleX(-1);
            }
            else{
                this.setScaleX(1);
            }
        
        }
        
        
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

    /**
     * method that allows you to mirror vertically
     */
    @Override
    public void mirrorVertical() {
        this.setScaleX(-1*this.getScaleX());
        this.setRotationAngle(-this.rotationAngle);
    }

    /**
     * method that allows you to mirror horizontally
     */
    @Override
    public void mirrorHorizontal() {
        this.setScaleY(-1*this.getScaleY());
        this.setRotationAngle(360-this.rotationAngle);
    }
    
    
    /**
     * method that moves the pasted shape by one offset
     * @param r the offset
     */
    @Override
    public void moveOffset(double r) {
        this.move(this.getX()+r, this.getY()+r);
    }
}
