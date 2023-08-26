package _01_Olympic_Rings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {

		Robot rob1 = new Robot(400, 700);
		Robot rob2 = new Robot(600, 700);
		Robot rob3 = new Robot(800, 700);
		Robot rob4 = new Robot(1000, 700);
		Robot rob5 = new Robot(1200,700);
		
		Robot robo[] = {rob1, rob2, rob3, rob4, rob5};
		for(Robot r : robo) {
			r.penDown();
			r.setRandomPenColor();
			r.setSpeed(50);
		}
		
		
		Thread t = new Thread(()-> drawSquare(rob1));
		t.start();
		Thread t2 = new Thread(()-> drawSquare(rob2));
		t2.start();
		Thread t3 = new Thread(()-> drawSquare(rob3));
		t3.start();
		Thread t4 = new Thread(()-> drawSquare(rob4));
		t4.start();
		Thread t5 = new Thread(()-> drawSquare(rob5));
		t5.start();
		
	}
	
	public static void drawSquare(Robot r) {
		r.turn(45);
		r.move(200);
		r.turn(-90);
		r.move(200);
		r.turn(-45);
		r.move(200);
		r.turn(-45);
		r.move(200);
	}

}
