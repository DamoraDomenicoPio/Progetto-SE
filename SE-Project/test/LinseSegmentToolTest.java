/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.shape.Shape;
import newShapes.LineAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shapes.LineSegmentTool;

/**
 *
 * @author Domenico
 */
public class LinseSegmentToolTest {
    
    public LinseSegmentToolTest() {
    }
    
    @Test
    public void testSetEndPoint(){
        LineSegmentTool e=new LineSegmentTool();
        double startX=66.1;
        double startY=43.5;
        double endX=44.6;
        double endY=108.0;
        
        e.setStartPoint(startX, startY);
        Shape s=e.setEndPoint(endX, endY);
        
        assertTrue(s instanceof LineAdapter);
    }
}
