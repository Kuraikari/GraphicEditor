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
public class Line extends Figure {
int x1;
int y1;
int l;

	public Line(int x, int y, Color color ,int x1 , int y1) 
        {
		super(x, y, color);
		this.x1 = x1;
		this.y1 = y1;
	}

    /**
     *
     * @param g
     */
        
        Graphics g;
        
    @Override
	public void draw(Graphics g) {
	    g.drawLine(x, y, x1, y1);
	  }

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
