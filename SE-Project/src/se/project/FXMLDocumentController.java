/**
 *  Package se.project per la consegna
 */
package se.project;

import command.*;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
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
import javafx.stage.FileChooser.ExtensionFilter;
import newShapes.NewShape;
import tools.ObjectTool;
import tools.Tool;
import tools.ShapeFactory;
import utility.Clipboard;


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
    private String actionToDo="";
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
    @FXML
    private Text zoomOutInButton;
    @FXML
    private Text zoomInInButton;
    @FXML
    private MenuItem selectButton;
    
    private Invoker invoker = new Invoker(); 
    private Clipboard clipboard; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.clipboard = new Clipboard(group); 
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
        fileChooser.getExtensionFilters().add(
         new ExtensionFilter("Text Files", "*.txt")
        );
        try(PrintWriter o=new PrintWriter(new BufferedWriter(new FileWriter(fileChooser.showSaveDialog(null).getPath())))){
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
        this.actionToDo="ADD";
    }
    
    /**
     * Method which, after having chosen the 'Rectangle' shape within the application,
     * modifies the string ShapeToinsert with the value "Rectangle".
     * @param event ActionEvent object generated when Rectangle shape is selected.
     */
    @FXML
    private void addRectangle(ActionEvent event) {
        shapeToInsert="Rectangle";
        this.actionToDo="ADD";
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
        this.actionToDo="ADD";
        lineIntoButton.setStroke(borderColorPicker.getValue());
    }
    
    /**
     * Method that allows to perform actions that require released the mouse
     * @param event MouseEvent object generate when the mouse is released 
     */
    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        if(this.actionToDo.equalsIgnoreCase("ADD")){
            this.selectedShape=null;
        }
    }
    /**
     * Method that allows to perform actions that require dragging the mouse
     * @param event MouseEvent object generate when dragging the mouse
     */
    @FXML
    private void groupOnMouseDragged(MouseEvent event) {
        if(this.selectedShape!=null){
            Tool shapeTool= ShapeFactory.getShape(actionToDo);
            if(shapeTool!=null){
                ((ObjectTool) shapeTool).setShape(selectedShape);
                selectedShape= shapeTool.setEndPoint(event.getX(), event.getY());
            }          
        }      
    }

    /**
     * Method that allows to perform actions that require pressed the mouse
     * @param event MouseEvent object generate when pressed the mouse button
     */
    @FXML
    private void groupOnMousePressed(MouseEvent event) {
        xPressed=event.getX();
        yPressed=event.getY();
        System.out.println(this.actionToDo);
        if(this.actionToDo.equalsIgnoreCase("ADD")){
            if(this.selectedShape!=null){
                this.selectedShape.setEffect(null);
            }
            Tool shapeTool= ShapeFactory.getShape(shapeToInsert);
            shapeTool.setStartPoint(xPressed, yPressed);
            Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
            shape.setStroke(borderColorPicker.getValue());
            shape.setFill(insideColorPicker.getValue());
            group.getChildren().add(shape);
            //((ObjectTool) shapeTool).setShape(selectedShape);
            //shape= shapeTool.setEndPoint(event.getX(), event.getY());
            this.selectedShape=shape;
        }
        else if(this.actionToDo.equalsIgnoreCase("SELECT")){
            if(this.selectedShape!=null){
                this.selectedShape.setEffect(null);
            }
            if(event.getTarget() instanceof Shape){
                this.selectedShape=(Shape) event.getTarget();
                DropShadow s= new DropShadow(20.0, Color.BLACK);
                s.setSpread(0.3);
                selectedShape.setEffect(s);
            }
            else{
                this.selectedShape=null;
            }
        }
        
    }
    
    /**
     * Method that invokes the copySelected() method.
     * @param event ActionEvent object generated when the button 'Copy' is selected.
     */
    @FXML
    private void copyOnAction(ActionEvent event) {
        // clipboard.copy(selectedShape);
        invoker.execute(new CopyCommand(clipboard, selectedShape));
    }
    
    /**
     * Method that allows to paste a copied or cutted object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Paste' is selected.
     */
    @FXML
    private void pasteOnAction(ActionEvent event) {
        // paste(selectedShape);
        // clipboard.incolla(selectedShape);
        // clipboard.paste(); 
        invoker.execute(new PasteCommand(group, clipboard));
    }
    
    /**
     * Method that allows to change the color inside the selected shape and its border, by using 
     * the two colorPicker on the window.
     * @param event ActionEvent object generated when the button 'Change Color' is selected.
     */
    @FXML
    private void changeColorShape(ActionEvent event) {
        System.out.println("cambio colore");
        invoker.execute(new ChangeColorCommand(selectedShape, borderColorPicker.getValue(), insideColorPicker.getValue()));
    }
    
    /**
     * Method that invokes the deleteSelected() method.
     * @param event ActionEvent object generated when the button 'Delete' is selected.
     */
    @FXML
    private void deleteOnAction(ActionEvent event) {
        invoker.execute(new DeleteCommand(group, selectedShape));
    }
    
    /**
     * Method that allows to cut a selected object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Cut' is selected.
     */
    @FXML
    private void cutOnAction(ActionEvent event) {
        // clipboard.cut(selectedShape);
        invoker.execute(new CutCommand(clipboard, selectedShape));
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
    
    /**
     * Method that allows to change size of a selected shape on the drawing sheet.
     * @param event MouseEvent object generated when the button 'apply' is pressed.
     */
    @FXML
    private void changeShapeSize(MouseEvent event) {
        try{
            double size= Double.parseDouble(shapeSize.getText());
            if(size<0)
                shapeSize.setText("1");
            else{
                ((NewShape) this.selectedShape).newResize(size);
            }
        } catch (Exception e){
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
        actionToDo="MOVE";
    }
    
    /**
     * Method that inserts the border color of the figure
     * @param event ActionEvent object generated when a color is selected and a shaps is created.
     */
    @FXML
    private void borderColorSelected(ActionEvent event) {
        ellipseIntoButton.setStroke(borderColorPicker.getValue());
        rectangleIntoButton.setStroke(borderColorPicker.getValue());
        lineIntoButton.setStroke(borderColorPicker.getValue());
    }
    /**
     * Method that inserts the inside color of the figure
     * @param event ActionEvent object generated when a color is selected and a shaps is created.
     */
    @FXML
    private void insideColorSelected(ActionEvent event) {
        ellipseIntoButton.setFill(insideColorPicker.getValue());
        rectangleIntoButton.setFill(insideColorPicker.getValue());
    }
    
    /**
     * Method that allows to select a figure
     * @param event ActionEvent object generated when a button select is pressed.
     */
    @FXML
    private void onSelectionButtonPressed(ActionEvent event) {
        if(selectionButtonStatus == false){
            selectionButtonStatus = true;
            polygonIntoSelectionButton.setStroke(Color.DODGERBLUE);
            polygonIntoSelectionButton.setFill(Color.DODGERBLUE);
            this.actionToDo="SELECT";
        }else{
            selectionButtonStatus = false;
            polygonIntoSelectionButton.setStroke(Color.rgb(191, 191, 191));
            polygonIntoSelectionButton.setFill(Color.rgb(191, 191, 191));   
            this.actionToDo="";
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
        invoker.undo();
    }

    /**
     * Method that Brings the selected shape on top of all the others
     * @param event 
     */
    @FXML
    private void BringToFrontOnAction(ActionEvent event) {
        if (selectedShape != null) {
            this.selectedShape.toFront();  // Node's class method that brings the node 
                                            // on which the function in invoked on on top of its siblings 
        }
    }
    
    /**
     * Method that brings the selected shape behind all the other shapes 
     * @param event 
     */
    @FXML
    private void BringToBackOnAction(ActionEvent event) {
        if (selectedShape != null) {
            this.selectedShape.toBack();  // Node's class method that brings the node on which 
                                          // the method it's been called behind all its siblings 
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

    @FXML
    private void zoomOutOnMouseReleased(MouseEvent event) {
    }

    @FXML
    private void zoomOutOnAction(ActionEvent event) {
        group.setScaleX(0.3);
        group.setScaleY(0.3);
    }

    @FXML
    private void zoomOutOnMousePressed(MouseEvent event) {
    }

    @FXML
    private void zoomInOnMouseReleased(MouseEvent event) {
    }

    @FXML
    private void zoomInOnAction(ActionEvent event) {
        group.setScaleX(2);
        group.setScaleY(2);
    }

    @FXML
    private void zoomInOnMousePressed(MouseEvent event) {
    }

    @FXML
    /**
     * Method that changes the shapeToInsert string to the string "SELECT".
     * @param event ActionEvent object generated when the button 'Select' is selected.
     */
    private void selectOnAction(ActionEvent event) {
        this.actionToDo="SELECT";
    }
    
    /**
     * Method that changes the shapeToInsert string to the string "STRETCH".
     * @param event ActionEvent object generated when the button 'Stretch' is selected.
     */
    @FXML
    private void stretchOnAction(ActionEvent event) {
        this.actionToDo="STRETCH";
    }

    

    
    
}
