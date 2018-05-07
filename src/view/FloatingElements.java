package view;

public enum FloatingElements {
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
	SALAMANDER("salamander",200,53,1)
	;
	
	private String name;
	private int imgWidth;
	private int imgHeight;
	private int count;
	
	private FloatingElements(String s, int w, int h, int c){
		name = s;
		imgWidth = w;
		imgHeight = h;
		count = c;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHeight(){
		return imgHeight;
	}
	
	public int getWidth(){
		return imgWidth;
	}
	
	public int getCount(){
		return count;
	}
}