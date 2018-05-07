package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeCounter extends JPanel{
	private Timer timer;
	private int time;
	private JButton timeBtn;
	public TimeCounter(){
		this.timer= new Timer(1000, new FishTimer());
		timeBtn.setText("Time:0:00");
	}
	public void paintComponent(Graphics g){
		timer.start();

		//paint stuff
		g.setFont(new Font("SansSerif",Font.BOLD, 22));
		g.setColor(Color.WHITE);
		timeBtn.setText("Time:"+time/60+":"+time%60);

		//operation

	}
	class FishTimer implements ActionListener{

		 public void actionPerformed(ActionEvent e)
		    {
			 //game lasts no more than 2 minutes
			 while(time<120){
			 time++;
		     repaint();
		    }
				timer.stop();
		    }
}
}