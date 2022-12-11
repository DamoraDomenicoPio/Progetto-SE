/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Class that allows you to execute commands.
 * @author Cuomo Ferdinando, D'Amora Domenico Pio, Della Porta Assunta, Galasso Gianluca.
*/
public class Invoker {
    
    private Deque<Command> actionsStack;
    
    /**
     * Creates a new instance of Invoker
     */
    public Invoker(){
        actionsStack = new ArrayDeque<>();
    }
    
    /**
     * Method that allows you to execute the command
     */
    public void execute(Command command){
        actionsStack.addLast(command);
        command.execute();
    }
    
    /**
     * Method that allows you to undo the command
     */
    public void undo(){
        if(! this.actionsStack.isEmpty()) {
            Command last = actionsStack.removeLast();
            last.undo();
        }
    }
    

}
