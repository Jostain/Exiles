package battleMechanics;

public class Organ {
	private String name;
	private double resistance;
	private double depth;
	private double bloodPressure;
	public Organ(double resistance, double depth, double bloodPressure,String name)
	{
	this.name = name;	
	}
	public double getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public double getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String toString()
	{
		return name;
		
	}
	

}
