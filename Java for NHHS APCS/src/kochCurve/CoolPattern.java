package kochCurve;

import java.awt.Color;

import gpdraw.*;

public class CoolPattern {

	private DrawingTool pen;
	private Color c = Color.GREEN;
	private int iteration = 0;

	public CoolPattern(){
		pen = new DrawingTool( new SketchPad(800,800));
		pen.setWidth(1);
	}

	public void drawMeACircle(double radius) {
		pen.up();
		pen.home();
		pen.down();
		//pen.drawCircle(radius);
		pen.up();
	}

	public void inPosition(double length, double radius, double degreeOffset) {
		pen.home();
		pen.turn(-degreeOffset);
		pen.move(radius);
		pen.setDirection(-60.-degreeOffset);
	}

	public void drawKoch(double side, int level) {
		pen.down();
		if (level < 1) {
			nextColor();
			pen.setColor(c);
			pen.move(side); }
		else {
			side = side/3;
			level --;
			drawKoch(side,level);
			pen.turnLeft(60.);
			drawKoch(side,level);
			pen.turnRight(120.);
			drawKoch(side,level);
			pen.turnLeft(60.);
			drawKoch(side,level);
		}

	}

	private void nextColor() {
		switch (iteration%5) {
		case 0:
			c = Color.CYAN;
			break;
		case 1: 
			c= Color.BLUE;
			break;
		case 2:
			c = Color.GREEN;
			break;
		case 3:
			c = Color.MAGENTA;
			break;
		case 4:
			c = Color.PINK;
			break;
		}
		iteration ++;

	}

	public void turnKoch() {
		pen.turnRight(120.);
	}

	public void offsetTurn(double degreeOffset) {
		pen.turnRight(degreeOffset);
	}

}
