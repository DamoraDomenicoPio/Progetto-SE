/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import shapes.RectangleTool;
import shapes.ShapeTool;
import shapes.ShapeFactory;


/**
 *
 * @author Domenico
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private MenuButton shapesButton;
    @FXML
    private MenuItem EllipseButton;
    @FXML
    private MenuItem rectangleButton;
    @FXML
    private MenuItem lineButton;
    private ColorPicker colorPicker;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem loadButton;
    @FXML
    private Group group;
    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker insideColorPicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveOnAction(ActionEvent event) {
        
    }

    @FXML
    private void addEllipse(ActionEvent event) {
        shapeToInsert="Ellipse";
    }

    @FXML
    private void addRectangle(ActionEvent event) {
        shapeToInsert="Rectangle";
    }

    @FXML
    private void addLine(ActionEvent event) {
        shapeToInsert="Line";
    }
    
    private double xPressed=0;
    private double yPressed=0;
    private String shapeToInsert="";
    

    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        if(shapeToInsert!=""){
            ShapeTool shapeTool= ShapeFactory.getShape(shapeToInsert);
            shapeTool.setStartPoint(xPressed, yPressed);
            Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
            shape.setStroke(borderColorPicker.getValue());
            shape.setFill(insideColorPicker.getValue());
            group.getChildren().add(shape);
        }
    }

    
    @FXML
    private void groupOnMousePressed(MouseEvent event) {
        xPressed=event.getX();
        yPressed=event.getY();
    } 
    
}
