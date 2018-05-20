package view;


/**
 * Class View
 * @author Team 11 - 8
 * */


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame{
	//a JFrame that takes everything thing and present the layers of images 
	Menu menu;
	final int frameCount = 10;
	final static int FWIDTH = 1960;
	final static int FHEIGHT = 1080;


	private FishWorld eg1;
	private ToolBar tb1;

	//private BackgroundPanel bgp;
	public boolean isAdded;

	/**
	 *View : a constructor of View
	 *@param void: nothing
	 *@return View : Construct a new View
	 */

	public View() {
		menu= new Menu();
		add(menu);
		menu.setBounds(0,0,1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		eg1 = new FishWorld(new ArrayList<FloatingObjs>());
		tb1 = new ToolBar();  
		this.setTitle("Habitat Management Training Program");
		isAdded = false;

		this.setLayout(null);

		this.setVisible(true);
		this.setSize(FWIDTH, FHEIGHT);
	}

	/**
	 *getMenu : a getter function of View
	 *@param void : nothing
	 *@return Menu : the menu of this View
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 *popTutorial : pop up the picture tutorial
	 *@param void : it consumes nothing
	 *@return void : show the tutorial picture in comfirmDialog
	 */
	public void Poptutorial() {
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("resources/img/background/Intro11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bufferedImage);
		JOptionPane.showConfirmDialog(null, "", "Introduction", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);

	}
	/**
	 *PopGameOver : pop up the game over
	 *@param int highscore : the ending score
	 *@return void : show the game over
	 */
	public void PopGameOver(int hightscore) {
		this.removeAll();
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("resources/img/background/over.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bufferedImage);
		JPanel a = new GameOverPane();
		a.setSize(1920, 1080);
		a.setVisible(true);
		JLabel b = new JLabel(icon);

		a.add(b);
		this.add(a);
		this.repaint();

		JOptionPane.showConfirmDialog(null, "GameOver \r\n\r\n Score: " + hightscore,
				"GameOver", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showConfirmDialog(this, "GameOver \r\n\r\n Score: " + hightscore);
	}

	/**
	 *TutorialOver : show that the tutorial has ended
	 *@param void : it consumes nothing
	 *@return void : show the startGame option
	 */
	public void TutorialOver() {
		this.repaint();
		JOptionPane.showConfirmDialog(null, "Tutorial Ends!",
				"StartGame", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}


	/**
	 *initStage1 : initialize stage1
	 *@param void : nothing
	 *@return void : initialize the stage1 of this View
	 */

	public void initStage1() {
		System.out.println("added!");
		this.getFworld().initialBG();


		this.add(eg1);
		eg1.setBounds(300,0,1920,1080);
		this.add(tb1);
		tb1.setBounds(0,0,300,1080);
		isAdded=true;						
	}

	/**
	 *updateView :updates components in View
	 *@param ArrayList<FloatingObjs> ob1 : a given ArrayList<FloatingObjs>
	 *@return void : this function moves the fishBtns in eg1(FishWorld panel)
	 */
	public void updateView(ArrayList<FloatingObjs> ob1) {

		eg1.updateBtns(ob1);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//this.repaint();
	}

	/**
	 *getTbar : a getter function of View
	 *@param void : nothing
	 *@return ToolBar : the tb1(Toolbar panel) of this View
	 */
	public ToolBar getTbar(){
		return tb1;
	}

	/**
	 *getFworld : a getter function of View
	 *@param void : nothing
	 *@return FishWorld : the eg1(FishWorld panel) of this View
	 */
	public FishWorld getFworld(){
		return eg1;
	}
	/**
	 *setActionListener : setup ActionListner
	 *@param ActionListener fBListener : a given FishBtn ActionListener
	 *@param ActionListener tBListener : a given toolBar ActionListener
	 *@return void : give eg1(FishWorld panel) fBListener; 
	 *				give tb1(Toolbar panel) tBListener
	 */
	public void setActionListener(ActionListener fBListener, ActionListener tBListener){
		eg1.setActionListener(fBListener);
		tb1.setActionListener(tBListener);
	}



}
