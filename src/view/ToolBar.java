package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class ToolBar extends JPanel {
	
	//a JPanel that contains tool images and shows scores 
	private JRadioButton invasiveTool;
	private JRadioButton protectedTool;
	private JRadioButton litterTool;
	Timer timmah;
    JProgressBar progressBar;
    int counter = 100;
	//BarTest bar;
	public void SetCounter(int num) {
		counter=num;
	}
	public ToolBar(){
		progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        progressBar.setValue(100);
        progressBar.setBounds(0, 0, 20, 30);
        progressBar.setPreferredSize(new Dimension(100,25));
        
        ActionListener listener = new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
                counter--;
                progressBar.setValue(counter);
                if (counter<1) {
                    //JOptionPane.showMessageDialog(null, "Kaboom!");
                	timmah.stop();
                } 
            }
        };
        progressBar.setBackground(new Color(128, 0, 128));
        progressBar.setForeground(Color.cyan);
        this.add(progressBar);
        progressBar.setBounds(270,0,30,1080);
        timmah = new Timer(1000, listener);
        timmah.start();
        
		//bar= new BarTest();
		//GridLayout g = new GridLayout(5,0);
		this.setLayout(null);
		
		setBtn();
		
		ImageIcon icon = new ImageIcon(createImages("Dialogue2"));
		JButton scoreBtn = new JButton("Score: 0");
		scoreBtn.setFont(new Font("SansSerif",Font.ITALIC ,36));
		//scoreBtn.setEnabled(false);
		scoreBtn.setContentAreaFilled(false); 
		scoreBtn.setBorderPainted(false); 
		scoreBtn.setBounds(0,780,260,260);
		this.add(scoreBtn);
		this.setBackground(new Color(100,255,255));
	}//constructor
	

	
	
	private void setBtn(){
		ImageIcon icon = new ImageIcon(createImages("net"));
		invasiveTool = new JRadioButton("", icon);
		invasiveTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		invasiveTool.setActionCommand("Invasion");//prime num used to find the species
		invasiveTool.setContentAreaFilled(false); 
		invasiveTool.setBorderPainted(false); 
		invasiveTool.setBounds(0,0,260,260);
		
		icon = new ImageIcon(createImages("camera"));
		protectedTool = new JRadioButton("", icon);
		protectedTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		protectedTool.setActionCommand("Protected");//prime num used to find the species
		protectedTool.setContentAreaFilled(false); 
		protectedTool.setBorderPainted(false); 
		protectedTool.setBounds(0,260,260,260);
		
		icon = new ImageIcon(createImages("trashpicker"));
		litterTool = new JRadioButton("", icon);
		litterTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		litterTool.setActionCommand("Litter");//prime num used to find the species		
		litterTool.setContentAreaFilled(false); 
		litterTool.setBorderPainted(false); 
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
	
	public void setActionListener(ActionListener tAL){
		invasiveTool.addActionListener(tAL);
		protectedTool.addActionListener(tAL);
		litterTool.addActionListener(tAL);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320 ,1080);
		ToolBar tb = new ToolBar();
		frame.getContentPane().add(tb);
		frame.setVisible(true);
	}//main

}
