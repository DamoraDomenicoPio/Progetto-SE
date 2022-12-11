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
import utility.ToolBox;
import newShapes.ShapeAdapter;
/**
 *
 * @author Domenico
 */
public class ShapeToolTest {
    
    public ShapeToolTest() {
    }
    
    @Test
    public void testShapeFactory(){
        ToolBox tool= new ToolBox();
        assertTrue(tool.getShapeTool("Rectangle") instanceof RectangleTool);
        assertTrue(tool.getShapeTool("Line") instanceof LineSegmentTool);
        assertTrue(tool.getShapeTool("Ellipse") instanceof EllipseTool);
        assertTrue(tool.getShapeTool("Elipse") == null);
    }
    
    @Test
    public void testShapeCreate(){
        ToolBox tool= new ToolBox();
        assertTrue(ShapeAdapter.stringToShape("Rectangle;145.0;171.0;155.0;127.0;0xffffffff;0x000000ff;1.0") instanceof Rectangle);
        assertTrue(ShapeAdapter.stringToShape("Line;138.0;94.0;201.0;208.0;0x000000ff;1.0") instanceof Line);
        assertTrue(ShapeAdapter.stringToShape("Ellipse;247.0;200.0;128.0;119.0;0xffffffff;0x000000ff;1.0") instanceof Ellipse);
        assertTrue(tool.getShapeTool("Ellipse;258.0;208.0;0.0") == null);
    }

}
