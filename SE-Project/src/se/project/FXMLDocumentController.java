/**
 *  Package se.project per la consegna
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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import shapes.ObjectTool;
import shapes.ShapeTool;
import shapes.ShapeFactory;


/**
 * The FXMLDocumentController class is the application controller.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca 
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button lineButton;
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
    
    private boolean selectionButtonStatus = false;
    
    private String shapeToInsert="";
    @FXML
    private MenuItem deleteButton;
    @FXML
    private TextField shapeSize;
    @FXML
    private Button applySizeButton;
    @FXML
    private Line lineIntoButton;
    @FXML
    private Rectangle rectangleIntoButton;
    @FXML
    private Button ellipseButton;
    @FXML
    private Ellipse ellipseIntoButton;
    @FXML
    private Polyline polygonIntoSelectionButton;
    @FXML
    private Button undoButton;
    @FXML
    private Text arrowIntoUndoButton;
    @FXML
    private Text applyTextIntoButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
    *
    * Method that allows saving the drawing sheet inside a file. 
    * Clicking the 'Save' button opens a selection window in which the user can select a file (.txt) and 
    * choose it as the destination for saving.
    * @param event ActionEvent object generated when the 'Save' button is clicked. 
    */
    @FXML
    private void saveOnAction (ActionEvent event){
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
    
    /**
    *
    * Method that allows loading a drawing sheet saved inside a file. 
    * Clicking the 'Load' button opens a selection window in which the user can select a file (.txt) 
    * in which a drawing sheet is saved. 
    * Once the file has been chosen, the drawing sheet is loaded.
    * @param event ActionEvent object generated when the 'Load' button is clicked. 
    */
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
    
    /**
     * Method which, after having chosen the 'Ellipse' shape within the application,
     * modifies the string ShapeToinsert with the value "Ellipse".
     * @param event ActionEvent object generated when Ellipse shape is selected.
     */
    @FXML
    private void addEllipse(ActionEvent event) {
        shapeToInsert="Ellipse";
    }
    
    /**
     * Method which, after having chosen the 'Rectangle' shape within the application,
     * modifies the string ShapeToinsert with the value "Rectangle".
     * @param event ActionEvent object generated when Rectangle shape is selected.
     */
    @FXML
    private void addRectangle(ActionEvent event) {
        shapeToInsert="Rectangle";
        rectangleIntoButton.setFill(insideColorPicker.getValue());
        rectangleIntoButton.setStroke(borderColorPicker.getValue());
    }
    
    /**
     * Method which, after having chosen the 'Line' shape within the application,
     * modifies the string ShapeToinsert with the value "Line".
     * @param event ActionEvent object generated when Line shape is selected.
     */
    @FXML
    private void addLine(ActionEvent event) {
        shapeToInsert="Line";
        lineIntoButton.setStroke(borderColorPicker.getValue());
    }
    
    
    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        // Right key
        if (event.getButton()==MouseButton.SECONDARY){  
            // Selection
            if(event.getTarget() instanceof  Shape){
                this.selectedShape = (Shape) event.getTarget();
            }
            else {
                this.selectedShape = null; 
            }
        }
        // Left key 
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
    
    /**
     * Method that invokes the copySelected() method.
     * @param event ActionEvent object generated when the button 'Copy' is selected.
     */
    @FXML
    private void copyOnAction(ActionEvent event) {
        copySelected();
    }
    
    /**
     * Method that allows to paste a copied or cutted object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Paste' is selected.
     */
    @FXML
    private void pasteOnAction(ActionEvent event) {
        if (this.copiedShape != null) { // If a shape has been selected
            group.getChildren().add(ShapeFactory.shapeCreate(copiedShape));
              
        }
    }
    
    /**
     * Method that allows to change the color inside the selected shape and its border, by using 
     * the two colorPicker on the window.
     * @param event ActionEvent object generated when the button 'Change Color' is selected.
     */
    @FXML
    private void changeColorShape(ActionEvent event) {
        System.out.println("cambio colore");
        selectedShape.setStroke(borderColorPicker.getValue());
        selectedShape.setFill(insideColorPicker.getValue());
    }
    
    /**
     * Method that invokes the deleteSelected() method.
     * @param event ActionEvent object generated when the button 'Delete' is selected.
     */
    @FXML
    private void deleteOnAction(ActionEvent event) {
        deleteSelected();
    }
    
    /**
     * Method that allows to cut a selected object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Cut' is selected.
     */
    @FXML
    private void cutOnAction(ActionEvent event) {
        copySelected(); 
        deleteSelected();
    }

    /**
     * Method that allows to delete a selected object on the drawing sheet.
     */
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

    /**
     * Method that allows to copy a selected object on the drawing sheet.
     */
    private void copySelected() {
    if (this.selectedShape != null) { // If a shape has been selected
            this.copiedShape = this.selectedShape.toString();  // Copies the selected shape
        }
        // If nothing was selected, nothig gets copied 
    }
    
    /**
     * Method that changes the shapeToInsert string to the string "MOVE".
     * @param event ActionEvent object generated when the button 'Move' is selected.
     */
    @FXML
    private void moveOnAction(ActionEvent event) {
        shapeToInsert="MOVE";
    }
    
    /**
     * Method that changes the shapeToInsert string to the string "RESIZE".
     * @param event ActionEvent object generated when the button 'Resize' is selected.
     */
    @FXML
    private void resizeOnAction(ActionEvent event) {
        shapeToInsert = "RESIZE";
    }

    @FXML
    private void borderColorSelected(ActionEvent event) {
        ellipseIntoButton.setStroke(borderColorPicker.getValue());
        rectangleIntoButton.setStroke(borderColorPicker.getValue());
        lineIntoButton.setStroke(borderColorPicker.getValue());
    }

    @FXML
    private void insideColorSelected(ActionEvent event) {
        ellipseIntoButton.setFill(insideColorPicker.getValue());
        rectangleIntoButton.setFill(insideColorPicker.getValue());
    }

    @FXML
    private void onSelectionButtonPressed(ActionEvent event) {
        if(selectionButtonStatus == false){
            selectionButtonStatus = true;
            polygonIntoSelectionButton.setStroke(Color.DODGERBLUE);
            polygonIntoSelectionButton.setFill(Color.DODGERBLUE);
        }else{
            selectionButtonStatus = false;
            polygonIntoSelectionButton.setStroke(Color.rgb(191, 191, 191));
            polygonIntoSelectionButton.setFill(Color.rgb(191, 191, 191));   
        }
    }

    @FXML
    private void undoColorOnMouseReleased(MouseEvent event) {
        arrowIntoUndoButton.setFill(Color.BLACK);
    }

    @FXML
    private void undoColorOnMousePressed(MouseEvent event) {
        arrowIntoUndoButton.setFill(Color.DODGERBLUE);
    }

    @FXML
    private void undoOnAction(ActionEvent event) {
    }

    /**
     * <b>Method that Brings the selected shape on top of all the others</b>
     * @param event 
     */
    @FXML
    private void BringToFrontOnAction(ActionEvent event) {
        if (selectedShape != null) {
            this.selectedShape.toFront();  // Node's class method that brings the node 
                                            // on which the function in invoked on on top of its siblings 
        }
    }
    
    @FXML
    private void sizeColorOnMouseReleased(MouseEvent event) {
        applyTextIntoButton.setFill(Color.BLACK);
    }

    @FXML
    private void sizeColorOnMousePressed(MouseEvent event) {
        applyTextIntoButton.setFill(Color.DODGERBLUE);
    }

    
    
}
