/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author vmadmin
 */
public class Circle extends Figure {
    int r;
    
    Circle(int x, int y, Color color , int r)
    {
        super(x, y, color);
        this.r = r;
    }
    
    @Override
    public void draw(Graphics g) 
    {
	    g.drawOval(x-r, y-r, r*2, r*2);
    }

    Graphics g;
    
    @Override
    public void changecolor(Graphics g, Color c) {
        this.color = c;
        g.setColor(c);
    }

    @Override
    public void move(int deltaX, int deltaY) {
       x += deltaX;
       y += deltaY; 
    }
    
    
}
