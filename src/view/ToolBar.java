package view;

/**
 * Class ToolBar
 * @author Team 11 - 8
 * */

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
	int counter = 20;

	/**
	 *SetCounter : set counter to specfic number
	 *@param int num : the counter number
	 *@return void : nothing
	 */
	public void SetCounter(int num) {
		counter=num;
	}
	/**
	 *getPbar : return the progressBar
	 *@param void : nothing
	 *@return JProgressBar : the progressBar
	 */
	public JProgressBar getPbar() {
		return progressBar;
	}
	/**
	 *getTimer : return the timer
	 *@param void : nothing
	 *@return Timer : the timer
	 */
	public Timer getTimer() {
		return timmah;
	}


	/**
	 *ToolBar : a constructor of ToolBar
	 *@param void : nothing
	 *@return ToolBar : Construct a new ToolBar
	 */

	public ToolBar(){
		progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, counter);
		progressBar.setValue(counter);
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
		//timmah.start();

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



	/**
	 *setBtn : initialize the 3 tool radiobtns
	 *@param void : nothing
	 *@return void : initialize the 3 tool radiobtns and add them to this panel
	 */

	private void setBtn(){
		ImageIcon icon = new ImageIcon(createImages("net"));
		invasiveTool = new JRadioButton("", icon);
		invasiveTool.setFont(new Font("SansSerif",Font.BOLD, 22));
		invasiveTool.setActionCommand("Invasive");//prime num used to find the species
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



	/**
	 *createImages : read files to load images
	 *@param String name: name of the tool, which is part of the path
	 *@return BufferedImage : the images of this tool(icon)
	 */

	private BufferedImage createImages(String name){
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("resources/img/tool/"+ name +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;	    	
	}//createStatusImages


	/**
	 *updateScore : updates the current score
	 *@param int score : a given score
	 *@return void : update the current score according to the given score
	 */

	public void updateScore(int score){
		JButton label = ((JButton) this.getComponent(4));
		label.setText("Score: "+score);
	}


	/**
	 *setActionListener : setup ActionListner
	 *@param ActionListener tAL : a given ActionListener
	 *@return void : give each tool radiobtn an ActionListener
	 */

	public void setActionListener(ActionListener tAL){
		invasiveTool.addActionListener(tAL);
		protectedTool.addActionListener(tAL);
		litterTool.addActionListener(tAL);
	}
}
