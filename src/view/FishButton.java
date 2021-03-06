package view;

/**
 * Class FishButton
 * @author Team 11 - 8
 * */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.FloatingObjs;
import model.InvasiveSpecies;

public class FishButton extends JButton {
	//individual component that acts as a button but function as a animal object
	//contains action listener as well
	private String cmd;
	private int xpos = 0;
	private int ypos = 0;
	private int imgWidth;
	private int imgHeight;
	private int count  = 0;
	private int frameCount;
	private HashMap<String, BufferedImage[]> pics;


	/**
	 *FishButton : a constructor of FishButton
	 *@param FloatingObjs f: a given FloatingObjs instance
	 *@param HashMap<String, BufferedImage[]> imgs: the images of that given FloatingObjs
	 *@return FishButton : Construct a new FishButton
	 */

	public FishButton(FloatingObjs f, HashMap<String, BufferedImage[]> imgs){
		super();
		cmd = f.getId();
		this.setActionCommand(cmd);
		String nameStr = f.getName().toUpperCase();
		try{
			FloatingElements e = FloatingElements.valueOf(nameStr);
			this.imgWidth = e.getWidth();
			this.imgHeight = e.getHeight();
			this.frameCount = e.getCount();
		}catch(IllegalArgumentException e){
			System.out.println("not in Enum!!!!!");
		}
		this.pics = imgs;
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
		ImageIcon icon = new ImageIcon(pics.get("left")[count]);
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false); 
		this.setBorderPainted(false); 
	}


	/**
	 *getX : a getter function of FishButton
	 *@param void : nothing
	 *@return int : the x-position of FishButton
	 */

	public int getX(){
		return xpos;
	}


	/**
	 *getY : a getter function of FishButton
	 *@param void : nothing
	 *@return int : the y-position of FishButton
	 */
	public int getY(){
		return ypos;
	}

	/**
	 *move : updates the location of FishButton
	 *@param int x : a given x location
	 *@param int y : a given y location
	 *@return void : move the FishButton to the given x y location
	 *				it also determines the direction by the difference of x
	 *				and draw the image if it has next sprite
	 */

	public void move(int x, int y){
		String dir = (x < xpos)? "left" : "right";
		this.xpos = x;
		this.ypos = y;
		count = (count+1)%frameCount;
		ImageIcon icon = new ImageIcon(pics.get(dir)[count]);

		this.setIcon(icon);
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
	}
}
