/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.shape.Shape;
import newShapes.PolygonAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.PolygonTool;

/**
 *
 * @author Domenico
 */
public class PolygonToolTest {
    
    public PolygonToolTest() {
    }
    
    @Test
    public void testSetEndPoint(){
        PolygonTool p=new PolygonTool();
        double startX=54.3;
        double startY=8.7;
        double endX=23.8;
        double endY=24.0;
        
        p.setStartPoint(startX, startY);
        Shape s=p.setEndPoint(endX, endY);
        
        assertTrue(s instanceof PolygonAdapter);
    }
}
