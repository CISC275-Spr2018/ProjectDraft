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
		super.paintComponent(g);
		timer.start();
		//operation
		g.drawString(minute+":"+second, 1660, 1015);
		timer.stop();
	}
	class FishTimer implements ActionListener{

		 public void actionPerformed(ActionEvent e)
		    {
			 //game lasts no more than 2 minutes
			 while(minute<2){
			 second++;
			 minute=second%60;}
		     repaint();
		    }
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 960);
		TimeCounter tc = new TimeCounter();
		frame.getContentPane().add(tc);
		frame.setVisible(true);
	}//main
	
}
