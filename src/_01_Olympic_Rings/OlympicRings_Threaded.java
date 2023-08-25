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
			Thread r1 = new Thread(() -> r.setAngle(45));
			r1.start();
			Thread r2 = new Thread(() -> r.move(200));
			r2.start();

			Thread r3 = new Thread(() -> r.setAngle(45));
			r3.start();

			Thread r4 = new Thread(() -> r.move(200));
			r4.start();

			Thread r5 = new Thread(() -> r.setAngle(45));
			r5.start();

			Thread r6 = new Thread(() -> r.move(200));
			r6.start();

			Thread r7 = new Thread(() -> r.setAngle(45));
			r7.start();

			Thread r8 = new Thread(() -> r.move(200));
			
			r8.start();
		}
		
	

		

		
	}
}
