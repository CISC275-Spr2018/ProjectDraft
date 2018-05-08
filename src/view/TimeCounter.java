package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeCounter extends JPanel{
	private Timer timer;
	private int minute;
	private int second;
	private int time;
	private JButton timeBtn;
	public TimeCounter(){
		this.timer= new Timer(1000, new FishTimer());
		timeBtn.setText("Time:0:00");
		this.add(timeBtn);
	}
	
	public void paintComponent(Graphics g){
		timer.start();

		//paint stuff
		//g.setFont(new Font("SansSerif",Font.BOLD, 22));
		//g.setColor(Color.WHITE);
		//super.paintComponent(g);
		timer.start();
		timeBtn.setText("Time:"+time/60+":"+time%60);

		//operation
		//g.drawString(minute+":"+second, 1660, 1015);

	}
	class FishTimer implements ActionListener{

		 public void actionPerformed(ActionEvent e){
			 while(time<120){
			 time++;
		     repaint();
		    }
			 timer.stop();
	}
}

public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(160, 80);
	TimeCounter tc = new TimeCounter();
	frame.getContentPane().add(tc);
	frame.setVisible(true);
}//main

}