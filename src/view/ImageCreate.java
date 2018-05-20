package view;

/**
 * Class ImgStore
 * @author Team 11 - 8
 * */


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


	/**
	 *ImageCreate : a constructor of ImageCreate
	 *@param String n: the name of this ImageCreate(species)
	 *@param int w: the width of this ImageCreate(species)
	 *@param int h: the height of this ImageCreate(species)
	 *@param int c: the sprite number of this ImageCreate(species)
	 *@return ImageCreate : Construct a new ImageCreate
	 */

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


	/**
	 *ImageCreate : a constructor of ImageCreate
	 *@param FloatingElements e: FloatingElements enum
	 *@return ImageCreate : Construct a new ImageCreate by properties of this enum
	 */

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


	/**
	 *getImgs : a getter function of FloatingElements
	 *@param void : nothing
	 *@return HashMap<String, BufferedImage[]> : the images with directions of this ImageCreate(species)
	 */
	public HashMap<String, BufferedImage[]> getImgs(){
		return imgs;
	}
	/**
	 *createImages : read files to load images
	 *@param String dir: direction, which is part of the path
	 *@return BufferedImage[] : the images with directions of this ImageCreate(species)
	 */
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