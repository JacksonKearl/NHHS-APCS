package kochCurve;

import defaults.SavitchIn;

public class Driver
{
	private static final double RATIO_SIDE = 1.6;
	private static final double DEGREE_OFFSET = 4;
	
	public static void main ( String args [] )
	{
		System.out.print("Enter the radius of the first circle: ");
		double radius = SavitchIn.readLineDouble();
		System.out.print("Enter the shape level: ");
		int lvl = SavitchIn.readLineInt();
		System.out.print("Enter the Koch curve level: ");
		int KochLVL = SavitchIn.readLineInt();
		CoolPattern run = new CoolPattern();
		double length;
		for(int k = 0; k < lvl; k++)
		{
			//draw Circle
			run.drawMeACircle(radius);
			//draw Koch curve
			length = radius * 3/Math.sqrt(3);
			run.inPosition(length,radius,DEGREE_OFFSET*k);
			
			//run.offsetTurn(DEGREE_OFFSET);
			for(int h = 0; h < 3; h++)
			{
				run.drawKoch(length,KochLVL);
				run.turnKoch();
			}
			//reset radius
			radius = length/RATIO_SIDE;
			
		}
	}
}