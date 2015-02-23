package battleMechanics;

import GameEngine.IEntity;

public class Attack {
	private double accuracy;
	private double force;
	private double depth;
	private double sharpness;
	private double weight;
	public enum attackType{slash,stab,strike}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public double getForce() {
		return force;
	}
	public void setForce(double force) {
		this.force = force;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getSharpness() {
		return sharpness;
	}
	public void setSharpness(double sharpness) {
		this.sharpness = sharpness;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public IEntity getAttacker() {
		// TODO Auto-generated method stub
		return null;
	}
}
