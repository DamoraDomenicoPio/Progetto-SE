/**
 *  Package se.project per la consegna
 */
package se.project;

import commands.DeleteCommand;
import commands.ChangeColorCommand;
import commands.ScaleCommand;
import commands.CopyCommand;
import commands.PasteCommand;
import commands.ObjectToolCommand;
import commands.PasteInPositionCommand;
import commands.AddCommand;
import commands.Invoker;
import commands.GoBackgroundCommand;
import commands.RotateCommand;
import commands.GoFrontCommand;
import commands.CutCommand;
import static java.lang.Math.ceil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import newShapes.NewShape;
import tools.ObjectTool;
import tools.Tool;
import utility.FileManager;
import utility.Clipboard;
import utility.Grid;
import utility.ToolBox; 


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
    
    private double resizeFactor=1;

    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker insideColorPicker;
    
    private double xPressed=0;
    
    private double yPressed=0;
    
    private double xDragged=0;
    
    private double yDragged=0;
    
    private final double width=Screen.getPrimary().getBounds().getWidth();
    
    private final double height=Screen.getPrimary().getBounds().getHeight();
    
    
    
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
    private Button selectButton;
    @FXML
    private AnchorPane anchorPaneGroup;
    
    private Invoker invoker = new Invoker();
    
    private Clipboard clipboard;
    
    private Shape newShape; 
    
    private ObjectTool currentTool; 
    private ToolBox toolBox = new ToolBox(); 
    private double rotationAngle;
    
    @FXML
    private ImageView cursorIntoSelectionButton;
    private Pane paneGrid;
    
    private boolean gridStatus = false;
    @FXML
    private Slider sliderRotate;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Group zoomGroup;
    @FXML
    private Group contentGroup;
    private GridPane gridPane;
    
    private int gridIndex = 2; 
    
    @FXML
    private VBox gridSmall;
    @FXML
    private GridPane grid1;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid3;
    @FXML
    private GridPane grid4;
    @FXML
    private GridPane grid5;
    private Grid grid;
    
    GridPane grids[] = new GridPane[5];
    
    private int nColumns = 14; 
    private int nRows = 8;
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.anchorPaneGroup.setMaxSize(width, height);
        this.anchorPaneGroup.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        //this.anchorPaneGroup.setStyle("-fx-background-color: #ffffff");
        
        this.clipboard = new Clipboard(group); 
        
        scrollPane.setContent(contentGroup);
        // grid = new Grid(anchorPaneGroup);
        
        GridPane griglia = new GridPane();
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            griglia.getColumnConstraints().add(column);
        }
        anchorPaneGroup.getChildren().add(griglia); 
        griglia.setGridLinesVisible(true);
        
//        grid3.setGridLinesVisible(true);
//        grid1.setOpacity(0.3); 
//        grid2.setOpacity(0.3); 
//        grid3.setOpacity(0.3); 
//        grid4.setOpacity(0.3); 
//        grid5.setOpacity(0.3); 
//        
//        
//        grids[0] = grid1;
//        grids[1] = grid2; 
//        grids[2] = grid3; 
//        grids[3] = grid4; 
//        grids[4] = grid5; 
        
    }    
    
    
    private GridPane createGrid(int nCols, int nRows) {
        System.out.println("Creando una nuova griglia...");
        GridPane gridpane = new GridPane(); 
        
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gridpane.getColumnConstraints().add(column);
        }
        return gridpane; 
    }
//        GridPane newGrid = new GridPane(); 
//        System.out.println("Nuova griglia creata"+newGrid.getClass());
//        for(int i=0; i<nCols; i++) {
//            ColumnConstraints column = new ColumnConstraints(); 
//            column.setPercentWidth(100/nCols);
//            newGrid.getColumnConstraints().add(column);
//        }
//        System.out.println("colonne ok");
//        for(int i=0; i<nRows; i++) {
//            System.out.println("Nuova riga");
//            RowConstraints row = new RowConstraints(); 
//            row.setPercentHeight(100/nRows);
//            newGrid.getRowConstraints().add(row);
//        }
//        System.out.println("righe ok");
//        System.out.println("Nuova griglia creata"+newGrid.getClass());
//        newGrid.setOpacity(0.3);
//        return newGrid; 
//    }
    
    /**
    *
    * Method that allows saving the drawing sheet inside a file. 
    * Clicking the 'Save' button opens a selection window in which the user can select a file (.txt) and 
    * choose it as the destination for saving.
    * @param event ActionEvent object generated when the 'Save' button is clicked. 
    */
    @FXML
    private void saveOnAction (ActionEvent event){
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
        this.resizeFactor=1;
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
     * Method that allows to perform actions that require released the mouse
     * @param event MouseEvent object generate when the mouse is released 
     */
    @FXML
    private void groupOnMouseReleased(MouseEvent event) {
        if(this.actionToDo.equalsIgnoreCase("ADD")){
            this.selectedShape=null;
            invoker.execute(new AddCommand(group, borderColorPicker.getValue(), insideColorPicker.getValue(), this.newShape));
        }
        else if (! this.actionToDo.equalsIgnoreCase("SELECT")) { 
            if (currentTool != null) {
            invoker.execute(new ObjectToolCommand(xPressed, yPressed, event.getX(), event.getY(), currentTool, selectedShape));
            }
        }
    }
    /**
     * Method that allows to perform actions that require dragging the mouse
     * @param event MouseEvent object generate when dragging the mouse
     */
    @FXML
    private void groupOnMouseDragged(MouseEvent event) {
        if(this.selectedShape!=null){
            currentTool = this.toolBox.getObjectTool(actionToDo);
            if(currentTool !=null){
                currentTool.setShape(selectedShape);
                //selectedShape= objectTool.setEndPoint(this.xDragged, this.yDragged);
                selectedShape= currentTool.setEndPoint(event.getX(), event.getY());
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
            Tool shapeTool= toolBox.getShapeTool(shapeToInsert);
            shapeTool.setStartPoint(xPressed, yPressed);
            Shape shape= shapeTool.setEndPoint(event.getX(), event.getY());
            group.getChildren().add(shape);
            shape.getStrokeDashArray().add(10d);
            shape.setStroke(new Color(0, 0, 0, 1));
            shape.setFill(new Color(1, 1, 1, 1));
            this.newShape = shape; 
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
                this.sliderRotate.setValue(((NewShape) selectedShape).getRotationAngle());
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
        invoker.execute(new CopyCommand(clipboard, selectedShape));
    }
    
    /**
     * Method that allows to paste a copied or cutted object on the drawing sheet.
     * @param event ActionEvent object generated when the button 'Paste' is selected.
     */
    @FXML
    private void pasteOnAction(ActionEvent event) {
        invoker.execute(new PasteCommand(group, clipboard));
    }
    
    /**
     * Method that allows to change the color inside the selected shape and its border, by using 
     * the two colorPicker on the window.
     * @param event ActionEvent object generated when the button 'Change Color' is selected.
     */
    @FXML
    private void changeColorShape(ActionEvent event) {
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

//    /**
//     * Method that allows to delete a selected object on the drawing sheet.
//     */
//    private void deleteSelected() {
//        if(selectedShape!=null){
//            group.getChildren().remove(selectedShape);
//            selectedShape=null;
//        }
//    }
    
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

//    /**
//     * Method that allows to copy a selected object on the drawing sheet.
//     */
//    private void copySelected() {
//    if (this.selectedShape != null) { // If a shape has been selected
//            this.copiedShape = this.selectedShape.toString();  // Copies the selected shape
//        }
//        // If nothing was selected, nothig gets copied 
//    }
    
    /**
     * Method that changes the shapeToInsert string to the string "MOVE".
     * @param event ActionEvent object generated when the button 'Move' is selected.
     */
    @FXML
    private void moveOnAction(ActionEvent event) {
        actionToDo="MOVE";
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
            invoker.execute(new GoFrontCommand(group, selectedShape));
        }
    }
    
    /**
     * Method that brings the selected shape behind all the other shapes 
     * @param event 
     */
    @FXML
    private void BringToBackOnAction(ActionEvent event) {
        if (selectedShape != null) {
            invoker.execute(new GoBackgroundCommand(group, selectedShape));
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
        
        Scale scale = new Scale(0.9, 0.9, 0, 0); 
        zoomGroup.getTransforms().add(scale);
    }

    @FXML
    private void zoomOutOnMousePressed(MouseEvent event) {
    }

    @FXML
    private void zoomInOnMouseReleased(MouseEvent event) {
    }

    @FXML
    private void zoomInOnAction(ActionEvent event) {
        
        Scale scale = new Scale(1.1, 1.1, 0, 0); 
        zoomGroup.getTransforms().add(scale); 
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


    private void pasteOnActionContextMenu(ActionEvent event) {
        invoker.execute(new PasteInPositionCommand(group, clipboard, xPressed, yPressed));
    }

//    private void gridButtonOnAction(ActionEvent event) {
//        
//        ColumnConstraints column = new ColumnConstraints();
//        gridPane.getColumnConstraints().add(column); 
//        for(ColumnConstraints col : gridPane.getColumnConstraints()) {
//            col.setPercentWidth(100/(nGrid)); 
//        }
//        
//        RowConstraints row = new RowConstraints();
//        gridPane.getRowConstraints().add(row);
//        for(RowConstraints r : gridPane.getRowConstraints()) {
//            r.setPercentHeight(100/(nGrid));
//        }
//        
//        nGrid++;
//        
//        System.out.println("Nuova grid "+nGrid);
//    }

    @FXML
    private void rotateSliderOnMouseDragged(MouseEvent event) {
        this.rotationAngle =this.sliderRotate.getValue();  // /100*360
        if(this.selectedShape!=null){
            ((NewShape)this.selectedShape).rotate(rotationAngle);
        }
        
    }

    @FXML
    private void rotateSliderOnMouseReleased(MouseEvent event) {
        this.rotationAngle =this.sliderRotate.getValue();
        invoker.execute(new RotateCommand(((NewShape) selectedShape), this.rotationAngle));
    }

    @FXML
    private void gridBiggerOnAction(ActionEvent event) {
        
        // grid.getBigger(); 
        
        if (gridIndex < 4) {
            gridIndex++; 
            System.out.println("Smaller squares"+gridIndex);
            grids[gridIndex-1].setGridLinesVisible(false); 
            grids[gridIndex].setGridLinesVisible(true); 
        }
    }
        
//        nColumns++;
//        for(ColumnConstraints col : grid3.getColumnConstraints()) {
//            col.setPercentWidth(100/(nColumns)); 
//        }
//        ColumnConstraints column = new ColumnConstraints();
//        column.setPercentWidth(ceil(100/(nColumns))); 
//        grid3.getColumnConstraints().add(column); 
//        
//        
//        
//        nRows++;
//        for(RowConstraints r : grid3.getRowConstraints()) {
//            r.setPercentHeight(100/(nRows));
//        }
//        RowConstraints row = new RowConstraints();
//        row.setPercentHeight(ceil(100/(nRows)));
//        grid3.getRowConstraints().add(row);
//        
//    }

    @FXML
    private void gridSmallerOnAction(ActionEvent event) {
        
//        grid.getSmaller(); 
        
        if (gridIndex > 0) {
            gridIndex--;
            System.out.println("Bigger squares" + gridIndex);
            grids[gridIndex+1].setGridLinesVisible(false); 
            grids[gridIndex].setGridLinesVisible(true); 
        }
    }
    
        
//        System.out.println("Decremento");
//        nColumns--;
//        // ColumnConstraints column = new ColumnConstraints();
//        // gridPane.getColumnConstraints().add(column); 
//        for(ColumnConstraints col : grid1.getColumnConstraints()) {
//            col.setPercentWidth(100/(nColumns)); 
//        }
//        
//        nRows--;
//        // RowConstraints row = new RowConstraints();
//        // gridPane.getRowConstraints().add(row);
//        for(RowConstraints r : grid1.getRowConstraints()) {
//            r.setPercentHeight(100/(nRows));
//        }
        
        
        
    
    
    
    
    
    
}