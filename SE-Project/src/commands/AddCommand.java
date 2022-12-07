/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;
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
    
    private Group group;
    private Paint borderColor, insideColor; 
    private Shape newShape; 

    public AddCommand(Group group, Paint borderColor, Paint insideColor, Shape newShape) {
        this.group = group;
        this.borderColor = borderColor;
        this.insideColor = insideColor;
        this.newShape = newShape;
    }

    
    
    @Override
    public void execute() {
        this.newShape.getStrokeDashArray().add(0d);  // Replaces the dotted line with a continuous 
        this.newShape.setStroke(this.borderColor);
        this.newShape.setFill(this.insideColor);
    }

    @Override
    public void undo() {
        this.group.getChildren().remove(this.newShape);  // Deletes the added shape 
    }
    
}
