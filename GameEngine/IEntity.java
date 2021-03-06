package GameEngine;

import battleMechanics.Attack;
import battleMechanics.Body;

public interface IEntity {
	int getSprite();
	void setXY(int x, int y);
	int getX();
	int getY();
	int act(int i);
	void setSprite(int sprite);
	//void attack(int damage,String bodyPart,IEntity attacker);
	int getHealth();
	String getName();
	void setName(String string);
	boolean getControllable();
	void setControllable(boolean controllable);
	int getActionPoints();
	void setActionPoints(int points);
	public boolean initiateTurn();
	public void endTurn();
	public void notOnTurn();
	public Body getBody();
	void attack(Attack a);
	
}
