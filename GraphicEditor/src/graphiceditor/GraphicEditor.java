/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import graphiceditor.MyInterfaces.ToolBox;
import java.awt.Color;
import java.util.*;


/**
 *
 * @author vmadmin
 */
@SuppressWarnings("serial")
public class GraphicEditor 
{
    
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int i = 20;
        // TODO code application logic here
        
        Vector<Figure> list = new Vector<Figure>();
		
		Rectangle r = new Rectangle(0, 10,Color.WHITE,10, 10);
		list.add(r);
		Circle  k = new Circle(5,10,Color.WHITE,5);
		list.add(k);
		Line  l = new Line(10,10,Color.WHITE,10,10);
		list.add(l);
                
                StubRectangle sut = new StubRectangle(40, 40, Color.BLACK);
                list.add(sut);
                
		Drawing z;
                z = new Drawing(list);
		Figure    f;
                
                ToolBox tb = new ToolBox();
                tb.delete();
                tb.select();
      
        
                
        Workspace space = new Workspace();
	//z.addFigures(new Rectangle(100, 100, 200, 300));
        Workspace.init_prog();
	space.show(z);
              
    }
    
}




