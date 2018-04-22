package view;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JButton;

import model.FloatingObjs;

public class FishButton extends JButton {
	private String cmd;
	private int xpos;
	private int ypos;
	private int imgWidth;
	private int imgHeight;
	private HashMap<String, BufferedImage[]> pics = new HashMap<String, BufferedImage[]>();
	
	public FishButton(FloatingElements e){
		super();
		cmd = e.getName();
		this.setActionCommand(cmd);
		this.imgWidth = e.getWidth();
		this.imgHeight = e.getHeight();
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
	}
	
	public int getX(){
		return xpos;
	}
	
	public int getY(){
		return ypos;
	}

}
