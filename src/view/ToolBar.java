package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ToolBar extends JPanel {
	//a JPanel that contains tool images and shows scores 
	private JRadioButton invasiveTool;
	private JRadioButton protectedTool;
	private JRadioButton litterTool;
	
	public ToolBar(){
		GridLayout g = new GridLayout(4,0);
		this.setLayout(g);
		setBtn();
		
		ImageIcon icon = new ImageIcon(createImages("Dialogue2"));
		JButton scoreBtn = new JButton("Score: 0");
		scoreBtn.setFont(new Font("SansSerif",Font.ITALIC ,48));
		//scoreBtn.setEnabled(false);
		scoreBtn.setContentAreaFilled(false); 
		scoreBtn.setBorderPainted(false); 
		this.add(scoreBtn);
		this.setBackground(new Color(100,255,255));
	}//constructor
	

	
	
	private void setBtn(){
		ImageIcon icon = new ImageIcon(createImages("net"));
		invasiveTool = new JRadioButton("Invasion", icon);
		invasiveTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		invasiveTool.setActionCommand("Invasion");//prime num used to find the species
		invasiveTool.setContentAreaFilled(false); 
		invasiveTool.setBorderPainted(false); 
		
		icon = new ImageIcon(createImages("camera"));
		protectedTool = new JRadioButton("Protected", icon);
		protectedTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		protectedTool.setActionCommand("Protected");//prime num used to find the species
		protectedTool.setContentAreaFilled(false); 
		protectedTool.setBorderPainted(false); 
		
		icon = new ImageIcon(createImages("trashpicker"));
		litterTool = new JRadioButton("Litter", icon);
		litterTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		litterTool.setActionCommand("Litter");//prime num used to find the species		
		litterTool.setContentAreaFilled(false); 
		litterTool.setBorderPainted(false); 
		
		ButtonGroup bp = new ButtonGroup();
		bp.add(invasiveTool);
		bp.add(protectedTool);
		bp.add(litterTool);
		this.add(invasiveTool);
		this.add(protectedTool);
		this.add(litterTool);
	}//setBtn
	
	
	
	private BufferedImage createImages(String name){
	    	BufferedImage bufferedImage = null;
	    	try{
		    	bufferedImage = ImageIO.read(new File("resources/img/tool/"+ name +".png"));
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
			return bufferedImage;	    	
	}//createStatusImages
	
	public void updateScore(int score){
		JButton label = ((JButton) this.getComponent(3));
		label.setText("Score: "+score);
	}
	
	public void setActionListener(ActionListener tAL){
		invasiveTool.addActionListener(tAL);
		protectedTool.addActionListener(tAL);
		litterTool.addActionListener(tAL);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 960);
		ToolBar tb = new ToolBar();
		frame.getContentPane().add(tb);
		frame.setVisible(true);
	}//main

}
