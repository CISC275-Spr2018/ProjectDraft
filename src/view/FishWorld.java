package view;
/**
 * Class FishWorld
 * @author Team 11 - 8
 * */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;

public class FishWorld extends JPanel implements Serializable{
	//this panel holds all fishbuttons 
	//also initializes backgrounds
	private HashMap<Integer, FishButton> btns = new HashMap<Integer, FishButton>();
	private ActionListener buttonHandler;
	
	/**
	*initialBG : initialize the background
	*@param void : nothing
	*@return void : initialize the background panel
	*/
	public void initialBG() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image bgImg = tk.createImage("resources\\img\\background\\bg.jpg");
		ImageIcon bgIcon = new ImageIcon(bgImg);  
	    JLabel jlBackgroundimg = new JLabel(bgIcon);
	    jlBackgroundimg.setBounds(0, 0,1920,1080);
	    this.add(jlBackgroundimg);
	}
	
	/**
	*FishWorld : a constructor of FishWorld
	*@param ArrayList<FloatingObjs> lof: the ArrayList of FloatingObjs
	*@return FishWorld : Construct a new FishWorld
	*/
	public FishWorld(ArrayList<FloatingObjs> lof){
		this.setLayout(null);
		
		for(FloatingObjs f : lof){
			addFloat(f);
		}
		this.setBackground(Color.cyan);
		//initialBG();
	}
	
	/**
	*removeFloat : initialize and add a fishBtn to this panel
	*@param int i: the id of given fishBtn
	*@return void : remove the fishBtn from both HashMap and this panel
	*/
	public void removeFloat(int i){
		FishButton temp = btns.get(i);
		temp.setVisible(false);
		btns.remove(i);
		
		
		this.remove(temp);
	}
	
	/**
	*setActionListener : setup ActionListner
	*@param ActionListener aL : a given ActionListener
	*@return void : give each fishbtn an ActionListener
	*/
	public void setActionListener(ActionListener al){
		this.buttonHandler = al;
		for(FishButton fb : btns.values()){
			fb.addActionListener(buttonHandler);
		}
	}
	
	/**
	*addFloat : initialize and add a fishBtn to this panel
	*@param FloatingObjs f: a given FloatingObjs instance
	*@return FishButton : the added fishBtn
	*/
	public FishButton addFloat(FloatingObjs f){
		String strName = f.getName().toUpperCase();
		FishButton temp = null;
		try{
			FloatingElements fe = FloatingElements.valueOf(strName);
			temp = new FishButton(f, new ImageCreate(fe).getImgs());
			temp.move(f.getXloc(),f.getYloc());
			String[] ss = f.getId().split(" ");;
			if(ss.length > 1){
				System.out.println(ss[1]);
				int index = Integer.parseInt(ss[1]);
				btns.put(index, temp);
				this.add(temp);
				temp.addActionListener(buttonHandler);}
		}catch(IllegalArgumentException e){
			System.out.println("not in Enum!!!!!");
		}
		
		return temp;
	}
	
	/**
	*updateBtns : updates the location of each fishBtn
	*@param ArrayList<FloatingObjs> lof: a given ArrayList of FloatingObjs
	*@return void : updates the location of each fishBtn according to each FloatingObjs in lof
	*/
	public void updateBtns(ArrayList<FloatingObjs> lof){
		for(FloatingObjs f : lof){
			String[] ss = f.getId().split(" ");
				int index = (ss.length > 1)?Integer.parseInt(ss[1]): -1;
			FishButton temp = btns.get(index);
			if(temp != null){
				temp.move(f.getXloc(), f.getYloc());
			}else{
				temp = addFloat(f);
			}//if-else
		}//for
		this.repaint();
	}//updateBtns
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960, 960);
		 	
		
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		//loFloating.add(new ProtectedSpecies("bogTurtle", 480 , 500));
		loFloating.add(new InvasiveSpecies("snakeHead", 480 , 500));
		loFloating.add(new InvasiveSpecies("blueCatfish", 480 , 500));
		loFloating.add(new ProtectedSpecies("horseShoeCrab", 480 , 500));
		
		ModelWorld world = new ModelWorld(loFloating);
		FishWorld eg1 = new FishWorld(world.getListOfExistedFloatingObjs());
		frame.getContentPane().add(eg1);
		
		frame.setVisible(true);
		
		while(true){
			world.move();
			eg1.updateBtns(world.getListOfExistedFloatingObjs());
			try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
			frame.repaint();
			//System.out.println("Update@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
	}
}
