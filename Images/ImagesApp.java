/*
ImagesApp.java
@author F Animashaun
04/09/2017
*/

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImagesApp extends JFrame {
	public static void main(String[] args){

		//display mode method
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		ImagesApp i = new ImagesApp();
		i.run(dm);
	}

	private Images s;
	private Image bg; //background image
	private Image pic; //picture
	private boolean loaded;

	//run method
	//sets what will appear on the screen
	//set the background, foreground and font
	public void run(DisplayMode dm){
		setBackground(Color.RED);
		setForeground(Color.BLUE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;

		s = new Images();
		try{
			//changing to full screen
			s.setFullScreen(dm, this);
			loadpics();
			try{
				//waiting 5 sec (5000 millisecs)
				Thread.sleep(5000);
			}catch(Exception ex){}
		//after 5 sec restore to normal screen
		}finally{
			s.restoreScreen();
		}
	}

	//loads pictures
	public void loadpics(){
		bg = new ImageIcon("map.jpg").getImage();
		pic = new ImageIcon("mage.png").getImage();
		loaded = true;
		repaint(); //calls paint method
	}

	//removes antialiasing
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 =(Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded){
			g.drawImage(bg,0,0,null);
			g.drawImage(pic,170,180,null);
		}
	}
}