/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.util.ArrayList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import newShapes.PolygonAdapter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Domenico
 */
public class PolygonAdapterTest {
    
    public PolygonAdapterTest() {
    }
    
    @Test
    public void testToString(){
        ArrayList<Double> list=new ArrayList<>();
        list.add(1.0);
        list.add(25.0);
        list.add(54.2);
        list.add(11.8);
        list.add(16.8);
        list.add(18.3);
        list.add(66.3);
        list.add(180.0);
        list.add(154.0);
        list.add(15.7);
        PolygonAdapter p =new PolygonAdapter(list, Paint.valueOf("0xffffffff"),Paint.valueOf("0x000000ff"));
        assertEquals(p.toString(),"Polygon;10;1.0;25.0;54.2;11.8;16.8;18.3;66.3;180.0;154.0;15.7;0xffffffff;0x000000ff;1.0;0.0");
    }
    
    @Test
    public void testStringToPolygon(){
        Polygon p = PolygonAdapter.stringToPolygon("10;1.0;25.0;54.2;11.8;16.8;18.3;66.3;180.0;154.0;15.7;0xffffffff;0x000000ff;1.0;0.0");
        assertTrue(p.contains(1.0, 25.0));
        assertTrue(p.contains(54.2, 11.8));
        assertTrue(p.contains(16.8, 18.3));
        assertTrue(p.contains(66.3, 180.0));
        assertTrue(p.contains(154.0, 15.7));
        assertTrue("0xffffffff".equals(p.getFill().toString()));
        assertTrue("0x000000ff".equals(p.getStroke().toString()));
        assertTrue(1.0==p.getStrokeWidth());
        assertTrue(0.0==p.getRotate());
    }
}
