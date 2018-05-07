package view;

import java.util.HashMap;

public class ImgStore {
	//all the floatingObjs imgs stored here
	private HashMap<String, ImageCreate> imgs = new HashMap<String, ImageCreate>();
	
	public ImgStore(){
		for(FloatingElements e : FloatingElements.values()){
			imgs.put(e.getName(), new ImageCreate(e));
		}
	}

}
