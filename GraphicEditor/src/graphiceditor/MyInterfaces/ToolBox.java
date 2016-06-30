/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor.MyInterfaces;

import graphiceditor.*;

/**
 *
 * @author vmadmin
 */
public class ToolBox implements Tools{
    Drawing drawing;
    int mouse_x, mouse_y;
    
    @Override
    public void delete() 
    {
        
        System.out.println("Deleted");
    }

    @Override
    public void select() 
    {
        System.out.println("Selected");
    }

    @Override
    public void pick() 
    {
        System.out.println("Picked");
    }

    @Override
    public void drag() 
    {
        System.out.println("Dragged");
    }

    
}
