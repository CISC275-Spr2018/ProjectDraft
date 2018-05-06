package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;

public class FishWorld extends JPanel {
	private HashMap<Integer, FishButton> btns = new HashMap<Integer, FishButton>();
	private ActionListener buttonHandler;
	//private Background bg;
	
	public FishWorld(ArrayList<FloatingObjs> lof){
		
		for(FloatingObjs f : lof){
			addFloat(f);
		}
		
		this.setLayout(null);
		this.setBackground(Color.cyan);
		//bg=new Background((new ImageIcon("resources/img/background/underwater2.png")).getImage());
		//bg.setBounds(0,0,1560,1080);
		//this.add(bg);
	}
	
	public void removeFloat(int i){
		FishButton temp = btns.get(i);
		btns.remove(i);
		this.remove(temp);
	}
	
	public void setActionListener(ActionListener al){
		this.buttonHandler = al;
		for(FishButton fb : btns.values()){
			fb.addActionListener(buttonHandler);
		}
	}
	
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
	
	/*class Background extends JPanel  {  
	    Image im;  
	    public Background(Image im)  
	    {  
	        this.im=im;  
	        this.setOpaque(true);                    //设置控件不透明,若是false,那么就是透明
	    }  
	    //Draw the background again,继承自Jpanle,是Swing控件需要继承实现的方法,而不是AWT中的Paint()
	    public void paintComponent(Graphics g)       //绘图类,详情可见博主的Java 下 java-Graphics 
	    {  
	        super.paintComponents(g);  
	        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //绘制指定图像中当前可用的图像。图像的左上角位于该图形上下文坐标空间的 (x, y)。图像中的透明像素不影响该处已存在的像素

	    }  
	}*/
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960, 960);

		
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogTurtle", 48 , 50));
		loFloating.add(new InvasiveSpecies("bass", 40 , 50));
		loFloating.add(new InvasiveSpecies("catfish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 50));
		
		ModelWorld world = new ModelWorld(loFloating);
		FishWorld eg1 = new FishWorld(world.getListOfExistedFloatingObjs());
		frame.getContentPane().add(eg1);
		
		frame.setVisible(true);
		
		while(true){
			world.updateWorld();
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
