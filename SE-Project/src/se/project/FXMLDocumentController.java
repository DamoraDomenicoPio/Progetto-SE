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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

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
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!!!!! Ciao Mondo ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
