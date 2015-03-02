package battleMechanics;

import java.util.ArrayList;

public class BodyPart {
	private String name;
	private ArrayList<Organ> organs = new ArrayList<>();
	private ArrayList<Wound> wounds = new ArrayList<>();
	private String clothes = null;
	private String armor = null;
	private int importance;
	private boolean severed = false;
	private ArrayList<BodyPart> bodyParts = new ArrayList<BodyPart>();

	public BodyPart(String name, Organ[] organs, int importance) {
		this.name = name;
		for (Organ o : organs) {
			this.organs.add(o);
		}

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
		if (severed == false) {
			if (a.getAttackType() == Attack.AttackType.slash) {
				int i = organs.size()-1;
				Organ o = null;
				if (i <= 0) {
					System.out.println("Can not attack Incorporeal parts");
				} else {
					while (a.getForce() > 0 && a.getDepth() > 0 && severed == false) {
						
						if (i == -1)
						{
							System.out.println("body part severed!");
							sever();
						}
						else
						{
							o = organs.get(i);
						}
						if (o.getResistance() < a.getForce()) {
							a.setDepth(a.getDepth() - o.getDepth());
							a.setForce(a.getForce() - o.getResistance());
							wounds.add(new Wound(o.getBloodPressure()));
							System.out.println("Attack goes trough "+o+"!");
							i--;
						}

					}
				}

			}
		}
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

}
