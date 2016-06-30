/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor;

import static java.awt.Color.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.SwingConstants.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.util.logging.*;


/**
 *
 * @author vmadmin
 */
public class Workspace extends JFrame implements MouseMotionListener
{
    static public String tool_used = "None";
    static public Color color_temp = Color.gray;
    static Paper paper = new Paper();
    static public int count = 0;
    static public JColorChooser colorchoose = new JColorChooser(Color.BLACK);
    public JPanel location = new JPanel();
    
        
    
   //BufferedImage logo = ImageIO.read(fc.getResource("/resources/logo/logo.gif"));
    
    
    public static void init_prog()
    {
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
Image image = toolkit.getImage("pen.png");
Cursor c = toolkit.createCustomCursor(image , new Point(paper.getX(), 
           paper.getY()), "img");
paper.setCursor (c);
        
        Icon icon_rect = new ImageIcon("images/rectS.png");
        Icon icon_brush = new ImageIcon("images/brushS.png");
        Icon icon_line = new ImageIcon("images/lineS.png");
        Icon icon_color = new ImageIcon("images/colorS.png");
        Icon icon_circ = new ImageIcon("images/circS.png");
        Icon icon_black = new ImageIcon("images/blackS.png");
        Icon icon_blue = new ImageIcon("images/blueS.png");
        Icon icon_red = new ImageIcon("images/redS.png");
        Icon icon_orange = new ImageIcon("images/orangeS.png");

        Dimension dimSide = new Dimension();
        dimSide.setSize(70, 200);
        Dimension dim = new Dimension();
        dim.setSize(1, 1);
        Dimension dimButton = new Dimension();
        dimButton.setSize(80,25);
        
        
        BorderLayout bl = new BorderLayout();
        
        JPanel sideButtons = new JPanel();
        
        
        JLabel strokename = new JLabel("Stroke");
        JLabel label_tool_used = new JLabel(tool_used);
        
        JSeparator sep = new JSeparator();
        sep.setBackground(black);
        sep.setLocation(0, 20);
        sep.setSize(dim);
        
        JDialog testIt = new JDialog();
        testIt.setLayout(bl);
        
        JDialog sidestep = new JDialog();
        sidestep.setLayout(bl);
       
        JToolBar tb = new JToolBar("Tools");
        
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(null); 
        
        FileFilter ff = new FileNameExtensionFilter("PNG File", "png");        
        ImageFilter img = new ImageFilter();
        File img_file = fc.getSelectedFile();
        
        
        JToggleButton forms = new JToggleButton("Forms");
        forms.setPreferredSize(dimButton);
        
        JButton rect = new JButton(icon_rect);
        rect.setOpaque(false);
        rect.setContentAreaFilled(false);
        rect.setBorderPainted(false);
        rect.setVisible(false);
        
        JButton circ = new JButton(icon_circ);
        circ.setOpaque(false);
        circ.setContentAreaFilled(false);
        circ.setBorderPainted(false);
        circ.setVisible(false);
        
        JButton line = new JButton(icon_line);
        line.setOpaque(false);
        line.setContentAreaFilled(false);
        line.setBorderPainted(false);
        line.setVisible(false);
        
        JButton brush = new JButton(icon_brush);
        brush.setOpaque(false);
        brush.setContentAreaFilled(false);
        brush.setBorderPainted(false);
        brush.setVisible(false);
        
        JButton color = new JButton("Color");
        color.setOpaque(false);
        color.setBorderPainted(false);
        color.setContentAreaFilled(false);
        color.setIcon(icon_color);
        color.setLocation(0, 400);
 
        JButton delete = new JButton("Delete");
        circ.setOpaque(false);
        circ.setContentAreaFilled(false);
        circ.setBorderPainted(false);
        circ.setVisible(false);
        
        
        JTextField stroke = new JTextField();
        
        stroke.setPreferredSize(dimButton);
        stroke.setMaximumSize(dimButton);
        stroke.setLocation(0, 300);

        
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem newD = new JMenuItem("New");
        
        Border bo = new LineBorder(Color.red);
        JMenuBar bar = new JMenuBar();
        
//wichtig
        JFrame gE = new JFrame("Graphic Editor");
        JLabel point = new JLabel("O");
       
//JFrame                
        gE.setUndecorated( true );
        gE.setVisible(true);
        gE.setSize(800, 600);
        gE.setLocation(250, 100);
        gE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gE.setContentPane(paper);
        gE.setDefaultLookAndFeelDecorated( false );
        gE.getRootPane().setWindowDecorationStyle(HIDE_ON_CLOSE);
        gE.setJMenuBar(bar);


//paper 
        paper.setLayout(bl);
        sidestep.setVisible(true);
        
////Test Sector
//        testIt.setVisible(true);
//        testIt.setSize(360, 260);
//        
//        //Integer[] intel = {Drawing.figures.iterator().next().x, Drawing.figures.iterator().next().y};
//        Component add = testIt.add(myTest);
//        
//        
//        //paper.add(sidestep, "West");
//        //paper.setBackground();
//        
//Side panel
        sidestep.setLocation(120, 200);
        sidestep.setSize(100, 500);
        sidestep.add(tb, "West");
        
//File Chooser
        fc.setFileHidingEnabled(false);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(ff);
        

//File Toolbar
        tb.setOrientation(VERTICAL);
        tb.setSize(100, 500);
        tb.setLayout(new BoxLayout(tb, BoxLayout.PAGE_AXIS));
        tb.setBorder(bo);  
        tb.add(forms, "Before");
        tb.add(sep, "Center");
        tb.add(label_tool_used, "First");
        tb.setLocation(0, 0);
        tb.setFloatable(true);
        tb.setRollover(true);
        tb.add(stroke, "First");
        tb.add(color, "North");
        //tb.add(strokename, "First");
        
//Forms Menu 
        tb.add(sideButtons, "Last");
        sideButtons.setPreferredSize(dimSide);
        sideButtons.setLocation(0, 50);
        sideButtons.setLayout(new BoxLayout(sideButtons, BoxLayout.PAGE_AXIS));
        sideButtons.add(rect, "First");
        sideButtons.add(circ, "Before");
        sideButtons.add(line, "Center");
        sideButtons.add(brush, "After");
        sideButtons.add(delete, "Last");
        
        
//File Menubar
        bar.add(file);
        bar.add(edit);
        bar.setBorder(bo);
       
//File Menu
        file.add(open);
        file.add(save);
        file.add(newD);
        file.add(exit);
        
        
        forms.addActionListener((ActionEvent e) ->
        {
            rect.setLocation(100, 0);
            circ.setLocation(100, 30);
            line.setLocation(100, 60);
            brush.setLocation(100, 90);
            delete.setLocation(100, 120);
           
            rect.setVisible(true);
            circ.setVisible(true);
            line.setVisible(true);
            brush.setVisible(true);
            delete.setVisible(true);
        });
        
        rect.addActionListener((ActionEvent e) ->{
            //rect.setBorderPainted(true);
            Paper.letter = 'r';
            tool_used = "Rectangle" + color_temp.toString();
        });
        
        circ.addActionListener((ActionEvent e) ->{
            //circ.setBorderPainted(true);
            Paper.letter = 'c';
            tool_used = "Circle" + color_temp.toString();
        });
        
        line.addActionListener((ActionEvent e) ->{
            //line.setBorderPainted(true);
            Paper.letter = 'l';
            tool_used = "Line" + color_temp.toString(); 
        });
        
        brush.addActionListener((ActionEvent e)->{
            //brush.setBorderPainted(true);
            Paper.letter = 'b';
            tool_used = "Brush" + color_temp.toString();
        });
        
        delete.addActionListener((ActionEvent e)->{
            Paper.letter = 'd';
            tool_used = "Delete";
        });
        
        color.addActionListener((ActionEvent e ) ->{ 
            switch(count)
            {
                default:
                    count++;
                    break;
                    
                case 1: 
                    color.setIcon(icon_red);
                    color.setText("Red");
                    color_temp = (red);
                    count++;
                    break;
                    
                case 2: 
                    color.setIcon(icon_blue);
                    color.setText("Blue");
                    color_temp = (blue);
                    count++;
                    break;
                       
                case 3:
                    color.setIcon(icon_orange);
                    color.setText("Orange");
                    color_temp = (orange);
                    count++;
                    break;
                    
                case 4: 
                    color.setIcon(icon_black);
                    color.setText("Black");
                    color_temp = (black);
                    count=1;
                    break;
            }
            

            
           
        });
        
        stroke.addActionListener((ActionEvent e) ->{
           Paper.stroke = Integer.parseInt(stroke.getText()); 
        });
        
        //Drawing.g.setColor(new Color(200,0,100));
        
        newD.addActionListener((ActionEvent e) ->{
            Drawing.figures.removeAllElements();
            Paper.g.clearRect(0, 0, Paper.paintImage.getWidth(), Paper.paintImage.getHeight());
            Paper.paintImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
            Paper.g = (Graphics2D) Paper.paintImage.createGraphics();
            paper.repaint();
        });
        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0b0);
        });
        
        save.addActionListener((ActionEvent e ) -> {
            fc.showSaveDialog(null);
            
            try {
                String name = fc.getSelectedFile().toString();
                BufferedImage bi = Paper.paintImage;
                File outputfile = new File(name+".png");
                ImageIO.write(bi, "png", outputfile);
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        open.addActionListener((ActionEvent e ) -> {
            fc.showOpenDialog(null);
            try {
                String name = fc.getSelectedFile().toString();
                File inputfile = new File(name);
                BufferedImage outputfile = ImageIO.read(inputfile);
                Paper.paintImage = outputfile;
                Paper.g = (Graphics2D) Paper.paintImage.createGraphics().create();
                paper.updatePaint();
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    public Workspace() 
    {
	super("GraphicEditor für Figuren"); 
        location.setVisible(true);
    }

    
    public void show(Drawing drawing) 
    {
	paper.setDrawing(drawing);
	repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {        
        //paper.updatePaint();
    }
    
}
