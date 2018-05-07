package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageCreate {
	//stores individual images to a Hashmap of Buffered images
	//also contains different directions of the animations
	private String name;
	private int imgWidth;
	private int imgHeight;
	private int count;
	private HashMap<String, BufferedImage[]> imgs= new  HashMap<String, BufferedImage[]>();
	
	public ImageCreate(String n, int w, int h, int c){
		this.name = n;
		this.count = c;
		this.imgWidth = w;
		this.imgHeight = h;
		String dir = "left";
		this.imgs.put(dir, createImages(dir));
		dir = "right";
		this.imgs.put(dir, createImages(dir));
	}//constructor
	
	public ImageCreate(FloatingElements e){
		this.name = e.getName();
		this.count = e.getCount();
		this.imgWidth = e.getWidth();
		this.imgHeight = e.getHeight();
		String dir = "left";
		this.imgs.put(dir, createImages(dir));
		dir = "right";
		this.imgs.put(dir, createImages(dir));
		
	}//constructor
	
	public HashMap<String, BufferedImage[]> getImgs(){
		return imgs;
	}
	
	   private BufferedImage[] createImages(String dir){
	    	BufferedImage bufferedImage;
	    	BufferedImage[] imgs = new BufferedImage[count];
	    	
	    	for(int i = 0; i < count; i++){
	    		try {
		    		bufferedImage = ImageIO.read(new File("resources/img/"+name+"/"+name+"_"+dir+"_"+i+ ".png"));
		        		imgs[i] = bufferedImage;
		    		//return imgs;
		    	} catch (IOException e) {
		    		e.printStackTrace();
		    	}
		    	//return null;
	    	}//for
			return imgs;
	    	
	    }//createStatusImages

}