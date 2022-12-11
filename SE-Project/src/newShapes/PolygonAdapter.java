/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newShapes;

import java.util.ArrayList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;



/**
 * The PolygonAdapter class creates and manages a polygon.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
 */
public class PolygonAdapter extends Polygon implements ShapeAdapter{
    private double xMin;
    private double yMin;
    private double fixedPointX;
    private double fixedPointY;
    private double xMidPoint=0;
    private double yMidPoint=0;
    
    private double rotationAngle = 0; 
    
    /**
     * Creates a new instance of Polygon given the coordinates.
     * @param collection collection of doubles containing coordinates.
     */
    public PolygonAdapter(ArrayList<Double> collection) {
        
        super();
        this.getPoints().addAll(collection);
        int i=0;
        this.xMin=collection.get(0);
        this.yMin=collection.get(1);
        double xMax=0;
        double yMax=0;
        for(double k : collection){
            if(i%2==0){
                xMidPoint+=k;
                if(k<this.xMin){
                    this.xMin=k;
                }
                if(k>xMax){
                    xMax=k;
                }
            }
            else{
                yMidPoint+=k;
                if(k<this.yMin){
                    this.yMin=k;
                }
                if(k>yMax){
                    yMax=k;
                }
            }
            i++;
        }
        xMidPoint=(xMax+xMin)/2;
        yMidPoint=(yMax+yMin)/2;
        this.fixedPointX=xMin;
        this.fixedPointY=yMin;
        
    }
    
    /**
     * Creates a new instance of Polygon given the coordinates.
     * @param collection collection of doubles containing coordinates.
     * @param fill the fill color of the polygon.
     * @param stroke the stroke color of the polygon.
     */
    public PolygonAdapter(ArrayList<Double> collection, Paint fill, Paint stroke) {
        this(collection);
        this.setFill(fill);
        this.setStroke(stroke);
    }
    

    /**
     * Creates a new instance of Polygon given the coordinates.
     * @param collection collection of doubles containing coordinates.
     * @param fill the fill color of the polygon.
     * @param stroke the stroke color of the polygon.
     * @param strokeWidth the width of the stroke of the rectangle.
     */
    public PolygonAdapter(ArrayList<Double> collection, Paint fill, Paint stroke, double strokeWidth) {
        this(collection, fill, stroke);
        this.setStrokeWidth(strokeWidth);
    }

    /**
     * Returns a string representation of this {@code PolygonAdapter} object.
     * @return a string representation of this {@code PolygonAdapter} object.
     */
    @Override
    public String toString(){
        String points="";
        for(double k: this.getPoints()){
            points=points+k+";";
        }
        return "Polygon;" +
                this.getPoints().size()+";" + 
                points +
                this.getFill() + ";" + 
                this.getStroke() + ";" + 
                this.getStrokeWidth()+ ";" + 
                this.getRotate();
    
    }
    
    /**
     * Return a Polyogn from a string.
     * @param string String representing the object.
     * @return a Polygon Object
     */
    public static Polygon stringToPolygon(String string) {
        String[] values=string.split(";");
        int size=Integer.parseInt(values[0]);
        ArrayList<Double> l=new ArrayList<>();
        int i;
        for(i=1;i<=size;i++){
            l.add(Double.parseDouble(values[i]));
        }
        Polygon p= new PolygonAdapter(l,
                Paint.valueOf(values[i]),
                Paint.valueOf(values[i+1]),
                Double.parseDouble(values[i+2]));
        p.setRotate(Double.parseDouble(values[i+3]));
        return p;
    }
    

    /**
     * Method that allows you to move the polygon.
     * @param x horizontal coordinate of the midpoint.
     * @param y vertical coordinate of the midpoint.
     */
    @Override
    public void move(double x, double y) {
        
        double dx=x-this.xMidPoint;
        double dy=y-this.yMidPoint;
        this.xMin+=dx;
        this.yMin+=dy;
        this.fixedPointX=xMin;
        this.fixedPointY=yMin;
        int i=0;
        for(double k: this.getPoints()){
            if(i%2==0){
                this.getPoints().set(i, k+dx);
            }
            else{
                this.getPoints().set(i, k+dy);
            }
            i++;
        }
        this.xMidPoint=x;
        this.yMidPoint=y;
    }
    
    /**
     * Method that allows you to stretch the polygon.
     * @param x horizontal coordinate of the endpoint.
     * @param y vertical coordinate of the endpoint.
     */
    @Override
    public void stretch(double x, double y) {
        
        double xMax=this.fixedPointX+(this.xMidPoint-this.fixedPointX)*2;
        double yMax=this.fixedPointY+(this.yMidPoint-this.fixedPointY)*2;
        
        double xIncrement=(x-this.fixedPointY)/(xMax-this.fixedPointY);
        double yIncrement=(y-this.fixedPointY)/(yMax-this.fixedPointY);
        if(xIncrement!=0 && yIncrement!=0){
        
            int i=0;
            for(double k: this.getPoints()){
                if(i%2==0){
                    this.getPoints().set(i, this.fixedPointX+ (k-this.fixedPointX)*xIncrement);
                }
                else{
                    this.getPoints().set(i, this.fixedPointY+ (k-this.fixedPointY)*yIncrement);
                }
                i++;
        }
        this.xMidPoint=this.fixedPointX+(x-this.fixedPointX)/2;
        this.yMidPoint=this.fixedPointY+(y-this.fixedPointY)/2;
        xMin=fixedPointX>x?x:fixedPointX;
        yMin=fixedPointY>y?y:fixedPointY;
        }
    }
    
    
    
    /**
     * Method that allows you to resize the polygon.
     * @param r resize factor.
     */
    @Override
    public void newResize(double r) {
        int i=0;
        double t;
        for(double k: this.getPoints()){
            if(i%2==0){
                t=xMidPoint + (k-this.xMidPoint)*r;
                this.getPoints().set(i, t);
                if(t<xMin){
                    xMin=t;
                }
            }
            else{
                t=yMidPoint+ (k-this.yMidPoint)*r;
                this.getPoints().set(i, t);
                if(t<yMin){
                    yMin=t;
                }
            }
            i++;
        }
        this.fixedPointX=xMin;
        this.fixedPointY=yMin;
    }

    /**
     * Method that allows you to rotate the rectangle.
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
        this.rotationAngle=rotationAngle;
        this.rotate(rotationAngle);
    }

    /**
     * method that allows you to mirror vertically
     */
     @Override
    public void mirrorVertical(){
        this.setRotate(-this.getRotate());
    }
    
    /**
     * method that allows you to mirror horizontally
     */
    @Override
    public void mirrorHorizontal(){
        this.setRotate(180-this.getRotate());
    }
    
    
    /**
     * method that moves the pasted shape by one offset
     * @param r the offset
     */
    @Override
    public void moveOffset(double r) {
        this.move(this.xMidPoint+r, this.yMidPoint+r);
    }

}
