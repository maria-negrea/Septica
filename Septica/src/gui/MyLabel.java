package gui;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel{
		static int x = 0;
	
	 	ImageIcon imageIcon;
	    public MyLabel(ImageIcon icon)
	    {
	        super();
	        this.imageIcon = icon;
	    }
	    
	    public MyLabel()
	    {
	    }
	    
	    @Override
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);
	        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
	    }
	    
	    public void setIcon(ImageIcon icon)
	    {
	    	this.imageIcon=icon;
	    	revalidate();
	    	repaint();
	    }	    
}
