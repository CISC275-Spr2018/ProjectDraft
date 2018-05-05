package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	public String tool = "Invasion";
	
	public ToolBar(){
		//GridLayout g = new GridLayout(4,0);
		//this.setLayout(g);
		setBtn();
		
		ImageIcon icon = new ImageIcon(createImages("Dialogue2"));
		JButton scoreBtn = new JButton("Score: 0");
		scoreBtn.setBounds(0,780,260,260);
		scoreBtn.setFont(new Font("SansSerif",Font.ITALIC ,48));
		scoreBtn.setEnabled(false);
		this.add(scoreBtn);
	}//constructor
	
	private void setBtn(){
		setLayout(null);
		ImageIcon icon = new ImageIcon(createImages("net"));
		JRadioButton invasiveTool = new JRadioButton("", icon);
		invasiveTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		invasiveTool.setBounds(0,0,260,260);
		
		icon = new ImageIcon(createImages("camera"));
		JRadioButton protectedTool = new JRadioButton("", icon);
		protectedTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		protectedTool.setBounds(0,260,260,260);
		
		icon = new ImageIcon(createImages("trashpicker"));
		JRadioButton litterTool = new JRadioButton("", icon);
		litterTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		litterTool.setBounds(0,520,260,260);
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
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 1080);
		ToolBar tb = new ToolBar();
		frame.getContentPane().add(tb);
		frame.setVisible(true);
	}//main

}
