/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author vmadmin
 */
public class Brush extends Figure
{
    private Vector<Point> p = new Vector<Point>();

            
    
    public Brush(int x, int y, Color color ,Vector<Point> p) {
        super(x, y, color);
        this.p = (Vector<Point>) p;
 
    }

        

    @Override
    public void draw(Graphics g) {
       Graphics2D g2d = (Graphics2D)g;
            for (int i = 0; i < p.size() - 1; i++)
            {
                Point p1 = p.get(i);
                Point p2 = p.get(i + 1);

                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
            
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
