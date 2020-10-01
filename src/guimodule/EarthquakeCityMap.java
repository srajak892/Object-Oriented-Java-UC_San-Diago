package guimodule;

import java.util.ArrayList;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.core.Coordinate;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class EarthquakeCityMap extends PApplet {
	
	private UnfoldingMap map;

	public void setup(){
		size(900,700, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this,map);
		
		
		Location valLoc = new Location (-38.14f, -73.03f);
		PointFeature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdiva, Chile");
		valEq.addProperty("Magnitude", "9.5");
		valEq.addProperty("date","May 22, 1960");
		valEq.addProperty("year", "1960");
		
		Location AlaskaLoc = new Location (61.02f, -147.65);
		PointFeature AlaskaEq = new PointFeature(AlaskaLoc);
		AlaskaEq.addProperty("title", "Great Alaska, Alaska");
		AlaskaEq.addProperty("Mangnitude", "9.2");
		AlaskaEq.addProperty("Date", "March 28, 1964");
		AlaskaEq.addProperty("year", "1964");
		
		
		Location SumLoc = new Location(3.30f, 95.78f);
		PointFeature SumatraEq = new PointFeature(SumLoc);
		SumatraEq.addProperty("title", "West Coast, Northen Sumantra");
		SumatraEq.addProperty("Magnitude","9.1");
		SumatraEq.addProperty("Date", "December 26, 2004");
		SumatraEq.addProperty("Year", "2004");
		
		Location JapanLoc = new Location(9.0, 38.322f);
		PointFeature JapanEq = new PointFeature(JapanLoc);
		JapanEq.addProperty("title", "Honshu, Japan");
		JapanEq.addProperty("Magnitude", "9.0");
		JapanEq.addProperty("Date", "March 11, 2011");
		JapanEq.addProperty("Year", "2011");
		
		
		Location KamchatkaLoc = new Location(52.76f, 160.06f);
		PointFeature KamchatkaEq = new PointFeature(KamchatkaLoc);
		KamchatkaEq.addProperty("Title","Kamchatka");
		KamchatkaEq.addProperty("Mangnitude", "9.0");
		KamchatkaEq.addProperty("Date", "November , 1952");
		KamchatkaEq.addProperty("Year", "1952");
		
		
		
	    List<PointFeature> bigEarthquakes = new ArrayList<PointFeature>();
	    bigEarthquakes.add(valEq);
	    bigEarthquakes.add(AlaskaEq);
	    bigEarthquakes.add(SumatraEq);
	    bigEarthquakes.add(JapanEq);
	    bigEarthquakes.add(KamchatkaEq);
//	    
		List<Marker> markers = new ArrayList<Marker>();
		for(PointFeature eq: bigEarthquakes) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
			
		}
		
		
		map.addMarkers(markers);
		
		int yellow = color(255, 255, 0);
	    int gray = color(150,150,150);
	    
	    for (Marker mk :markers) {
	    	if ( (int) mk.getProperty("year") > 2000 ) {
	    		mk.setColor(yellow);
	    	}
	    	else {
	    		mk.setColor(gray);
	    	}
	    }
	    
	    
	    
		
	}
	
	
	private SimplePointMarker createMarker(PointFeature feature)
	{
		// finish implementing and use this method, if it helps.
		return new SimplePointMarker(feature.getLocation());
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// Remember you can use Processing's graphics methods here
	
	}
}

