/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import javafx.scene.shape.Shape;

/**
 *
 * @author assun
 */
public class ResizeTool extends ObjectTool{

    @Override
    public Shape setEndPoint(double x, double y) {
        System.out.println("RESIZE set end point");
        super.shape.newResize(x, y);
        return (Shape) super.shape; 
    }
    
}
