/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import java.awt.*;

/**
 *
 * @author vmadmin
 */
public abstract class Figure{
    int x;
    int y;
    Color color;
    
    Figure(int x, int y, Color color)
    {
        this.x = x; this.y = y;
        this.color = color;
    }
    
    
    
    public abstract void draw(Graphics g);
    public abstract void move(int deltaX, int deltaY);
    public abstract void changecolor(Graphics g, Color c);
}
