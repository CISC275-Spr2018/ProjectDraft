package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import model.FloatingObjs;

public class FishButton extends JButton{
	private String cmd;
	private int xpos = 0;
	private int ypos = 0;
	private int imgWidth;
	private int imgHeight;
	private int count  = 0;
	private int frameCount;
	private HashMap<String, BufferedImage[]> pics;
	
	public FishButton(FloatingElements e, HashMap<String, BufferedImage[]> imgs){
		super();
		cmd = e.getName();
		this.setActionCommand(cmd);
		this.imgWidth = e.getWidth();
		this.imgHeight = e.getHeight();
		this.frameCount = e.getCount();
		this.pics = imgs;
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
		ImageIcon icon = new ImageIcon(pics.get("left")[count]);
		this.setIcon(icon);
		this.setContentAreaFilled(false);
	}
	
	public int getX(){
		return xpos;
	}
	
	public int getY(){
		return ypos;
	}
	
	public void move(int x, int y){
		String dir = (x < xpos)? "left" : "right";
		this.xpos = x;
		this.ypos = y;
		count = (count+1)%frameCount;
		ImageIcon icon = new ImageIcon(pics.get(dir)[count]);
		this.setContentAreaFilled(false); 
		this.setBorderPainted(false); 
		this.setIcon(icon);
		this.setBounds(xpos, ypos, imgWidth, imgHeight);
	}
	public static class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e){
            music();
    }
}
	
	public static void music() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        //AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("resources/music/bg.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
	public static void main(String[] args){
		

		JFrame testframe = new JFrame();
		testframe.setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image bgImg = tk.createImage("resources/img/background/bg.jpg");
		ImageIcon bgIcon = new ImageIcon(bgImg);  
        JLabel jlBackgroundimg = new JLabel(bgIcon);
        jlBackgroundimg.setBounds(0, 0,1920,1080);
        testframe.add(jlBackgroundimg);
        testframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Click me");
	    testframe.add(button);
	    button.addActionListener(new AL());
	    testframe.setVisible(true);
    	
    	ImageCreate bass = new ImageCreate(FloatingElements.BASS);
    	FishButton bassBtn = new FishButton(FloatingElements.BASS, bass.getImgs());
    	/**
    	bassBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("---------->"+e.getActionCommand()+"<---------");
			}
    		
    	});**/
		
		testframe.add(bassBtn);
		testframe.setSize(1920	,1080);
		testframe.setVisible(true);
		int i = 0;
		while(i < 400){
			i++;
			bassBtn.move(i, i*2);
			try {
    			Thread.sleep(100);
    		} catch (InterruptedException e){
    			e.printStackTrace();
    		}
			testframe.repaint();
		}
	}
	
	
	

}
