package view;


/**
 * enum FloatingElements
 * @author Team 11 - 8
 * */

public enum FloatingElements {
	//List of all floating objects and holds their strings and image sizes, sprite numbers
	BASS("bass",249, 132, 1),
	BOGTURTLE("bogTurtle",227,125,3),
	BLUECATFISH("blueCatfish", 250, 73,1),
	HORSESHOECRAB("horseShoeCrab",283,193,2),
	MITTENCRAB("mittenCrab", 254,142,3),
	PICKEREL("pickerel",252,84,1),
	TROUT("trout",253,95,1),
	TROUTGRP("troutGrp",256,256,1),
	REDSWAMPCRAYFISH("redSwampCrayfish",200,122,1),
	SNAKEHEAD("snakeHead",300,99,1),
	STURGEON("sturgeon",300,64,1),
	PAPER("paper",99,99,4),
	SALAMANDER("salamander",200,53,1);
	
	private String name;
	private int imgWidth;
	private int imgHeight;
	private int count;
	

	/**
	*FloatingElements : a constructor of FloatingElements
	*@param String s: the name of this FloatingElements
	*@param int w: the width of this FloatingElements
	*@param int h: the height of this FloatingElements
	*@param int c: the sprite number of this FloatingElements
	*@return FloatingElements : Construct a new FloatingElements
	*/

	private FloatingElements(String s, int w, int h, int c){
		name = s;
		imgWidth = w;
		imgHeight = h;
		count = c;
	}
	

	/**
	*getName : a getter function of FloatingElements
	*@param void : nothing
	*@return String : the name of this FloatingElements
	*/

	public String getName(){
		return name;
	}
	

	/**
	*getHeight : a getter function of FloatingElements
	*@param void : nothing
	*@return int : the height of this FloatingElements
	*/

	public int getHeight(){
		return imgHeight;
	}
	

	/**
	*getWidth : a getter function of FloatingElements
	*@param void : nothing
	*@return int : the width of this FloatingElements
	*/

	public int getWidth(){
		return imgWidth;
	}
	

	/**
	*getCount : a getter function of FloatingElements
	*@param void : nothing
	*@return int : the sprite number of this FloatingElements
	*/

	public int getCount(){
		return count;
	}
}