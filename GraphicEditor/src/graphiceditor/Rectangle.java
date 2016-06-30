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
public class Rectangle extends Figure{
    int w;
    int l;
    
   Rectangle(int x, int y, Color color ,int w, int l)
    {
        super(x, y, color);
        this.w = w;
        this.l = l;
    }
    
    
    Graphics g;
    
    @Override
    public void draw(Graphics g)
    {
        g.drawRect(x, y, w, l);
    }

    @Override
    public void changecolor(Graphics g, Color c) {
       super.color = c;
       g.setColor(c);
    }
    
    @Override
    public void move(int deltaX, int deltaY) {
       x += deltaX;
       y += deltaY;
    }
}
