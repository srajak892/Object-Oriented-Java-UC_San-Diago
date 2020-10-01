package guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class SunINSec extends PApplet {
	
	PImage bg;
	public void setup(){
		
		size(400,400);
		bg = loadImage("palmTrees.jpg","jpg");
		
	}
	
	
	public void draw() {
		bg.resize(0, height);
		image(bg, 0, 0);
		
		
		int[] color = perSec(second());
		
		fill(color[0],color[1],color[2]);
		ellipse(56,56,55,55);
		
		
		
	}
	
	public int[] perSec(float seconds) {
	
	int[] rgb = new int[3];
	
	float FillPerSec = (seconds-30);
	 float ratio = FillPerSec/30;
	 
	 rgb[0]=(int)(255*ratio);
	 rgb[1]=(int)(250*ratio);
	 rgb[2]=(int)(50*ratio);
	
	 return rgb;
	}
}
