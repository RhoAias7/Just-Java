/*
Animation.java
@author F Animashaun
06/09/2017
*/

import java.awt.*;
import java.awt.image.BufferStrategy;
import java awt.image.BufferedImage;
import java.lang.reflect.InvovationTargetException;
import javax.swing.JFrame;

public class ScreenManager {

	private GraphicsDevice gCard;
	//gives gCard access to monitor
	public ScreenManager(){
		GraphicsEnvironment g = graphicsenvironment.getlocalgraphicsenvironment();
		gCard = g.getDefaultScreenDevice();
	}

	//gets all compatible DMs
	public DisplayMode[].getCompatibleDisplayModes(){
		return gCard.getDisplayModes();
	}

	//compares DM passed in to graphics card DM and sees if they match
	public DisplayMode fndFirstCompatibleMode(DisplayMode modes []){
		DiplayMode goodModes[] = gCard.getDisplayModes();
		for(int i = 0; i < modes.length; i++){
			for(int i = 0; i < goodModes.length; y++){
				if(displayModesMatch(modes[x], goodModes[y])){
					return modes[x];
				}
			}
		}
	}

	//get current DM
	public DisplayMode getCurrentDisplayMode(){
		return gCard.getDisplayMode();
	}

}