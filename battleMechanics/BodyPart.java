package battleMechanics;

import java.util.ArrayList;

public class BodyPart {
	private String name;
	private Body body;
	private ArrayList<Organ> organs = new ArrayList<>();
	private ArrayList<Wound> wounds = new ArrayList<>();
	private Mat clothes = null;
	private Mat armor = null;
	private int importance;
	private boolean severed = false;
	private boolean mobile;
	private boolean requiredForMobility;
	private ArrayList<BodyPart> bodyParts = new ArrayList<BodyPart>();

	public BodyPart(String name, Organ[] organs, int importance, boolean RFM) {
		this.name = name;
		this.requiredForMobility = RFM;
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
		for (Organ o : organs) {
			if (o.isVital()) {
				body.setAlive(false);
			}
		}
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

	public Mat getClothes() {
		return clothes;
	}

	public void setClothes(Mat mat) {
		this.clothes = mat;
	}

	public Mat getArmor() {
		return armor;
	}

	public void setArmor(Mat armor) {
		this.armor = armor;
	}

	public void attackBodyPart(Attack a) {
		if (severed == false) {
			if (a.getAttackType() == Attack.AttackType.slash) {
				int i = organs.size() - 1;
				Organ o = null;
				if (i <= 0) {
					System.out.println("Can not attack Incorporeal parts");
				} else {
					if (armor != null) {
						if (a.getForce() > Mat.resistance(armor)) {
							a.setForce(a.getForce() - Mat.resistance(armor));
							System.out.println("Attack goes trough " + armor
									+ "armor!");
						} else {
							System.out.println("Attack bounces of the " + armor
									+ " armor");
							a.setForce(0);
						}
					}
					while (a.getForce() > 0 && a.getDepth() > 0
							&& severed == false) {

						if (i == -1) {
							System.out.println(name + " severed!");
							sever();
						} else {
							o = organs.get(i);
							if (o.getResistance() < a.getForce()) {
								a.setDepth(a.getDepth() - o.getDepth());
								a.setForce(a.getForce() - o.getResistance());
								System.out.println("Attack goes trough " + o
										+ "!");
								wounds.add(new Wound(o.getBloodPressure()));

								i--;
							} else {
								a.setForce(0.0);
							}
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

	public double pollBloodLoss() {
		double temp = 0;
		for (Wound w : wounds) {
			temp = temp + w.getBleed();
		}
		for (BodyPart p : bodyParts) {
			temp = temp + p.pollBloodLoss();
		}

		return temp;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}
}
