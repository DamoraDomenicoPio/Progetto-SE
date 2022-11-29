
import javafx.scene.shape.Shape;
import newShapes.RectangleAdapter;
import tools.MoveTool;
import org.junit.*;
import static org.junit.Assert.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author assun
 */
public class TestMoveTool {
    
    @Test 
    public void testSetEndPoint() {
        
        MoveTool tool = new MoveTool();
        
        double startX = 10;
        double startY = 12; 
        double endX = 20; 
        double endY = 22; 

        RectangleAdapter rectangle = new RectangleAdapter(startX, startY, startX-endX, startY-endY);  // Creates a new rectangle 
        
        tool.setShape(rectangle);  // Inserts the shape that has to be moved 
        
        Shape r = tool.setEndPoint(50, 55);   // Moves the shape 
        
        assertTrue(rectangle.getX() == 50);  // Checks if the shape has been moved in the desired position 
        assertTrue(rectangle.getY() == 53);
        
        assertTrue(3 == 5);

    }
}
