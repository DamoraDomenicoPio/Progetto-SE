/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.shape.Shape;
import newShapes.RectangleAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.RectangleTool;

/**
 *
 * @author Domenico
 */
public class RectangleToolTest {
    
    public RectangleToolTest() {
    }
    
    @Test
    public void testSetEndPoint(){
        RectangleTool e=new RectangleTool(1.0);
        double startX=7.3;
        double startY=34.7;
        double endX=134.6;
        double endY=164.7;
        
        e.setStartPoint(startX, startY);
        Shape s=e.setEndPoint(endX, endY);
        
        assertTrue(s instanceof RectangleAdapter);
    }
}
