/**
 *  Package se.project per la consegna
 */
package se.project;

import commands.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import newShapes.PolygonAdapter;
import newShapes.NewShape;
import tools.ObjectTool;
import tools.Tool;
import utility.*;


/**
 * The FXMLDocumentController class is the application controller.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca 
 * 
 */
public class FXMLDocumentController implements Initializable {
    private Invoker invoker = new Invoker();
    private Clipboard clipboard;
    private Shape newShape;
    private ObjectTool currentTool; 
    private ToolBox toolBox = new ToolBox(); 
    private double rotationAngle;
    private int numberSide=0;
    private ArrayList<Double> sides= new ArrayList<>();
    private Polyline polyline;
    private Shape selectedShape = null; 
    private double xPressed=0;
    private double yPressed=0;
    private final double width=Screen.getPrimary().getBounds().getWidth();
    private final double height=Screen.getPrimary().getBounds().getHeight();
    private String shapeToInsert="";
    private String actionToDo="";
    private GridManager gridManager; 
    
    @FXML
    private Group group;
    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker insideColorPicker;
    @FXML
    private TextField shapeSize;
    @FXML
    private Line lineIntoButton;
    @FXML
    private Rectangle rectangleIntoButton;
    @FXML
    private Ellipse ellipseIntoButton;
    @FXML
    private Text arrowIntoUndoButton;
    @FXML
    private Text applyTextIntoButton;
    @FXML
    private AnchorPane anchorPaneGroup;
    @FXML
    private Slider sliderRotate;
    @FXML
    private TextField nSidesPolygonTextField;
    @FXML
    private TextField addTextTextField;
    @FXML
    private Group contentGroup;
    @FXML
    private Group zoomGroup;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane grid3;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid1;
    @FXML
    private GridPane grid0;
    @FXML
    private GridPane grid4;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.anchorPaneGroup.setMaxSize(width, height);
        this.anchorPaneGroup.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        this.clipboard = new Clipboard(group); 
        this.scrollPane.setContent(contentGroup); 
        GridPane gridArray[] = new GridPane[5];
        gridArray[0] = grid0; 
        gridArray[1] = grid1; 
        gridArray[2] = grid2; 
        gridArray[3] = grid3; 
        gridArray[4] = grid4;
        this.gridManager = new GridManager(gridArray); 
        this.actionToDo = "ADD"; 
        this.shapeToInsert = "LINE";
        
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
        this.removePolyline();
        FileManager.saveFile(group);
        
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
        this.anchorPaneGroup.setMaxSize(width, height);
        this.anchorPaneGroup.setMinSize(width, height);
        FileManager.loadFile(group);
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
     * Method that allows you to add text
     * @param event ActionEvent object generated when the button Add is clicked
     */
    @FXML
    private void addTextOnAction(ActionEvent event) {
        shapeToInsert="Text";
        this.actionToDo="ADD";
    }
    
    /**
     * Method that allows you to create an arbitrary polygon
     * @param event ActionEvent object generated when the button Create is clicked
     */
    @FXML
    private void createPolygonOnAction(ActionEvent event) {
        try{
            int sides= Integer.parseInt(this.nSidesPolygonTextField.getText());
            if(sides<=0)
                nSidesPolygonTextField.setText("0");
            else{
                this.shapeToInsert="POLYGON";
                this.actionToDo="CREATEPOLYGON";
                if(this.selectedShape!=null){
                    this.selectedShape.setEffect(null);
                    selectedShape=null;
                }
                
                this.numberSide=sides;
                polyline=new Polyline();
                group.getChildren().add(polyline);
            }
        } catch (Exception e){
          }
    }
    
    /**
     * Method that allows to perform actions that require released the mouse
     * @param event MouseEvent object generate when the mouse is released 
     */
    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        if(event.getButton()==MouseButton.PRIMARY){
            if(this.actionToDo.equalsIgnoreCase("ADD") ){
                this.selectedShape=null;
                invoker.execute(new AddCommand(group, borderColorPicker.getValue(), insideColorPicker.getValue(), this.newShape));
                this.newShape=null;
                if(this.shapeToInsert.equalsIgnoreCase("POLYGON")){
                    shapeToInsert="";
                    actionToDo="";
                }
            }
            else if (! this.actionToDo.equalsIgnoreCase("SELECT") && ! this.actionToDo.equalsIgnoreCase("CREATEPOLYGON")) { 
                if (currentTool != null) {
                invoker.execute(new ObjectToolCommand(xPressed, yPressed, event.getX(), event.getY(), currentTool, selectedShape));
                }
            }
            if(this.actionToDo.equalsIgnoreCase("CREATEPOLYGON")){
                this.selectedShape=null;
                this.shapeToInsert="POLYGON";
                if(this.numberSide<=this.sides.size()/2+1){
                    this.actionToDo="ADD";
                    
                }
            }
        }
    }
    
    /**
     * Method that allows to perform actions that require dragging the mouse
     * @param event MouseEvent object generate when dragging the mouse
     */
    @FXML
    private void groupOnMouseDragged(MouseEvent event) {
        if(event.isPrimaryButtonDown()){
            
            if(this.selectedShape!=null){
                currentTool = this.toolBox.getObjectTool(actionToDo);
                if(currentTool !=null){
                    currentTool.setShape(selectedShape);
                    selectedShape= currentTool.setEndPoint(event.getX(), event.getY());
                }          
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
        if(event.isPrimaryButtonDown()){
            if(this.actionToDo.equalsIgnoreCase("ADD")){
                if(this.selectedShape!=null){
                    this.selectedShape.setEffect(null);
                }
                if(this.shapeToInsert.equalsIgnoreCase("TEXT")){
                   toolBox.setText(this.addTextTextField.getText());

                }
                if(this.shapeToInsert.equalsIgnoreCase("POLYGON")){
                   toolBox.setList(sides);
                   this.numberSide=0;
                   this.nSidesPolygonTextField.setText("0");
                   
                }
                this.sides.clear();
                Tool shapeTool= toolBox.getShapeTool(shapeToInsert);
                shapeTool.setStartPoint(xPressed, yPressed);
                Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
                group.getChildren().add(shape);
                shape.getStrokeDashArray().add(10d);
                shape.setStroke(new Color(0, 0, 0, 1));
                shape.setFill(new Color(1, 1, 1, 1));
                this.newShape = shape;
                this.selectedShape=shape;
            }
            else if(this.actionToDo.equalsIgnoreCase("SELECT")){
                this.sides.clear();
                if(this.selectedShape!=null){
                    this.selectedShape.setEffect(null);
                }
                if(event.getTarget() instanceof Shape){
                    this.selectedShape=(Shape) event.getTarget();
                    DropShadow s= new DropShadow(20.0, Color.BLACK);
                    s.setSpread(0.3);
                    selectedShape.setEffect(s);
                    this.sliderRotate.setValue(((NewShape) selectedShape).getRotationAngle());
                }
                else{
                    this.selectedShape=null;
                }
            }
            else if(this.actionToDo.equalsIgnoreCase("CREATEPOLYGON")){
                if(this.selectedShape!=null){
                    this.selectedShape.setEffect(null);
                }
                this.sides.add(xPressed);
                this.sides.add(yPressed);
                polyline.getPoints().add(xPressed);
                polyline.getPoints().add(yPressed);
            }
            if(!this.actionToDo.equalsIgnoreCase("CREATEPOLYGON")){
                this.group.getChildren().remove(polyline);
                polyline=null;
                sides.clear();
            }
        }
    }
    
    /**
     * Method that invokes the copySelected() method.
     * @param event ActionEvent object generated when the button 'Copy' is selected.
     */
    @FXML
    private void copyOnAction(ActionEvent event) {
        if(selectedShape!=null){
            invoker.execute(new CopyCommand(clipboard, selectedShape));
        }
        
    }
    
    /**
     * Method that allows to paste a copied or cutted object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Paste' is selected.
     */
    @FXML
    private void pasteOnAction(ActionEvent event) {
        removePolyline();
        invoker.execute(new PasteCommand(group, clipboard));
    }
    
    /**
     * Method that allows to change the color inside the selected shape and its border, by using 
     * the two colorPicker on the window.
     * @param event ActionEvent object generated when the button 'Change Color' is selected.
     */
    @FXML
    private void changeColorShape(ActionEvent event) {
        if(selectedShape!=null){
            invoker.execute(new ChangeColorCommand(selectedShape, borderColorPicker.getValue(), insideColorPicker.getValue()));
        }
    }
    
    /**
     * Method that invokes the deleteSelected() method.
     * @param event ActionEvent object generated when the button 'Delete' is selected.
     */
    @FXML
    private void deleteOnAction(ActionEvent event) {
        if(selectedShape!=null){
            invoker.execute(new DeleteCommand(group, selectedShape));
        }
    }
    
    /**
     * Method that allows to cut a selected object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Cut' is selected.
     */
    @FXML
    private void cutOnAction(ActionEvent event) {
        if(selectedShape!=null){
            invoker.execute(new CutCommand(clipboard, selectedShape));
        }
    }
    
    /**
     * Method that allows to change size of a selected shape on the drawing sheet.
     * @param event MouseEvent object generated when the button 'apply' is pressed.
     */
    @FXML
    private void applyScaleOnAction(ActionEvent event){
        try{
            double size= Double.parseDouble(shapeSize.getText());
            if(size<0)
                shapeSize.setText("1");
            else{
                invoker.execute(new ScaleCommand(size, selectedShape));
            }
        } catch (Exception e){
        }
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
     * Method that changes the shapeToInsert string to the string "SELECT".
     * @param event ActionEvent object generated when the button 'Select' is selected.
     */
    @FXML
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
    
    /**
     * Method that sets the selected color as border color of the shapes inside the add shape buttons 
     * @param event ActionEvent object generated when a color is selected and a shaps is created.
     */
    
    @FXML
    private void borderColorSelected(ActionEvent event) {
        ellipseIntoButton.setStroke(borderColorPicker.getValue());
        rectangleIntoButton.setStroke(borderColorPicker.getValue());
        lineIntoButton.setStroke(borderColorPicker.getValue());
    }
    
    /**
     * Method that sets the selected color as fill color of the shapes inside the add shape buttons 
     * @param event ActionEvent object generated when a color is selected and a shaps is created.
     */
    @FXML
    private void insideColorSelected(ActionEvent event) {
        ellipseIntoButton.setFill(insideColorPicker.getValue());
        rectangleIntoButton.setFill(insideColorPicker.getValue());
    }
    
    /**
     * Method that colors the arrow in the Undo button
     * @param event MouseEvent object generated when the Undo button is released
     */
    @FXML
    private void undoColorOnMouseReleased(MouseEvent event) {
        arrowIntoUndoButton.setFill(Color.BLACK);
    }

    /**
     * Method that colors the arrow in the Undo button
     * @param event MouseEvent object generated when the Undo button is pressed
     */
    @FXML
    private void undoColorOnMousePressed(MouseEvent event) {
        arrowIntoUndoButton.setFill(Color.DODGERBLUE);
    }

    /**
     * Method that performs the undo
     * @param event ActionEvent object generated When the Undo button is clicked
     */
    @FXML
    private void undoOnAction(ActionEvent event) {
        removePolyline();
        invoker.undo();
    }

    /**
     * Method that Brings the selected shape on top of all the others
     * @param event ActionEvent object generated When the Foreground button is clicked
     */
    @FXML
    private void BringToFrontOnAction(ActionEvent event) {
        if (selectedShape != null) {
            invoker.execute(new GoFrontCommand(group, selectedShape));
        }
    }
    
    /**
     * Method that brings the selected shape behind all the other shapes 
     * @param event ActionEvent object generated When the Background button is clicked
     */
    @FXML
    private void BringToBackOnAction(ActionEvent event) {
        if (selectedShape != null) {
            invoker.execute(new GoBackgroundCommand(group, selectedShape));
        }
    }
    
    /**
     * Method that colors the figure of the Color button
     * @param event MouseEvent object generated when the Color button is released
     */
    @FXML
    private void sizeColorOnMouseReleased(MouseEvent event) {
        applyTextIntoButton.setFill(Color.BLACK);
    }

    /**
     * Method that colors the figure of the Color button
     * @param event MouseEvent object generated when the Color button is pressed
     */
    @FXML
    private void sizeColorOnMousePressed(MouseEvent event) {
        applyTextIntoButton.setFill(Color.DODGERBLUE);
    }

    /**
     * Method that allows you to zoom in the drawing 
     * @param event ActionEvent object generated When the Zoom out button is clicked 
     */
    @FXML
    private void zoomOutOnAction(ActionEvent event) {
        invoker.execute(new ZoomOutCommand(zoomGroup));
    }

    /**
     * Method that allows you to zoom in the drawing
     * @param event ActionEvent object generated When the Zoom in button is clicked 
     */
    @FXML
    private void zoomInOnAction(ActionEvent event) {
        invoker.execute(new ZoomInCommand(zoomGroup));
    }

    /**
     * Method that allows to paste a copied or cutted object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Paste' in the contextMenu is selected.
     */
    @FXML
    private void pasteOnActionContextMenu(ActionEvent event) {
        removePolyline();
        invoker.execute(new PasteInPositionCommand(group, clipboard, xPressed, yPressed));
    }

    /**
     * Method that allows you to show/hide the grid
     * @param event ActionEvent object generated when the button Grid is clicked
     */
    @FXML
    private void gridButtonOnAction(ActionEvent event) {
        invoker.execute(new GridSwitchCommand(gridManager));
    }

    /**
     * Method that allows you to choose the rotation angle
     * @param event ActionEvent object generated when the slider is dragged
     */
    @FXML
    private void rotateSliderOnMouseDragged(MouseEvent event) {
        this.rotationAngle =this.sliderRotate.getValue();  // /100*360
        if(this.selectedShape!=null){
            ((NewShape)this.selectedShape).rotate(rotationAngle);
        }
    }

    /**
     * Method that allows you to choose the rotation angle
     * @param event ActionEvent object generated when the slider is released
     */
    @FXML
    private void rotateSliderOnMouseReleased(MouseEvent event) {
        if(selectedShape!=null){
            this.rotationAngle =this.sliderRotate.getValue();
            invoker.execute(new RotateCommand(((NewShape) selectedShape), this.rotationAngle));
        }
    }

    /**
     * Method that allows you to mirror a figure vertically
     * @param event ActionEvent object generated when the button MirrorVertical is clicked
     */
    @FXML
    private void mirrorVerticalOnAction(ActionEvent event) {
        if(this.selectedShape!=null){
            invoker.execute(new MirrorVerticalCommand((NewShape) selectedShape));
        }
    }

    /**
     * Method that allows you to mirror a figure horizontally
     * @param event ActionEvent object generated when the button MirrorHorizontal is clicked
     */
    @FXML
    private void mirrorHorizontalOnAction(ActionEvent event) {
        if(this.selectedShape!=null){
            invoker.execute(new MirrorHorizontalCommand((NewShape) selectedShape));
        }
    }

    /**
     * Method that allows you to zoom in on the grid
     * @param event ActionEvent object generated when the button Zoom in Grid is clicked
     */
    @FXML
    private void getBiggerGridOnAction(ActionEvent event) {
        invoker.execute(new BiggerGridCommand(gridManager));
    }

    /**
     * Method that allows you to zoom out on the grid
     * @param event ActionEvent object generated when the button Zoom out Grid is clicked
     */
    @FXML
    private void getSmallerGridOnAction(ActionEvent event) {
        invoker.execute(new SmallerGridCommand(gridManager));
    }
    
    /**
     * Method that allows you to remove the polyline
     */
    private void removePolyline(){
        if(polyline!=null){
            this.group.getChildren().remove(polyline);
            polyline=null;
            sides.clear();
            this.actionToDo="";
        }
    }
    
    
    
}
