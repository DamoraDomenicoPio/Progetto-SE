/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
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
   
    private Shape selected; 

    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker insideColorPicker;
    
    private double xPressed=0;
    private double yPressed=0;
    private String shapeToInsert="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveOnAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        try(PrintWriter o=new PrintWriter(new BufferedWriter(new FileWriter(fileChooser.showOpenDialog(null).getPath())))){
            for(Node i: group.getChildren()){
                Shape s=(Shape) i;
                o.write(s.toString().replace("[", ";").replace("]", "\n"));
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void loadOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        try(Scanner i=new Scanner(new BufferedReader(new FileReader(fileChooser.showOpenDialog(null).getPath())))){
            group.getChildren().clear();
            i.useLocale(Locale.US);
            i.useDelimiter("\n");
            while(i.hasNext()){
                String shapeString=i.next();
                Shape s= ShapeFactory.shapeCreate(shapeString);
                
                group.getChildren().add(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    

    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        // TASTO DESTRO
        if (event.getButton() == MouseButton.SECONDARY){
            if(event.getTarget() instanceof  Shape){
                System.out.println("Selected a "+ event.getTarget().getClass().getName());
                this.selected = (Shape) event.getTarget();
            }
            else {
                this.selected = null; 
                System.out.println("Unselected");
            }
        }
        //TASTO SINISTRO 
        else {
            System.out.println("Rilasciato");
            ShapeTool shapeTool= ShapeFactory.getShape(shapeToInsert);
            shapeTool.setStartPoint(xPressed, yPressed);
            Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
            shape.setFill(Color.WHITE);
            shape.setStroke(Color.BLACK);
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
