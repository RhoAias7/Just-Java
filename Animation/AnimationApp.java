/*
AnimationApp.java
@author F Animashaun
06/09/2017
*/

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AnimationApp{
	public static void main(String args[]){
		DisplayMode displayMode = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		AnimationApp p = new AnimationApp();
		p.run(displayMode);
	}

	private Screen screen;
	private Image bg;
	private Animation a;

	//loads pictures from computer to java and adds scenes
	public void loadPics(){
		bg = new ImageIcon("map.jpg").getImage();
		Image body1 = new ImageIcon("scene 1.png").getImage();
		Image body2 = new ImageIcon("scene 2.png").getImage();
		Image body3 = new ImageIcon("scene 3.png").getImage();
		Image body4 = new ImageIcon("scene 4.png").getImage();
		Image body5 = new ImageIcon("scene 5.png").getImage();
		Image body6 = new ImageIcon("scene 6.png").getImage();
		Image body7 = new ImageIcon("scene 7.png").getImage();
		Image body8 = new ImageIcon("scene 8.png").getImage();
		a = new Animation();
		a.addScene(body1, 60);
		a.addScene(body2, 60);
		a.addScene(body3, 60);
		a.addScene(body4, 60);
		a.addScene(body5, 60);
		a.addScene(body6, 60);
		a.addScene(body7, 60);
		a.addScene(body8, 60);

	}

	//main engine to run
	public void run(DisplayMode dm){
		screen = new Screen();
		try{
			screen.setFullScreen(dm, new JFrame());
			loadPics();
			movieLoop();
		}finally{
			screen.restoreScreen();
		}
	}

	//main movie loop
	public void movieLoop(){
		long startingTime = System.currentTimeMillis();
		long cTime = startingTime;

		while(cTime - startingTime < 5000){
			long timePassed = System.currentTimeMillis() - cTime;
			cTime += timePassed;
			a.update(timePassed);

			Graphics g = screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();

			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}

	//draw method
	public void draw(Graphics g){
		g.drawImage(bg, 0,0,null);
		g.drawImage(a.getImage(),600,300,null);

	}
}
