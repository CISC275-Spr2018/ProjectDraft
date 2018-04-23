package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.FloatingObjs;

public class FishButton extends JButton {
	private String cmd;
	private int xpos = 0;
	private int ypos = 0;
	private int imgWidth;
	private int imgHeight;
	private int count  = 0;
	private int frameCount;
	private HashMap<String, BufferedImage[]> pics;
	
	public FishButton(FloatingElements e, HashMap<String, BufferedImage[]> imgs){
		super();
		cmd = e.getName();
		this.setActionCommand(cmd);
		this.imgWidth = e.getWidth();
		this.imgHeight = e.getHeight();
		this.frameCount = e.getCount();
		this.pics = imgs;
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
		ImageIcon icon = new ImageIcon(pics.get("left")[count]);
		this.setIcon(icon);
		//this.setBackground(null);
	}
	
	public int getX(){
		return xpos;
	}
	
	public int getY(){
		return ypos;
	}
	
	public void move(int x, int y){
		String dir = (x < xpos)? "left" : "right";
		this.xpos = x;
		this.ypos = y;
		count = (count+1)%frameCount;
		ImageIcon icon = new ImageIcon(pics.get(dir)[count]);
		this.setContentAreaFilled(false); 
		this.setBorderPainted(false); 
		this.setIcon(icon);
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ImageCreate bass = new ImageCreate(FloatingElements.BOGTURTLE);
    	FishButton bassBtn = new FishButton(FloatingElements.BOGTURTLE, bass.getImgs());
    	bassBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("---------->"+e.getActionCommand()+"<---------");
			}
    		
    	});
		frame.setSize(1280, 960);
		frame.getContentPane().add(bassBtn);
		frame.setVisible(true);
		int i = 0;
		while(i < 400){
			i++;
			bassBtn.move(i, i*2);
			try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
			frame.repaint();
		}
	}

}
