package battleMechanics;

import java.awt.List;
import java.util.ArrayList;

public class Body {
	private String owner;
	private int numberOfBodyParts = 0;
	private BodyPart soul = new BodyPart("soul",new Organ[]{},100, false);
	private double blood = 100.0;
	private double bloodLimitConciousness = 40.0;
	private double bloodLimitAlive = 50.0;
	private boolean concious = true;
	private boolean alive = true;
	private boolean prone = false;
	private ArrayList<BodyPart> requiredForMobility = new ArrayList<>();
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
		if(part.isRFM())
		{
			requiredForMobility.add(part);
		}
		part.setBody(this);
		soul.getBodyPart(from).growBodyPart(part);
		numberOfBodyParts ++;
		System.out.println(numberOfBodyParts);
	}
	public void severBodyPart(String name)
	{
		soul.getBodyPart(name).sever();
	}
	public String toString()
	{
		return owner+"'s "+"body";
		
	}
	public String attackBody(Attack a) {
		System.out.println(a.getTargetBodyPart());
		return soul.getBodyPart(a.getTargetBodyPart()).attackBodyPart(a);
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
		if (getAlive()){
			blood =blood- soul.pollBloodLoss();
			if (blood < bloodLimitConciousness && concious != false)
			{
				//System.out.println(owner+" has lost conciousness From blood loss!");
				concious = false;
			}
			if (blood < bloodLimitAlive)
			{
				this.setAlive(false);
			//	System.out.println(owner+" has died From their injuries!");
			}
			for(BodyPart bp:requiredForMobility)
			{
				if(bp.isRFM() && (bp.isUsable()||bp.isSevered())&& prone!=true)
				{
					setProne(true);
					//System.out.println(owner+" has fallen prone due to their injuries");
				}
			}
		}
		else
		{
			
		}
		
	}
	public boolean isProne() {
		return prone;
	}
	public void setProne(boolean prone) {
		this.prone = prone;
	}
	
	public ArrayList<String> getBodyParts()
	{
		return null;
		
	}

}
