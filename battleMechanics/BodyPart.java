package battleMechanics;

import java.util.ArrayList;

public class BodyPart {
	private String name;
	private Organ[] mats;
	private Wound[] wounds;
	private String clothes = null;
	private String armor = null;
	private int importance;
	private boolean severed = false;
	private ArrayList<BodyPart> bodyParts = new ArrayList<BodyPart>();

	public BodyPart(String name, Organ[] organs, int importance) {
		this.name = name;
		this.mats = organs;
		this.setImportance(importance);

	}

	public BodyPart getBodyPart(String name) {
		if (this.name == name) {
			return this;
		} else {
			for (BodyPart p : bodyParts) {
				BodyPart temp = p.getBodyPart(name);
				if (temp != null) {
					return temp;
				}
			}
			return null;

		}

	}

	public ArrayList<BodyPart> getBodyParts() {
		return bodyParts;
	}

	public void growBodyPart(BodyPart part) {
		bodyParts.add(part);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sever() {
		severed = true;
		for (BodyPart p : bodyParts) {
			p.sever();
		}
		System.out.println(name + " Lost!");

	}

	public boolean isSevered() {
		return severed;
	}

	public void setSevered(boolean severed) {
		this.severed = severed;
	}

	public String getClothes() {
		return clothes;
	}

	public void setClothes(String clothes) {
		this.clothes = clothes;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public void attackBodyPart(Attack a) {
		double realForce = a.getForce() * a.getAccuracy();
		

	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
	
}
