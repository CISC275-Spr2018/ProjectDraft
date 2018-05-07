package view;

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
	public Menu() {
		setLayout(null);
		add(Box.createVerticalStrut(280));
		JButton button = new JButton("START");
		button.setBounds(900, 600, 90, 30);
		//button.setAlignmentY(BOTTOM_ALIGNMENT);
		button.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		add(button);
		add(Box.createVerticalGlue());
		try {}catch(Exception ex) {
			
		}
		
	}
	public void start() {
		started = true;
		
		repaint();
		this.removeAll();
	}

	public boolean isStarted() {
		return started;
	}
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image bgImg = tk.createImage("resources/img/menu/menu.png");
			//ImageIcon bgIcon = new ImageIcon(bgImg); 
			//JLabel jlBackgroundimg = new JLabel(bgIcon);
			//jlBackgroundimg.setBounds(0, 0,1920,1080);
			//this.add(jlBackgroundimg);
			if(!started) {
				g.drawImage(new ImageIcon(bgImg).getImage(),0,0,1920,1080,this);
			}else {
				//setBackground(Color.CYAN);
			}
	}
	public static void main(String args[]) {
		JFrame a = new JFrame();
		a.setSize(1920,1080);
		a.setResizable(false);
		a.add(new Menu());
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	