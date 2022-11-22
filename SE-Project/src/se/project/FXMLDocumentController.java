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
import shapes.RectangleShape;
import shapes.RectangleTool;


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
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem loadButton;
    @FXML
    private Canvas canvas;
    
    public GraphicsContext g;
    public ColorPicker cpLine = new ColorPicker(Color.BLACK);
    public ColorPicker cpFill = new ColorPicker(Color.BLACK);
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!!!!! Ciao Mondo ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveOnAction(ActionEvent event) {
        g=canvas.getGraphicsContext2D();
        //group.getChildren();
    }

    @FXML
    private void addEllipse(ActionEvent event) {
    }

    @FXML
    private void addRectangle(ActionEvent event) {
        RectangleShape r= new RectangleShape();
        //group.getChildren().add(r.getRectangle());
    }

    @FXML
    private void addLine(ActionEvent event) {
    }

    private RectangleTool r= new RectangleTool();
    public Rectangle rectangle=new Rectangle();
    
    @FXML
    private void canvasOnMouseReleased(MouseEvent event) {
        Rectangle rec= r.setEndPoint(event.getSceneX(), event.getSceneY());
        
        g = canvas.getGraphicsContext2D();
        g.setStroke(cpLine.getValue());
        g.setFill(cpFill.getValue());

        g.fillRect(r.getxStart(),r.getyStart(),r.getHeight(), r.getWeight());
        g.strokeRect(r.getxStart(),r.getyStart(),r.getHeight(), r.getWeight());
    }

    @FXML
    private void canvasOnMousePressed(MouseEvent event) {
        r.setStartPoint(event.getSceneX(), event.getSceneY());
    }
    
}
