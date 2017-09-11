/*
Screen.java
@author F Animashaun
04/09/2017
*/


import java.awt.*;
import javax.swing.JFrame;

public class Screen {

	//interface into your graphics card
	private GraphicsDevice gCard;

	public Screen(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

		//access to computer screen
		gCard =env.getDefaultScreenDevice();
	}
	//enables fullscreen mode
	public void setFullScreen(DisplayMode dm, JFrame window){
		window.setUndecorated(true);
		window.setResizable(false);
		gCard.setFullScreenWindow(window);

		//checks monitor settings and check if it is able to display the settings
		if(dm != null && gCard.isDisplayChangeSupported()){
			try{

			}catch(Exception ex){}
		}
	}
	//returns the window
	public Window getFullScreenWindow(){
		return gCard.getFullScreenWindow();
	}

	//restores regular screen
	public void restoreScreen(){
		Window w = gCard.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		gCard.setFullScreenWindow(null);
	}
}