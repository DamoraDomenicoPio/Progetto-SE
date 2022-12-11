/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import tools.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import org.junit.*;
import static org.junit.Assert.*;
import utility.ToolBox;
import newShapes.NewShape;
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
        assertTrue(tool.getShapeTool("Text") instanceof TextTool);
        assertTrue(tool.getShapeTool("Polygon") instanceof PolygonTool);
        assertTrue(tool.getShapeTool("Elipse") == null);
    }
    
    @Test
    public void testShapeCreate(){
        ToolBox tool= new ToolBox();
        assertTrue(NewShape.stringToShape("Rectangle;145.0;171.0;155.0;127.0;0xffffffff;0x000000ff;1.0;0.0") instanceof Rectangle);
        assertTrue(NewShape.stringToShape("Line;138.0;94.0;201.0;208.0;0x000000ff;1.0;0.0") instanceof Line);
        assertTrue(NewShape.stringToShape("Ellipse;247.0;200.0;128.0;119.0;0xffffffff;0x000000ff;1.0;0.0") instanceof Ellipse);
        assertTrue(NewShape.stringToShape("Text;47.0;91.7;ciao;0xffffffff;0x000000ff;22.3;1.0;1.0;0.0") instanceof Text);
        assertTrue(NewShape.stringToShape("Polygon;10;1.0;25.0;54.2;11.8;16.8;18.3;66.3;180.0;154.0;15.7;0xffffffff;0x000000ff;1.0;0.0") instanceof Polygon);
        assertTrue(tool.getShapeTool("Ellipse;258.0;208.0;0.0;0.0") == null);
    }

}
