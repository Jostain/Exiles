package battleMechanics;

import java.util.ArrayList;

public class Body {
	private String owner;
	private BodyPart soul = new BodyPart("soul",new Organ[]{},100, false);
	private double blood = 100.0;
	private double bloodLimitConciousness = 40.0;
	private double bloodLimitAlive = 50.0;
	private boolean concious = true;
	private boolean alive = true;
	public Body(String owner)
	{
		this.owner=owner;
	}
	public boolean armor(String bodyPart, Mat mat)
	{
		soul.getBodyPart(bodyPart).setArmor(mat);
		return true;
	}
	public boolean dress(String bodyPart, Mat mat)
	{
		soul.getBodyPart(bodyPart).setClothes(mat);
		return alive;
	}
	
	public void growBodypart(BodyPart part, String from)
	{		
		part.setBody(this);
		soul.getBodyPart(from).growBodyPart(part);
		//System.out.println(from+" grew a "+part.getName()+"!");
	}
	public void severBodyPart(String name)
	{
		soul.getBodyPart(name).sever();
	}
	public String toString()
	{
		return null;
		
	}
	public void attackBody(Attack a) {
		soul.getBodyPart(a.getTargetBodyPart()).attackBodyPart(a);;
		
	}
	public double getBlood() {
		return blood;
	}
	public void setBlood(double blood) {
		this.blood = blood;
	}
	public double pollBloodLoss()
	{
		return soul.pollBloodLoss();
	}
	public double getBloodLimitConciousness() {
		return bloodLimitConciousness;
	}
	public void setBloodLimitConciousness(double bloodLimitConciousness) {
		this.bloodLimitConciousness = bloodLimitConciousness;
	}
	public double getBloodLimitAlive() {
		return bloodLimitAlive;
	}
	public void setBloodLimitAlive(double bloodLimitAlive) {
		this.bloodLimitAlive = bloodLimitAlive;
	}
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isConcious() {
		return concious;
	}
	public void setConcious(boolean concious) {
		this.concious = concious;
	}
	public void simulateBody()
	{
		if (alive = true){
			blood =blood- soul.pollBloodLoss();
			if (blood < bloodLimitConciousness)
			{
				System.out.println(owner+" has lost conciousness From blood loss!");
				concious = false;
			}
			if (blood < bloodLimitAlive)
			{
				alive = false;
				System.out.println(owner+" has died From their injuries!");
			}
		}
		
	}

}
