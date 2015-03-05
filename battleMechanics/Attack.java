package battleMechanics;

import GameEngine.IEntity;

public class Attack {
	private String targetBodyPart;
	private double accuracy;
	private double force;
	private double depth;
	private double sharpness;
	private double weight;
	private AttackType attackType;
	public enum AttackType{slash,stab,strike}
	public Attack(AttackType attackType, double force, double depth, double sharpness, double weight,String bodyPart)
	{
		this.attackType = attackType;
		this.force = force;
		this.depth = depth;
		this.sharpness = sharpness;
		this.weight = weight;
		this.targetBodyPart = bodyPart;
		System.out.println(targetBodyPart);

	}
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
	public AttackType getAttackType() {
		return attackType;
	}
	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}
	public String getTargetBodyPart() {
		return targetBodyPart;
	}
	public void setTargetBodyPart(String targetBodyPart) {
		this.targetBodyPart = targetBodyPart;
	}
}
