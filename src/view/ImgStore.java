package view;

/**
 * Class ImgStore
 * @author Team 11 - 8
 * */


import java.util.HashMap;

public class ImgStore {
	//all the floatingObjs imgs stored here
	private HashMap<String, ImageCreate> imgs = new HashMap<String, ImageCreate>();
	

	/**
	*ImgStore : a constructor of ImgStore
	*@param void: nothing
	*@return ImgStore : Construct a new ImgStore
	*/

	public ImgStore(){
		for(FloatingElements e : FloatingElements.values()){
			imgs.put(e.getName(), new ImageCreate(e));
		}
	}

}
