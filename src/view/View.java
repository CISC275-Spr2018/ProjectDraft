package view;

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
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame{
	
	final int frameCount = 10;
	final static int FWIDTH = 1960;
	final static int FHEIGHT = 1080;
	private FishWorld eg1;
	private ToolBar tb1;
	private BackgroundPanel bgp;
	
	
	public View(ArrayList<FloatingObjs> objs) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		eg1 = new FishWorld(objs);
		tb1 = new ToolBar();
        bgp=new BackgroundPanel((new ImageIcon("resources/img/background/underwater2.png")).getImage());
        bgp.setBounds(0,0,1920,1080);     
		this.setTitle("alaph");
		this.getContentPane().add(bgp);
		this.getContentPane().add(tb1,"West");
		this.getContentPane().add(eg1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);  
		this.pack();
    	this.setVisible(true);
		
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
	}
	
	public ToolBar getTbar(){
		return tb1;
	}
	
	public void setActionListener(ActionListener fBListener, ActionListener tBListener){
		eg1.setActionListener(fBListener);
		tb1.setActionListener(tBListener);
	}
	class BackgroundPanel extends JPanel  {  
	    Image im;  
	    public BackgroundPanel(Image im)  
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
	}
	
}
