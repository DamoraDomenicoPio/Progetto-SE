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
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import shapes.ObjectTool;
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
   
    private Shape selectedShape = null; 
    private String copiedShape = null; 

    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker insideColorPicker;
    
    private double xPressed=0;
    private double yPressed=0;
    private String shapeToInsert="";
    @FXML
    private MenuItem deleteButton;
    @FXML
    private TextField shapeSize;
    @FXML
    private Button applySizeButton;
    @FXML
    private MenuItem deleteButton11;
    @FXML
    private MenuItem deleteButton111;
    
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
                o.write(s.toString()+"\n");
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
        if (event.getButton()==MouseButton.SECONDARY){  // Conthorls wheter the right button of the mouse has been clicked 
            //SELEZIONE
            if(event.getTarget() instanceof  Shape){
                this.selectedShape = (Shape) event.getTarget();
            }
            else {
                this.selectedShape = null; 
            }
        }
        //TASTO SINISTRO 
        else {   // Otherwise the left button has been clicked 
            if(shapeToInsert!=""){
                ShapeTool shapeTool= ShapeFactory.getShape(shapeToInsert);
                shapeTool.setStartPoint(xPressed, yPressed);
                if (shapeTool instanceof ObjectTool){
                    ((ObjectTool) shapeTool).setShape(selectedShape);
                    Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());

                }
                else {
                    Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
                    shape.setStroke(borderColorPicker.getValue());
                    shape.setFill(insideColorPicker.getValue());
                    group.getChildren().add(shape);
                }
            }
        }
    }

    
    @FXML
    private void groupOnMousePressed(MouseEvent event) {
        xPressed=event.getX();
        yPressed=event.getY();
    }

    @FXML
    private void copyOnAction(ActionEvent event) {
        copySelected();
    }

    @FXML
    private void pasteOnAction(ActionEvent event) {
        if (this.copiedShape != null) { // If a shape has been selected
            group.getChildren().add(ShapeFactory.shapeCreate(copiedShape));
              
        }
    }
    
    @FXML
    private void changeColorShape(ActionEvent event) {
        System.out.println("cambio colore");
        selectedShape.setStroke(borderColorPicker.getValue());
        selectedShape.setFill(insideColorPicker.getValue());
    }

    @FXML
    private void deleteOnAction(ActionEvent event) {
        deleteSelected();
    }

    @FXML
    private void cutOnAction(ActionEvent event) {
        copySelected(); 
        deleteSelected();
    }

   

    
    private void deleteSelected() {
        if(selectedShape!=null){
            group.getChildren().remove(selectedShape);
            selectedShape=null;
        }
    }

    @FXML
    private void changeShapeSize(MouseEvent event) {
        try{
            double size= Double.parseDouble(shapeSize.getText());
            if(size<0)
                shapeSize.setText("1");
            else{
                selectedShape.setScaleX(size);
                selectedShape.setScaleY(size);
            }
            }
        catch (Exception e){
        }
    }


     
    
    private void copySelected() {
    if (this.selectedShape != null) { // If a shape has been selected
            this.copiedShape = this.selectedShape.toString();  // Copies the selected shape
        }
        // If nothing was selected, nothig gets copied 
    }

    @FXML
    private void moveOnAction(ActionEvent event) {
        shapeToInsert="MOVE";

    }

    @FXML
    private void resizeOnAction(ActionEvent event) {
        shapeToInsert = "RESIZE";
    }

    
    
}
