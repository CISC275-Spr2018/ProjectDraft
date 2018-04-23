package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ToolBar extends JPanel {
	public String tool = "Invasion";
	
	public ToolBar(){
		this.setLayout(new FlowLayout());
		setBtn();
		
		ImageIcon icon = new ImageIcon(createImages("Dialogue2"));
		JLabel label = new JLabel("Score:" + 0, icon, 0);
		this.add(label);
	}//constructor
	

	
	
	private void setBtn(){
		ImageIcon icon = new ImageIcon(createImages("net"));
		JRadioButton invasiveTool = new JRadioButton("Invasion", icon);
		
		icon = new ImageIcon(createImages("camera"));
		JRadioButton protectedTool = new JRadioButton("Protected", icon);
		
		icon = new ImageIcon(createImages("trashpicker"));
		JRadioButton litterTool = new JRadioButton("Litter", icon);
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
		JLabel label = ((JLabel) this.getComponent(3));
		label.setText("" +score);
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
