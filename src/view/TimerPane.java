package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TimerPane extends JPanel implements Serializable{
	private BufferedImage[] bubbles = new BufferedImage[21];
	private int current= 0;
	private int green = 0;
	private int red = 0;
	private int blue = 0;
	private double countDou = 1;
	private Color c= new Color(red,green,blue); 
	
	
	/**
	*TimerPane : a constructor of TimerPane
	*@param void : nothing
	*@return TimerPane : Construct a new TimerPane
	*/
	public TimerPane(){
		setImage();
		this.setSize(300, 200);
		this.setBackground(c);
	}
	
	/**
	*setImages : a setter of TimerPane
	*@param void : nothing
	*@return void : set the image field
	*/
	public void setImage(){
		BufferedImage bufferedImage = null;
		for(int i = 0; i <= 20; i++){
			int num = 20 - i;
			try{
				bufferedImage = ImageIO.read(new File("resources/img/bubble/bubble_" + num+".png"));
				bubbles[i] = bufferedImage;
			} catch (IOException e) {
				e.printStackTrace();
			}//try-catch
		}//for
	}
	
   /** 
     * paint : an overrided function 
     * Graphics g : a given graph;
     * void : update the graph
     */
    public void paint(Graphics g){  
        super.paint(g);  
        g.drawImage(bubbles[current], 0, 0, this);

    }
	
	/**
	*updateTime : updates the current time image
	*@param double timeRate : the ratio of current time and total time
	*@return void : update the current image according to the given ratio
	*/
	public void updateTime(double b){
		red = (int) (b * 100) % 100;
		green = (int) (b * 225) % 225;
		blue = (int) (b * 225) % 225;
		c = new Color(red,green,blue);
		this.setBackground(c);
		if(b <= countDou - 0.05){
			countDou -= 0.05;
			current += (current < 20)? 1: 0;
		}
		
		this.repaint();
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		TimerPane t = new TimerPane();
		frame.setSize(500, 500);
		frame.getContentPane().add(t);
		frame.setVisible(true);
		double b = 1.0;
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.updateTime(b);
			b -=(b>=0.01)? 0.01: 0;
		}
	}//main
}//TimerPane
