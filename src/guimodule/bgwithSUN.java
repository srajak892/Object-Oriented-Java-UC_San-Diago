package guimodule;

import processing.core.*;

public class bgwithSUN extends PApplet {
	
	private String URL="https://images.unsplash.com/photo-1507525428034-b723cf961d3e";
	
	private PImage BackgroundMain;
	
public void setup() {
	
	size(800,500);
	
	BackgroundMain = loadImage(URL,"jpg");
	
}

public void draw() {
	
	BackgroundMain.resize(800, 500);
	image(BackgroundMain, 0, 0);
	
	int[] color = sunPersec(second());
	fill(color[0],color[1],color[2]);
	ellipse(270,180,80,80);
}

public int[] sunPersec(float seconds) {
	
	int[] rgb = new int[3];
	
	float diffFrom30 = Math.abs(30-seconds);
	float ratio = diffFrom30/30;
	
	rgb[0] = (int)(255*ratio);
	rgb[1] = (int)(250*ratio);
	rgb[2] = (int)(50*ratio);
	
	return rgb;

}
}