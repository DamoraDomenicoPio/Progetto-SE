/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

/**
 * Interface that represents a command.
 @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public interface Command {
    
    /**
     * Method that allows you to execute the command
     */
    public void execute(); 
    /**
     * Method that allows you to undo the command
     */
    public void undo(); 
}
