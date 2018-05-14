package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class HighScore implements Comparable<HighScore>{
	private int grade;
	private String name;
	
	public HighScore(int g){
		this.grade = g;
		String input = JOptionPane.showInputDialog(null,"Please enter your name", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
		this.name = (input.equals(""))? "on one": input;
	}//Constructor
	
	public HighScore(){
		this.grade = 0;
		this.name = "No one";
	}//Constructor
	
	public HighScore(String str){
		String[] sArray = str.split(" ---- ");
		this.grade = Integer.parseInt(sArray[1]);
		this.name = sArray[0];
	}//Constructor
	
	public HighScore(int g, String s){
		this.grade = g;
		name = s;
	}//Constructor
	
	public String getName(){
		return name;
	}
	public String toString(){
		return name + " ---- " + grade;
	}//toString
	
	@Override
	public int compareTo(HighScore b) {
		// TODO Auto-generated method stub
		int result = this.grade - b.grade;
		result = (result != 0)? result : this.getName().compareToIgnoreCase(b.getName());
		return 0-result;
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Below are fuctions that manipulates ArrayList of HighScores
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public static void showHighScoreList(ArrayList<HighScore> hs){
		String message = "";
		hs = sortHighScoreList(hs);
		for(int i = 0; i < 20; i++){
			String rank = (i <= 8)? "  "+ (i+1): ""+(i+1);
			String str = hs.get(i).toString() + "\r\n";
			message += "No." + rank +"  "+ str;
		}
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}//showHighScoreList
	
	public static ArrayList<HighScore> sortHighScoreList(ArrayList<HighScore> hs){
		Collections.sort(hs);
		int len = hs.size();
		while(len < 20){
			hs.add(new HighScore());
			len++;
		}//while
		return hs;
	}//sortHighScoreList
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Below are read in, write out functions
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public static void writeOut(String fileName, ArrayList<HighScore> hs){
		try{
		//this function overwrites the exist text with content.
		String path = "resources/text/"+fileName+".txt"; 
		File writename = new File(path);  
        writename.createNewFile();  
        BufferedWriter writer = new BufferedWriter(new FileWriter(writename));  
        for(int i = 0; i < 20; i++){
        	writer.write(hs.get(i).toString() + "\r\n");
        }
        writer.close();   

		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}//writeOut
	
	public static ArrayList<HighScore> readIn(String fileName){
		//this function reads a file backwards
		String path = "resources/text/"+fileName+".txt"; 
		File file = new File(path);
		BufferedReader reader = null;
		String str = null;
		ArrayList<HighScore> hs = new ArrayList<HighScore>();
		
		try{
			reader = new BufferedReader(new FileReader(path));
            while ((str = reader.readLine()) != null) {
         		HighScore tempH = new HighScore(str); 
         		hs.add(tempH);
     			//System.out.println(tempSub + " " + tempSub.getSolvingStatus());*/
            }//while

			reader.close();
			
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(reader != null){
					try{
						reader.close();
					}catch(IOException e1){}
				}
			}
		return hs;
	}//readIn
	
	/*
	 * 
	 * 
	 * main
	 * 
	 * */
	
	public static void main(String[] args){
		HighScore h1 = new HighScore(280);
		//System.out.println(h1);
		ArrayList<HighScore> hs = new ArrayList<HighScore>();
		hs.add(h1);
		for(int i = 1; i < 25; i++){
			hs.add(new HighScore(i*20+i, "Sb somebody"));
		}
		showHighScoreList(hs);
		
		writeOut("outSample", hs);
		showHighScoreList(readIn("outSample"));
		
		HighScore h2 = new HighScore(h1.toString());
		//System.out.println(h2);
		
		
	}//main

}
