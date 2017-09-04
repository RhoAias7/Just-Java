/*
ThreadsApp.java
@author F Animashaun
04/09/2017
*/

public class ThreadsApp {
	public static void main(String[] args){

		Thread t1 = new Thread(new Threads("one"));
		Thread t2 = new Thread(new Threads("two"));
		Thread t3 = new Thread(new Threads("Three"));
		t1.start();
		t2.start();
		t3.start();

	}
}