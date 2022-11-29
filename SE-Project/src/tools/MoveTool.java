/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javafx.scene.shape.Shape;

/**
 *
 * @author assun
 */
public class MoveTool extends ObjectTool{

    @Override
    public Shape setEndPoint(double x, double y) {
        if (this.shape != null) {
            this.shape.move(x, y);
        }
        return (Shape) this.shape;

    }
    
}