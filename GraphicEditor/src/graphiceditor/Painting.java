///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package graphiceditor;
//
//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Point;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.imageio.ImageIO;
//import javax.swing.JPanel;
//
///**
// *
// * @author vmadmin
// */
//public class Painting extends BufferedImage implements MouseListener, KeyListener, MouseMotionListener {
//    
//     /**
//	 * The Drawing.
//	 */
//	private Drawing drawing;
//        private Figure brush;
//        public static int stroke = 1;
//        private ArrayList<Point> points = new ArrayList<Point>();
//        private boolean isClicked; 
//        public static BufferedImage paintImage = new BufferedImage(660, 500, BufferedImage.TYPE_3BYTE_BGR);
//        
//        int x;
//        int y;
//        int z;
//        
//	public Painting(int x, int y, int z)
//        {
//            this.x = x;
//            this.y = y;
//            this.z = z;
//            addMouseListener(this);
//            addMouseMotionListener(this);
//            addKeyListener(this);
//
//        }
//        
//    /**
//     *
//     */
//    public static char letter = 'd';
//    
//    char test(char letter)
//    {
//        
//        return 0;
//    }
//    
//        private int x, y;
//        
//@Override
//public void mousePressed(MouseEvent e) {
//    x = e.getX();
//    y = e.getY();
//    
//    switch(letter)
//    {
//        case 'b':
//            isClicked = true;
//            break;
//    }
//    // drawing.g.setColor(Color.black);
//    // drawing.g.setColor(Color.red);
//    //Line line = new Line(x, y, x, y);
//    //drawing.addFigures(line);
//}
//
//    @Override
//    public void mouseDragged(MouseEvent e)
//    {   
//        
//        if(isClicked == true)
//        {
//            
//            repaint();
//            points.add(e.getPoint());
//            repaint(); //request Swing to refresh display as soon as it cans
//        }
//        //points.add(e.getPoint());
//              
//    }
//
//
// @Override
// public void mouseMoved(MouseEvent me)
//    {
//        repaint();
//    }
//
//
//@Override
//public void mouseReleased(MouseEvent e) {
//    int width = e.getX() ;
//    int length = e.getY() ;
//    
//
//    if (x < 0 || y < 0){
//        x = -x;
//        y = -y;
//    }
//    
//    int diameter = width-x^2+length-y^2;
//    double pi = Math.PI;
//    
//    switch(letter){
//    case 'r':
//	if (x < 0) {
//		x = x *(-1);
//	}
//	Rectangle rect = new Rectangle( x, y, width - x, length -y);
//	drawing.addFigures(rect);
//	repaint();
//	break;
//
//    case 'c':
//	Circle circ = new Circle(x, y,  diameter);
//        drawing.addFigures(circ);
//	repaint();
//	break;
//	
//    case 'l':
//	Line line = new Line(x, y, width, length);
//	drawing.addFigures(line);
//	repaint();
//	break;
//     
//    case 'b':
//        
//            isClicked = false;
//            
//           // points.add(e.getPoint());
//            repaint();
//            break;
//        
//    
//    default:
//        
//        
//        break;
//        
//}
//
//
//}
//@Override
//public void mouseClicked(MouseEvent e) {}
//@Override
//public void mouseEntered(MouseEvent e) {}
//@Override
//public void mouseExited(MouseEvent e) {}
//@Override
//public void keyPressed(KeyEvent e) {
//	letter = e.getKeyChar();
//}
//@Override
//public void keyReleased(KeyEvent e) {}
//@Override
//public void keyTyped(KeyEvent e) {}
//        
//        /**
//	 * The Methode paintComponent draws the Painting on the Paper.
//	 * It receives an Graphics-Object, which gives it to the Drawing.
//	 * 
//	 * @param g  Graphics-Objekt, welches zum zeichnen verwendet werden soll.
//	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
//	 */
//	@Override
//	public void paintComponent(final Graphics g) 
//        {
//            super.paintComponent(g);
//            Graphics2D g2d = (Graphics2D) g;
//            
//            g2d.drawImage(paintImage, 100, 20, Color.white ,null);
//		
//                
//                                
//                this.paintPoints(g2d);
//                if (drawing != null) drawing.draw(g2d);
//            
//	}
//        
//        public Figure paintPoints(Graphics g)
//        {
//            Graphics2D g2d = (Graphics2D)g;
//            for (int i = 0; i < points.size() - 1; i++)
//            {
//                Point p1 = points.get(i);
//                Point p2 = points.get(i + 1);
//
//                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
//            }
//            
//            
//            return brush;
//        }
//        
//        public void giveBrush(Figure brush)
//        {
//            brush = this.brush;
//        }
//        
//        
//        
//        public void updatePaint(){
//        
//        Graphics2D g2d = paintImage.createGraphics();
//
//        // draw on paintImage using Graphics
//
//        g2d.dispose();
//        // repaint panel with new modified paint
//        repaint();
//    }
//
//    public void save() throws IOException{
//        ImageIO.write(paintImage, "PNG", new File("filename.png"));
//    }
//
//    public void load() throws IOException {
//        paintImage = ImageIO.read(new File("filename.png"));
//        // update panel with new paint image
//        repaint();
//    }
//        
//        
//	
//	/**
//	 * Setter für die Instanzvariable zeichnung.
//	 * 
//	 * @param drawing Die zu zeichnende Zeichnung.
//	 */
//	public void setDrawing(final Drawing drawing) 
//        {
//		this.drawing = drawing;
//	}
//    
//    
//}
