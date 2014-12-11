package kochCurve;

import gpdraw.*;

public class CoolPattern {
	
	private DrawingTool pen;
	
	public CoolPattern(){
		pen = new DrawingTool( new SketchPad(600,600));
		pen.setWidth(2);
	}

	public void drawMeACircle(double radius) {
		pen.up();
		pen.home();
		pen.down();
		pen.drawCircle(radius);
		pen.up();
	}

	public void inPosition(double length, double radius) {
		pen.move(0, radius);
		pen.setDirection(-60.);
	}

	public void drawKoch(double side, int level) {
		pen.down();
		if (level < 1)
			pen.move(side);
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

	public void turnKoch() {
		pen.turnRight(120.);
	}

	public void offsetTurn(double degreeOffset) {
		pen.turnRight(degreeOffset);
	}

}
