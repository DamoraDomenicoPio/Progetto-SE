/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javafx.scene.shape.Shape;
import newShapes.TextAdapter;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.TextTool;

/**
 *
 * @author Domenico
 */
public class TextToolTest {
    
    public TextToolTest() {
    }
    
    @Test
    public void testSetEndPoint(){
        TextTool p=new TextTool();
        double startX=9.9;
        double startY=23.6;
        double endX=234.7;
        double endY=23.2;
        
        p.setStartPoint(startX, startY);
        Shape s=p.setEndPoint(endX, endY);
        
        assertTrue(s instanceof TextAdapter);
    }
}
