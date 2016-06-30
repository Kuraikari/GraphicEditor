/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author vmadmin
 */
public class Drawing  {
    

    
    //private Figur[] figuren;
static public Vector<Figure> figures = new Vector<>();
static public Graphics g;
static public BufferedImage painting = Paper.paintImage;
static public ArrayList<Color> color;
static public int indexColor = 0;

public int getIndexofColor(ArrayList<Color> color){
    for(Color c : color)
    {
        if (color.size() > -1)
        {
            indexColor = color.indexOf(c);
        }
        else break;
    }
    return indexColor;
}


public void draw(Graphics g) 
{
    Graphics2D g2d = (Graphics2D) g;
    
    
    g2d.create();
        
    for (Figure f: figures)
        {
            
            g2d.setStroke(new BasicStroke(Paper.stroke));
            f.changecolor(g2d, Workspace.color_temp);
           
            
            //f.move(-500, -500);
            
            f.draw(g2d);
	}
}
public Drawing(Vector<Figure> figuren)
{
    this.figures = figuren;
    this.g = g;
    
}

public void addFigures(Figure f)
{
    figures.addElement(f);
}
    



}
