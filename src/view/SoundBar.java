package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import sun.audio.*;

public class SoundBar extends JPanel{
	
	private JRadioButton sound;
	
	public SoundBar() {
		
		this.setLayout(new GridLayout(2,0));
		ImageIcon icon = new ImageIcon(createImages("sound"));
		sound = new JRadioButton("sound", icon);
		sound.setBounds(1750,0,100,100);
		
		this.add(sound);
		
	}
	
	public void setActionListener(ActionListener l) {
		sound.addActionListener(l);
	}
	
	private BufferedImage createImages(String name){
    	BufferedImage bufferedImage = null;
    	try{
	    	bufferedImage = ImageIO.read(new File("resources/img/tool/"+ name +".png"));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		return bufferedImage;	    	
}//createStatusImages

	public static void music() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;

        ContinuousAudioDataStream loop = null;

        try{

            InputStream test = new FileInputStream("resources/music/bg.wav");

            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
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
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		SoundBar s = new SoundBar();
		
		f.setVisible(true);
		f.setSize(1920, 1080);
		f.getContentPane().add(s);
		
	}
}
