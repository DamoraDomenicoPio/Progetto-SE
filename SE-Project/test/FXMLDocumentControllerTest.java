/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import newShapes.NewShape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utility.ToolBox;
import tools.Tool;
import utility.FileManager;

/**
 *
 * @author Domenico
 */
public class FXMLDocumentControllerTest {
    private String file;
    private Group group=new Group();
    
    public FXMLDocumentControllerTest() {
        ToolBox tool= new ToolBox();
        String shapeToInsert="Ellipse";
        Tool shapeTool= tool.getShapeTool(shapeToInsert);
        shapeTool.setStartPoint(1.5, 4.8);
        Shape shape= shapeTool.setEndPoint(9.3, 18.4);
        shape.setStroke(Paint.valueOf("0x00aedd34"));
        shape.setFill(Paint.valueOf("0x0045aa34"));
        group.getChildren().add(shape);
        
        shapeToInsert="Rectangle";
        shapeTool= tool.getShapeTool(shapeToInsert);
        shapeTool.setStartPoint(1.5, 6.7);
        shape= shapeTool.setEndPoint(3.0, 38.0);
        shape.setStroke(Paint.valueOf("0x00ffffff"));
        shape.setFill(Paint.valueOf("0x000000ff"));
        group.getChildren().add(shape);
        
        shapeToInsert="Line";
        shapeTool= tool.getShapeTool(shapeToInsert);
        shapeTool.setStartPoint(180.5, 35.7);
        shape= shapeTool.setEndPoint(11.3, 7.7);
        shape.setStroke(Paint.valueOf("0x00aaaabb"));
        group.getChildren().add(shape);
        assertTrue(group.getChildren().contains(shape));
        assertTrue(group.getChildren().size()==3);
    }
    
    
    @Test
    public void testPasteOnAction(){
        //get Rectangle
        Shape selectedShape=(Shape) group.getChildren().get(1);
        Shape shape =NewShape.stringToShape(selectedShape.toString());
        group.getChildren().add(shape);
        assertTrue(group.getChildren().contains(shape));
        assertTrue(group.getChildren().size()==4);
    }
    
    @Test
    public void testDeleteSelected(){
        Shape selectedShape=(Shape) group.getChildren().get(2);
        group.getChildren().remove(selectedShape);
        assertFalse(group.getChildren().contains(selectedShape));
        assertTrue(group.getChildren().size()==2);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        file="testFile.txt";
    }
    
    @After
    public void tearDown() {
    }

}
