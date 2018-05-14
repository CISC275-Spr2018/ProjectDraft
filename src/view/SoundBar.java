package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import sun.audio.*;

public class SoundBar extends JPanel{
	
	private JRadioButton sound = new JRadioButton("Music affect");
	private JRadioButton bgm = new JRadioButton("Background music");
	private ImageIcon soundicon_T = new ImageIcon(createImages("sound"));
	private ImageIcon bgicon_T = new ImageIcon(createImages("bgm"));
	private ImageIcon soundicon_F = new ImageIcon(createImages("soundF"));
	private ImageIcon bgicon_F = new ImageIcon(createImages("bgmF"));
	
	public AudioClip bgMusic = null;
	public SoundBar() {
		
		this.setLayout(new GridLayout(0,2));
		sound.setIcon(soundicon_T);
		sound.setActionCommand("sound on");
		sound.setContentAreaFilled(false);
		//sound.setToolTipText("Sound effects");
		bgm.setIcon(bgicon_T);
		bgm.setActionCommand("BGM on");
		bgm.setContentAreaFilled(false);
		this.setSize(300, 100);
		//bgm.setToolTipText("Background musics");
		this.setBounds(1550,0,300,100);
		this.setBackground(Color.cyan);
		this.add(sound);
		this.add(bgm);
		this.setBGMusic();
		
	}
	
	public void setIcons(Boolean b1, Boolean b2){
		if(b1){
			sound.setIcon(soundicon_T);
		}else{
			sound.setIcon(soundicon_F);
		}
		
		if(b2){
			bgm.setIcon(bgicon_T);
		}else{
			bgm.setIcon(bgicon_F);
		}
	}//setIcons
	
	public void setActionListener(ActionListener l) {
		sound.addActionListener(l);
		bgm.addActionListener(l);
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
	
	public void setBGMusic(){
		URL url = null;
		File f1 = new File("resources/music/bg.wav");
		   try {
			   url= f1.toURL();
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		   
		   bgMusic = Applet.newAudioClip(url);
		   
	}//setBGMusic
	
	public void startMusic(){
        if(bgMusic != null) {  
        	bgMusic.loop();  
        }  
	}//startMusic
	
	public void stopMusic() {  
        if(bgMusic != null) {  
        	bgMusic.stop();  
        }  
    } //stopMusic
	
	/**
	*beep : plays the sound to show correct or not
	*@param int i : getting from the FishButtonListener to see if the action is right or not
	*@return void : play the right sound according to the choice 
	*/
	public static void beep(int i){
		String input = (i >= 0)? "correct" : "wrong";
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;

        try{
            InputStream test = new FileInputStream("resources//music//" + input + ".wav");
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
    }
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		SoundBar s = new SoundBar();
		s.setActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = e.getActionCommand();
				System.out.println(str);
				String[] ss = str.split(" ");
				ss[1] = (ss[1].equalsIgnoreCase("on"))? "off": "on";
				((JRadioButton)e.getSource()).setActionCommand(ss[0] + " " + ss[1]);
			}
			
		});

		//f.setSize(1920, 1080);
		f.getContentPane().add(s);
		f.pack();
		f.setVisible(true);
	}
}
