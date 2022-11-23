/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.*;
import static org.junit.Assert.*;
import shapes.*;
import shapes.ShapeFactory;

/**
 *
 * @author Domenico
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    @Test
    public void testShapeFactory(){
        assertTrue(ShapeFactory.getShape("Rectangle") instanceof RectangleTool);
        assertTrue(ShapeFactory.getShape("Line") instanceof LineSegmentTool);
        assertTrue(ShapeFactory.getShape("Ellipse") instanceof EllipseTool);
        assertTrue(ShapeFactory.getShape("Elipse") == null);
    }
    
    /*@BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
