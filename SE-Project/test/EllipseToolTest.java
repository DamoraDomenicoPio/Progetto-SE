/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static java.lang.Math.abs;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import newShapes.EllipseAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.EllipseTool;

/**
 *
 * @author Domenico
 */
public class EllipseToolTest {
    
    public EllipseToolTest() {
    }
    
    @Test
    public void testSetEndPoint(){
        EllipseTool e=new EllipseTool();
        double startX=12.5;
        double startY=34.9;
        double endX=11.0;
        double endY=98.0;
        
        e.setStartPoint(startX, startY);
        Shape s=e.setEndPoint(endX, endY);
        
        assertTrue(s instanceof EllipseAdapter);
    }
}
