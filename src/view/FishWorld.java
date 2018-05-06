package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
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

public class FishWorld extends JPanel {
	
	
	private HashMap<String, FishButton> btns = new HashMap<String, FishButton>();
	
	public void initialBG() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image bgImg = tk.createImage("resources/img/background/bg.jpg");
		ImageIcon bgIcon = new ImageIcon(bgImg);  
	    JLabel jlBackgroundimg = new JLabel(bgIcon);
	    jlBackgroundimg.setBounds(0, 0,1920,1080);
	    this.add(jlBackgroundimg);
	}
	
	public FishWorld(ArrayList<FloatingObjs> lof){
		
		for(FloatingObjs f : lof){
			String name = f.getName().toUpperCase();
			try{
				FloatingElements fe = FloatingElements.valueOf(name);
				FishButton temp = new FishButton(fe, new ImageCreate(fe).getImgs());
				temp.move(f.getXloc(),f.getYloc());
				btns.put(f.getName(), temp);
			}catch(IllegalArgumentException e){
				System.out.println("not in Enum!!!!!");
			}
		}
		
		for(FishButton btn : btns.values()){
			this.add(btn);
		}
		
		this.setLayout(null);
		initialBG();
	}
	
	public void removeFloat(String name){
		btns.remove(name);
	}
	public FishWorld getFishWorld() {
		return this;
	}
	
	public void addFloat(FloatingObjs f){
		String strName = f.getName().toUpperCase();
		try{
			FloatingElements fe = FloatingElements.valueOf(strName);
			FishButton temp = new FishButton(fe, new ImageCreate(fe).getImgs());
			temp.move(f.getXloc(),f.getYloc());
			btns.put(f.getName(), temp);
		}catch(IllegalArgumentException e){
			System.out.println("not in Enum!!!!!");
		}
	}
	
	public void updateBtns(ArrayList<FloatingObjs> lof){
		for(FloatingObjs f : lof){
			FishButton temp = btns.get(f.getName());
			if(temp != null){
				temp.move(f.getXloc(), f.getYloc());
			}else{
				addFloat(f);
			}
		}
	}
	
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
		FishWorld eg1 = new FishWorld(world.getListOfFloatingObjs());
		frame.getContentPane().add(eg1);
		
		frame.setVisible(true);
		
		while(true){
			world.move();
			eg1.updateBtns(world.getListOfFloatingObjs());
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