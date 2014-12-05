package coolSet3;

public class FlowRate {
	private double initialHeight;
	private double areaOpening;
	private double areaBase;
	private final double GRAVITY = 32.1740;
	
	/**
	 * Initialize emptying cylinder scenario.
	 * @param height     Initial height in feet
	 * @param baseDiam   Diameter of cylinder
	 * @param openDiam   Diameter of opening
	 */
	public FlowRate(double height, double baseDiam, double openDiam){
		initialHeight = height;
		areaOpening = diameterToArea(openDiam);
		areaBase = diameterToArea(baseDiam);
	}
	
	/**
	 * 
	 * @param t   Time since opening valve (seconds)
	 * @return    Volume remaining (cubic feet)
	 */
	public double getVolumeAtTime(double t){
		double height = (Math.sqrt(initialHeight)-(t*areaOpening*Math.sqrt(2*GRAVITY))/(2*areaBase));
		height *= height;
		double volume = areaBase*height;
		return volume;
	}
	
	/**
	 * 
	 * @return Time (seconds) until Volume is equal to 0;
	 */
	public double getTimeTillEmpty(){
		return areaBase*Math.sqrt(2*initialHeight)/(areaOpening*Math.sqrt(GRAVITY));
	}
	
	private double diameterToArea(double diam){
		return Math.PI*(diam/2)*(diam/2);
	}

}
