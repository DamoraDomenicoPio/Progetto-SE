/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import newShapes.EllipseAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Domenico
 */
public class EllipseAdapterTest {
    
    public EllipseAdapterTest() {
    }
    
    @Test
    public void testStringToEllipse(){
        Ellipse e= EllipseAdapter.stringToEllipse("99.0;42.0;3.0;4.0;0xffff0000;0x001111ff;4.0;0.0");
        
        assertTrue(99.0==e.getCenterX());
        assertTrue(42.0==e.getCenterY());
        assertTrue(3.0==e.getRadiusX());
        assertTrue(4.0==e.getRadiusY());
        assertTrue("0xffff0000".equals(e.getFill().toString()));
        assertTrue("0x001111ff".equals(e.getStroke().toString()));
        assertTrue(4.0==e.getStrokeWidth());
        assertTrue(0.0==e.getRotate());
        
    }
    
    @Test
    public void testToString(){
        EllipseAdapter e =new EllipseAdapter(99.0,42.0,3.0,4.0,Paint.valueOf("0xffff0000"),Paint.valueOf("0x001111ff"),4.0);
        assertEquals(e.toString(),"Ellipse;99.0;42.0;3.0;4.0;0xffff0000;0x001111ff;4.0;0.0");
    }
}
