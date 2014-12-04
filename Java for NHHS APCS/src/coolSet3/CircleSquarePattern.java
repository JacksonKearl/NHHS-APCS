package coolSet3;


import java.awt.Color;
import gpdraw.*;
public class CircleSquarePattern
{
	private DrawingTool pencil;

	public CircleSquarePattern( double length )
	{
		pencil = new DrawingTool( new SketchPad(600, 600) );
		pencil.setWidth(5);
		this.drawPattern( 10, length );
	}
	/**
	 * @param  depth   level of recursion
	 */
	public void drawPattern(int depth, double length) {
		if (depth != 0 ){
			draw(length);
			depth--;
			length = length*Math.sqrt(2)/2;
			drawPattern(depth,length);
		}
	}
	public void draw(double diamSide)
	{
		//Draw circle
		pencil.up();
		pencil.move(0, 0);
		pencil.down();
		pencil.setColor(Color.red);
		pencil.setWidth(2);
		pencil.drawCircle(diamSide/2);
		pencil.up();

		//Draw square
		pencil.setColor(Color.blue);
		pencil.move(0, -diamSide/2);
		pencil.setDirection(90);
		pencil.setWidth(2);
		pencil.down();
		pencil.turn(-90);
		pencil.move(diamSide/2);
		pencil.turn(90);
		pencil.move(diamSide);
		pencil.turn(90);
		pencil.move(diamSide);
		pencil.turn(90);
		pencil.move(diamSide);
		pencil.turn(90);
		pencil.move(diamSide/2);
	}
}