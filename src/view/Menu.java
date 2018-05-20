package view;


/**
 * Class Menu
 * @author Team 11 - 8
 * */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel{
	//draw a JPanel as the Menu 
	//added action listener that will initialize the game
	boolean started = false;
	boolean tutorial = false;

	/**
	 *Menu : a constructor of Menu
	 *@param void : nothing
	 *@return Menu : Construct a new Menu
	 */

	public Menu() {
		setLayout(null);
		add(Box.createVerticalStrut(280));
		JButton button = new JButton("START");
		JButton button2= new JButton("Totorial");
		button.setBounds(900, 600, 90, 30);
		button2.setBounds(900,700,90,30);
		//button.setAlignmentY(BOTTOM_ALIGNMENT);
		button.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		button2.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tutorial();
			}
		});
		add(button);
		add(button2);
		add(Box.createVerticalGlue());
		try {}catch(Exception ex) {

		}

	}


	/**
	 *start : a constructor of Menu
	 *@param void : nothing
	 *@return void : this function release this panel and set started to true
	 */

	public void start() {
		started = true;
		tutorial = false;
		repaint();
		this.removeAll();
	}
	public void tutorial() {
		started = false;
		tutorial = true;
		repaint();
		this.removeAll();


	}

	/**
	 *isStarted : a getter function of Menu
	 *@param void : nothing
	 *@return Boolean : the started status of this Menu
	 */
	public boolean isStarted() {
		return started;
	}
	public boolean isTutorial() {
		return tutorial;
	}
	/**
	 *paintComponent : an overrided function
	 *@param Graphics g: a given graphics
	 *@return void : draws the Component
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image bgImg = tk.createImage("resources/img/menu/menu.png");
		if(!started) {
			g.drawImage(new ImageIcon(bgImg).getImage(),0,0,1920,1080,this);
		}else {
		}
	}
}
