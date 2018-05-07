package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeCounter extends JPanel{
	private Timer timer;
	private int minute;
	private int second;
	public TimeCounter(){
		this.timer= new Timer(1000, new FishTimer());
	}
	public void paintComponent(Graphics g){
		//paint stuff
		g.setFont(new Font("SansSerif",Font.BOLD, 22));
		g.setColor(Color.WHITE);
		g.drawString(minute+":"+second, 1660, 1015);
		super.paintComponent(g);
		timer.start();
		//operation
		timer.stop();
	}
	
}
