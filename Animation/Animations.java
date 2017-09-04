/*
Animation.java
@author F Animashaun
04/09/2017
*/

import java.awt.Image;
import java.util.ArrayList;

public class Animation {

	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;

	//constructor
	private Animation(){
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}

	//adds scene to ArrayList and set time for each scene
	public synchronized void addScene(){
		totalTime += t;
		scenes.add(new OneScene);
	}


}