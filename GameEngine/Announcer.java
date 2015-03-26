package GameEngine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Renderer.GameField;

public class Announcer extends JPanel {
	private static final ImageIcon spriteSheet = new ImageIcon(GameField.class.getResource("spritesheet.png"));
	ArrayList<Broadcast> array = new ArrayList<>();
	public Announcer()
	{
	        Dimension d = new Dimension(1024,200);
		setPreferredSize(d);
		setMaximumSize(d);
		setMinimumSize(d);
	
	        
	}
	public void broadcast(int sprite, int type,String string)
	{
		array.add(new Broadcast(sprite,type,string));
	}
	private class Broadcast{
		private int sprite = 3;
		private int type = 0;
		private String s = "test";
	private Broadcast(int sprite,int type,String s)
	{
		this.sprite = sprite;
		this.type = type;
		this.s = s;
	}
	}
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        System.out.println(array.size());
	        int x = array.size();
	        for(Broadcast b:array)
	        {
	             Image image2 = spriteSheet.getImage();
	             Image image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
	             Graphics g2 = image.getGraphics();
	             g2.drawImage(image2, 0, -b.sprite*32, null);
	             g2.dispose();
	             ImageIcon imageIcon = new ImageIcon(image);
	        	 g.drawImage(imageIcon.getImage(), 0, x*32-32, this);
	        	 g.drawString(b.s, 32,(x*32)-10);
	        	 x--;
	        }
	      
	    }
}
