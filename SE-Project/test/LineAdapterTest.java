/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import newShapes.LineAdapter;
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
public class LineAdapterTest {
    
    public LineAdapterTest() {
    }
    
    @Test
    public void testToString(){
        LineAdapter l =new LineAdapter(148.0,96.0,111.0,44.0,Paint.valueOf("0x00aedd34"),1.0);
        assertEquals(l.toString(),"Line;148.0;96.0;111.0;44.0;0x00aedd34;1.0");
    }
    
    @Test
    public void testStringToLine(){
        Line l=LineAdapter.stringToLine("148.0;96.0;111.0;44.0;0x00aedd34;1.0");
        
        assertTrue(148.0==l.getStartX());
        assertTrue(96.0==l.getStartY());
        assertTrue(111.0==l.getEndX());
        assertTrue(44.0==l.getEndY());
        assertTrue("0x00aedd34".equals(l.getStroke().toString()));
        assertTrue(1.0==l.getStrokeWidth());
        
        
    }

}
