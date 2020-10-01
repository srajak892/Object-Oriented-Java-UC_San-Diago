package guimodule;

import processing.core.PApplet;

public class myGUI  extends PApplet{
	
	public void setup() {
		
		size(400,400);
		background(200,200,200);
		
	
	}
	
	public void draw() {
		fill(255,250,50);
		ellipse(200,200,370,370);
		
		fill(0,0,0);
		ellipse(100,130,40,60);
		
		ellipse(280,130,40,60);
		
		noFill();
		arc(200,250,100,100,0,PI);
		
	}
	

}
