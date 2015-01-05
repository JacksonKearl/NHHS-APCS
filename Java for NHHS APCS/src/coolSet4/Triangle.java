package coolSet4;

public class Triangle {
	private double _a;
	private double _b;
	private double _c;
	
	public static void main( String args [ ] ){
		Triangle equilateral = new Triangle(5.0);
		Triangle scalene = new Triangle(5, 13, 12);
		
		System.out.println(equilateral);
		System.out.println(scalene);
	}
	
	public Triangle(double a) {
		_a = a;
		_b = a;
		_c = a;
	}
	
	public Triangle(double a, double b, double c){
		_a = a;
		_b = b;
		_c = c;
	}
	
	public double area(){
		double semi = (_a + _b + _c)/2;
		double area = Math.sqrt(semi*(semi-_a)*(semi-_b)*(semi-_c));
		return area;
	}
	
	public String toString() {
		return "Triangle Description:\n" + 
					"Side A: " + _a + "\n" + 
					"Side B: " + _b + "\n" +
					"Side C: " + _c + "\n" +
					"Area: " + area()+"\n";
		
	}
	
}
