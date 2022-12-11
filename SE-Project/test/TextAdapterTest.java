/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import newShapes.TextAdapter;
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
public class TextAdapterTest {
    
    public TextAdapterTest() {
    }
    
    @Test
    public void testToString(){
        TextAdapter r =new TextAdapter(47.0,91.7,"ciao", Paint.valueOf("0xffffffff"),Paint.valueOf("0x000000ff"),Font.font(11.0));
        assertEquals(r.toString(),"Text;47.0;91.7;ciao;0xffffffff;0x000000ff;11.0;1.0;1.0;0.0");
    }
    
    @Test
    public void testStringToText(){
        Text t=TextAdapter.stringToText("47.0;91.7;ciao;0xffffffff;0x000000ff;11.0;1.0;1.0;0.0");
        
        assertTrue(47.0==t.getX());
        assertTrue(91.7==t.getY());
        assertTrue("ciao".equals(t.getText()));
        assertTrue("0xffffffff".equals(t.getFill().toString()));
        assertTrue("0x000000ff".equals(t.getStroke().toString()));
        assertTrue(11.0==t.getFont().getSize());
        assertTrue(1.0==t.getScaleX());
        assertTrue(1.0==t.getScaleY());
        assertTrue(0.0==t.getRotate());
    }
}
