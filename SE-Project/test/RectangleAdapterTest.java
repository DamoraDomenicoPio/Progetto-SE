/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import newShapes.RectangleAdapter;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Domenico
 */
public class RectangleAdapterTest {
    
    public RectangleAdapterTest() {
    }
    

    
    @Test
    public void testToString(){
        RectangleAdapter r =new RectangleAdapter(145.0,171.0,155.0,127.0, Paint.valueOf("0xffffffff"),Paint.valueOf("0x000000ff"),1.0);
        assertEquals(r.toString(),"Rectangle;145.0;171.0;155.0;127.0;0xffffffff;0x000000ff;1.0;0.0");
    }
    
    @Test
    public void testStringToRectangle(){
        Rectangle r=RectangleAdapter.stringToRectangle("145.0;171.0;155.0;127.0;0xffffffff;0x000000ff;1.0;3.0");
        
        assertTrue(145.0==r.getX());
        assertTrue(171.0==r.getY());
        assertTrue(155.0==r.getWidth());
        assertTrue(127.0==r.getHeight());
        assertTrue("0xffffffff".equals(r.getFill().toString()));
        assertTrue("0x000000ff".equals(r.getStroke().toString()));
        assertTrue(1.0==r.getStrokeWidth());
        assertTrue(3.0==r.getRotate());
    }
}
