/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import tools.LineSegmentTool;
import tools.EllipseTool;
import tools.RectangleTool;
import javafx.scene.shape.*;
import org.junit.*;
import static org.junit.Assert.*;
import tools.ShapeFactory;

/**
 *
 * @author Domenico
 */
public class ShapeToolTest {
    
    public ShapeToolTest() {
    }
    
    @Test
    public void testShapeFactory(){
        assertTrue(ShapeFactory.getShapeTool("Rectangle", 1.0) instanceof RectangleTool);
        assertTrue(ShapeFactory.getShapeTool("Line", 1.0) instanceof LineSegmentTool);
        assertTrue(ShapeFactory.getShapeTool("Ellipse", 1.0) instanceof EllipseTool);
        assertTrue(ShapeFactory.getShapeTool("Elipse", 1.0) == null);
    }
    
    @Test
    public void testShapeCreate(){
        assertTrue(ShapeFactory.shapeCreate("Rectangle;145.0;171.0;155.0;127.0;0xffffffff;0x000000ff;1.0") instanceof Rectangle);
        assertTrue(ShapeFactory.shapeCreate("Line;138.0;94.0;201.0;208.0;0x000000ff;1.0") instanceof Line);
        assertTrue(ShapeFactory.shapeCreate("Ellipse;247.0;200.0;128.0;119.0;0xffffffff;0x000000ff;1.0") instanceof Ellipse);
        assertTrue(ShapeFactory.getShapeTool("Ellipse;258.0;208.0;0.0", 1.0) == null);
    }

}
