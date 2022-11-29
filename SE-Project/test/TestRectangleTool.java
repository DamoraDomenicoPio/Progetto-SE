/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author assun
 */

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import newShapes.NewShape;
import newShapes.RectangleAdapter;
import org.junit.*;
import static org.junit.Assert.*;
import tools.RectangleTool;

public class TestRectangleTool {
    @Test 
    public void testSetEndPoint() {
        
        RectangleTool tool = new RectangleTool();
        
        double startX = 10;
        double startY = 12; 
        double endX = 20; 
        double endY = 22; 

        tool.setxStart(startX); 
        tool.setyStart(startY); 
        
        Shape r = tool.setEndPoint(endX, endY);
        
        assertTrue(r instanceof Rectangle); 
        assertTrue(r instanceof NewShape);
        assertTrue(r instanceof RectangleAdapter);
        
        Rectangle rectangle = (Rectangle) r; 
        
        assertTrue(rectangle.getX() == startX);
        assertTrue(rectangle.getY() == startY);
        assertTrue(rectangle.getHeight() == startY-endY); 
        assertTrue(rectangle.getWidth() == startX-endX);
    }
}
