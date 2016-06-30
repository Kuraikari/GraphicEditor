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
public class StubRectangle extends Figure{

    int w;
    int l;
    
    public StubRectangle(int x, int y, Color color) {
        super(x, y, color);
        this.w = 50;
        this.l = 100;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, w, l);
       
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public void changecolor(Graphics g, Color c) {
        
    }

}
