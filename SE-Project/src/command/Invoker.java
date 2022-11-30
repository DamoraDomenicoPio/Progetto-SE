/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author gianl
 */
public class Invoker {
    
    private Deque<Command> actionsStack;
    
    public Invoker(){
        actionsStack = new ArrayDeque<>();
    }
    
    public void execute(Command command){
        actionsStack.addLast(command);
        command.execute();
    }
    
    public void undo(){
        Command last = actionsStack.removeLast();
        last.undo();
    }
    

}
