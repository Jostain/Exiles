package battleMechanics;

public class Organ {
	private String name;
	private Mat mat;
	private double depth;
	private double bloodPressure;
	private boolean vital;
	public Organ(boolean vital, Mat mat, double depth, double bloodPressure,String name)
	{
	this.setVital(vital);
	this.name = name;	
	this.mat = mat;
	this.depth = depth;
	this.bloodPressure = bloodPressure;
	}
	public double getResistance() {
		return Mat.resistance(mat);
	}
	public void setMat(Mat mat) {
		this.mat = mat;
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
	public boolean isVital() {
		return vital;
	}
	public void setVital(boolean vital) {
		this.vital = vital;
	}
	

}
