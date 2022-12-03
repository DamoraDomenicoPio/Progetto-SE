/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;
import javafx.scene.Group;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import tools.MoveTool;
import tools.Tool;

/**
 *
 * @author gianl
 */
public class AddCommand implements Command{
    
    private Shape addedShape;
    private Group group;
    private Paint borderColor, insideColor; 
    private int startX, startY, endX, endY; 
    private Tool shapeTool; 

    public AddCommand(Shape addedShape, Group group, Paint borderColor, Paint insideColor, int startX, int startY, int endX, int endY, Tool shapeTool) {
        this.addedShape = addedShape;
        this.group = group;
        this.borderColor = borderColor;
        this.insideColor = insideColor;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.shapeTool = shapeTool;
    }
    
    @Override
    public void execute() {
        this.shapeTool.setStartPoint(startX, startY); 
        
        this.addedShape = shapeTool.setEndPoint(endX, endY);
        addedShape.setStroke(this.borderColor);
        addedShape.setFill(this.insideColor);
        group.getChildren().add(addedShape);
    }

    @Override
    public void undo() {
        group.getChildren().remove(addedShape);
        
    }
    
}
