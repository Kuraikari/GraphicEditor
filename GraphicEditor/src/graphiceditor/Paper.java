/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import graphiceditor.MyInterfaces.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import static java.sql.DriverManager.println;
import javax.swing.JPanel;
import java.util.*;
import javafx.scene.shape.Path;
import javax.imageio.ImageIO;


/**
 *
 * @author vmadmin
 */
@SuppressWarnings("serial")
public class Paper extends JPanel implements MouseListener, KeyListener, MouseMotionListener, Tools{
    
        /**
	 * The Drawing.
	 */
        public static int xI = Workspace.WIDTH;
        public static int yI = Workspace.HEIGHT;
        
        Workspace ws;
        private int index_figure = 0;
        private Figure temp_figure;
        static private Vector<Figure> allFigures;
	private Drawing drawing;
        private Figure brush;
        
        public Vector<CustomPair<Path, Color>> color_list_path = new Vector<CustomPair<Path, Color>>();
        public Path path;
        
        public  static Color colorform;
        public  static int stroke = 1;
        private final Vector<Point> points = new Vector<>();
        private boolean isClicked; 
        public  static BufferedImage paintImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        public static Graphics g;
        
        
        
	public Paper()
        {
  
        this.ws = new Workspace();
            g = paintImage.getGraphics();
            Graphics g2d = g;
            g2d.setColor(new Color(248,248,248));
            g2d.dispose();
                        
            JPanel jp = new JPanel();
            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(this);
            setFocusable(true);
            requestFocus();
        }
        
    /**
     *
     */
    public static char letter = 'd';
    
    char test(char letter)
    {
        
        return 0;
    }
    
        private int x, y;
        
@Override
public void mousePressed(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    
    switch(letter)
    {
        case 'b':
            isClicked = true;
            break;
    }
    // drawing.g.setColor(Color.black);
    // drawing.g.setColor(Color.red);
    //Line line = new Line(x, y, x, y);
    //drawing.addFigures(line);
}

    @Override
    public void mouseDragged(MouseEvent e)
    {   
        
        if(isClicked == true)
        {
            
            repaint();
            points.add(e.getPoint());
            repaint(); //request Swing to refresh display as soon as it cans
        }
        //points.add(e.getPoint());
              
    }


 @Override
 public void mouseMoved(MouseEvent me)
    {
        repaint();
    }


@Override
public void mouseReleased(MouseEvent e) {
    int width = e.getX()  ;
    int length = e.getY() ;
    

    if (x < 0 || y < 0){
        x = -x;
        y = -y;
    }
    
    int diameter = ((width-x)^2)+((length-y)^2);
    int r= (int) Math.sqrt(Math.pow((x-width),2)+Math.pow((y-length),2));
    double pi = Math.PI;
    
   
    
    switch(letter)
    {
    case 'r':
	Rectangle rect = new Rectangle(x, y, colorform, width - x, length - y);
	drawing.addFigures(rect);
	repaint();
	break;

    case 'c':
	Circle circ = new Circle(x, y, colorform, r);
        drawing.addFigures(circ);
	repaint();
	break;
	
    case 'l':
	Line line = new Line(x, y, colorform, width, length);
	drawing.addFigures(line);
	repaint();
	break;
     
    case 'b':
        isClicked = false;
        Brush pencil = new Brush(x, y, colorform,points);
        drawing.addFigures(pencil);
        repaint();
        break;
        
    case 'd':
        delete();
        break;
        
    case 'p':
        Workspace.colorchoose.setVisible(true);
        Workspace.colorchoose.setLocation(x, y);
        Workspace.colorchoose.setSize(width, length);
        pick();
        break;
        
    default:
       break;
        
    }
    repaint();

}
@Override
public void mouseClicked(MouseEvent e) 
{
    
}


@Override
public void mouseEntered(MouseEvent e) {}
@Override
public void mouseExited(MouseEvent e) {}
@Override
public void keyPressed(KeyEvent e) {
	letter = e.getKeyChar();
}
@Override
public void keyReleased(KeyEvent e) {}
@Override
public void keyTyped(KeyEvent e) {}

public void shout(String text)
{
    println(text);
}
        
        /**
	 * The Methode paintComponent draws the Painting on the Paper.
	 * It receives an Graphics-Object, which gives it to the Drawing.
	 * 
	 * @param g  Graphics-Objekt, welches zum zeichnen verwendet werden soll.
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics g) 
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            g2d.drawImage(paintImage, 0, 0, Color.white ,null);
            color_list_path.add(CustomPair.createPair(path, Workspace.color_temp));
		
                                            
                //this.paintPoints(g2d);
                if (drawing != null) drawing.draw(g2d);  
	}  
        
        
        public void updatePaint()
        {
            Graphics2D g2d = paintImage.createGraphics();
            // draw on paintImage using Graphics
            g2d.dispose();
            // repaint panel with new modified paint
            repaint();
        }

    public void save() throws IOException{
        ImageIO.write(paintImage, "PNG", new File("filename.png"));
    }

    public void load() throws IOException {
        paintImage = ImageIO.read(new File("filename.png"));
        // update panel with new paint image
        repaint();
    }
        
        
	
	/**
	 * Setter für die Instanzvariable zeichnung.
	 * 
	 * @param drawing Die zu zeichnende Zeichnung.
	 */
	public void setDrawing(final Drawing drawing) 
        {
		this.drawing = drawing;
	}
        
        
        public Figure getFigure()
        {
            Drawing.figures.forEach((Figure f) -> {
                       
                index_figure = Drawing.figures.indexOf(f);
                temp_figure = f;
             }); 
            
            return temp_figure;
        }
        
        
        
         @Override
    public void delete()
    {
        getFigure();
        if (temp_figure == Drawing.figures.elementAt(index_figure) && Drawing.figures.size() > 0)
        {
            Integer temp = index_figure;
            shout(temp.toString());
            Drawing.figures.removeElementAt(temp);
        }
        else
        {
            System.out.println("No Figures drawn...");
        }
        repaint();
    }
        @Override
    public void select(){}
        @Override
    public void pick()
    {
        getFigure();
        if (temp_figure == Drawing.figures.elementAt(index_figure))
        {
            Drawing.figures.elementAt(index_figure).color = Workspace.colorchoose.getColor();
        }
        repaint();
    }
        @Override
    public void drag(){}
    
}
