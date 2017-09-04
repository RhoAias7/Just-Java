/*
Threads.java
@author F Animashaun
04/09/2017
*/

import java.util.Random;

public class Threads implements Runnable{

	//name of thread
	String name;

	//the length of time it pauses
	int time;
	Random r = new Random();

	//constructor
	public Threads(String th){
		name = th;
		time = r.nextInt(999);

	}

	//run method
	public void run(){
		try{
			System.out.printf("%s is sleeping for %d\n", name, time);

			//current thread
			Thread.sleep(time);
			System.out.printf("%s is done\n", name);
		}catch(Exception e){}
	}

}