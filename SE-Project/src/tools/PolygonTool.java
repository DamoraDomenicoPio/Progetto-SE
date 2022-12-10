/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.ArrayList;
import javafx.scene.shape.Shape;
import newShapes.PolygonAdapter;

/**
 * 
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 * The PolygonTool allows you to create a new polygon
 */
public class PolygonTool extends Tool{
    /**
     * Represents the collection of doubles containing coordinates.
     */
    private ArrayList<Double> list=new ArrayList<>();

    /**
     * Returns a shape representing the polygon
     * @param x coordinate of the horizontal axis
     * @param y coordinate of the vertical axis
     * @return a shape representing the polygon
     */
    @Override
    public Shape setEndPoint(double x, double y) {
        this.list.add(x);
        this.list.add(y);
        return new PolygonAdapter(list);
    }

    public void setList(ArrayList<Double> list) {
        this.list.clear();
        this.list.addAll(list);
    }
    
    
}
