package view;


/**
 * Class SoundBar
 * @author Team 11 - 8
 * */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;

public class SoundBar{
	private static AudioPlayer MGP = AudioPlayer.player;
	private static AudioStream BGM;
	private static ContinuousAudioDataStream loop = null;

	public static void music() {       
		try{
			InputStream test = new FileInputStream("resources//music//bg.wav");
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
}
