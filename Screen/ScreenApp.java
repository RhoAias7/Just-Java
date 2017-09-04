/*
ScreenApp.java
@author F Animashaun
04/09/2017
*/

import java.awt.*;
import javax.swing.JFrame;

public class ScreenApp extends JFrame {
	public static void main(String[] args){

		//display mode method
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		ScreenApp app = new ScreenApp();
		app.run(dm);
	}

	//sets what will appear on the screen
	//set the background, foreground and font
	public void run(DisplayMode dm){
		setBackground(Color.RED);
		setForeground(Color.BLUE);
		setFont(new Font("Arail", Font.PLAIN, 24));

		Screen s = new Screen();
		try{
			//changing to full screen
			s.setFullScreen(dm, this);
			try{
				//waiting 5 sec (5000 millisecs)
				Thread.sleep(5000);
			}catch(Exception ex){}
		//after 5 sec restore to normal screen
		}finally{
			s.restoreScreen();
		}
	}

	//removes antialiasing
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 =(Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.drawString("This is a amazing", 200, 200);
	}
}