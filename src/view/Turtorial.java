package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Turtorial extends JPanel implements Serializable{

	public Turtorial(){
		this.add(new ToolBar(),"West");
		popTutorial();
	}
	
	/**
	*popTutorial : pop up the picture tutorial
	*@param void : it consumes nothing
	*@return void : show the tutorial picture in comfirmDialog
	*/
	public void popTutorial() {
		BufferedImage bufferedImage = null;
    	try{
	    	bufferedImage = ImageIO.read(new File("resources/img/background/Intro11.png"));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    	ImageIcon icon = new ImageIcon(bufferedImage);
    	JOptionPane.showConfirmDialog(null, "", "Introduction", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
    	
	}
}
