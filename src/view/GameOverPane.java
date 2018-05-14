package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameOverPane extends JPanel{
	public GameOverPane(){
		this.setSize(1920, 1280);
		this.setBackground(Color.PINK);
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("resources/img/background/over.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		g.drawImage(bufferedImage,0,0,null);
	}
	
	public void gameover(int i){
		JOptionPane.showConfirmDialog(null, "GameOver \r\n\r\n Score: " + i, "GameOver", JOptionPane.CLOSED_OPTION, 
				JOptionPane.INFORMATION_MESSAGE);
		HighScore h1 = new HighScore(i);
		ArrayList<HighScore> hs = HighScore.readIn("outSample");
		hs.add(h1);
		hs = HighScore.sortHighScoreList(hs);
		HighScore.writeOut("outSample", hs);
		HighScore.showHighScoreList(HighScore.readIn("outSample"));
		this.repaint();
	}
}
