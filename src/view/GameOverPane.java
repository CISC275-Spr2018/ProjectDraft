package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameOverPane extends JPanel{
	public GameOverPane() {
		this.setSize(1920,1080);
		this.setVisible(true);

	}
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("resources/img/background/over.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(bufferedImage,0,0,null);
	}
}
