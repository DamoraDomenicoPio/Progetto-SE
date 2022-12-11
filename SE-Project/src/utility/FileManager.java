/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import newShapes.*;


/**
 * Implementation of the pattern factory method for the creation of the shapes
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca
 */
public class FileManager {
    
    /**
    *
    * Method that allows loading a drawing sheet saved inside a file. 
    * Clicking the 'Load' button opens a selection window in which the user can select a file (.txt) 
    * in which a drawing sheet is saved. 
    * Once the file has been chosen, the drawing sheet is loaded.
    * @param group Group on which add the shapes 
    */
    public static void loadFile(Group group) {
        FileChooser fileChooser = new FileChooser();
        try(Scanner i=new Scanner(new BufferedReader(new FileReader(fileChooser.showOpenDialog(null).getPath())))){
            group.getChildren().clear();
            i.useLocale(Locale.US);
            i.useDelimiter("\n");
            while(i.hasNext()){
                String shapeString=i.next();
                Shape s= NewShape.stringToShape(shapeString);
                group.getChildren().add(s);
            }
        } catch (Exception ex) {
        }
    }
    
    /**
    *
    * Method that allows saving the drawing sheet inside a file. 
    * Clicking the 'Save' button opens a selection window in which the user can select a file (.txt) and 
    * choose it as the destination for saving.
    * @param group Group that contains the shapes to be saved
    */
    public static void saveFile(Group group) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
         new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        try(PrintWriter o=new PrintWriter(new BufferedWriter(new FileWriter(fileChooser.showSaveDialog(null).getPath())))){
            for(Node i: group.getChildren()){
                Shape s=(Shape) i;
                o.write(s.toString()+"\n");
            }
        } catch (Exception ex) {
        }
    }

}
