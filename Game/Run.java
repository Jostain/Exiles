package Game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Renderer.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import battleMechanics.Attack;
import battleMechanics.Attack.AttackType;
import battleMechanics.Body;
import battleMechanics.BodyPart;
import battleMechanics.Mat;
import battleMechanics.Organ;
import GameEngine.*;
import Renderer.GameField;

public class Run extends JFrame {
	Announcer announcer = new Announcer();
	Grid grid = new Grid(45, 45);
	IEntity player = new Human(grid,announcer, null, "Player", true, 1);
	GameField world = new GameField(grid);
	
	boolean attacking = false;
	int currentActor = 0;
	KeyListener kevin = new KeyListener();
	int key = -1;
	boolean gameOver = false;
	JPanel overlay = new JPanel();

	public Run() {
		overlay.setLayout(new BorderLayout());
		overlay.add(announcer, BorderLayout.SOUTH);
		overlay.add(world, BorderLayout.NORTH); // add transparent panel first
		
		add(overlay);


		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		repaint();
		this.requestFocus();
		player.setSprite(1);
		addKeyListener(kevin);
		//Body body = new Body("Character");

		grid.setWalkable(10, 10, false);
		grid.setTileType(10, 10, 0);
		grid.updatePaths();
		grid.customPath(3, 10, 11, 5, 5);
		grid.setVisible(10, 11, false);
		System.out.println("");
		System.out.println((grid.getPath(0, 0, 5, 5)));
		System.out.println(grid.addEntity(1, 1, player));
		System.out.println(grid.addEntity(21, 21, new Human(grid,announcer, player,
				"Enemy", false, 7)));
		System.out.println(grid.addEntity(1, 1, new Human(grid,announcer, null, "Player",
				true, 1)));
		System.out.println(grid.addEntity(25, 25, new Human(grid,announcer, player,
				"Enemy", false, 7)));
		loop();
	}

	public void loop() {
		int timerDelay = 20;
		new Timer(timerDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.act(key);
				key = -1;
				repaint();
			}
		}).start();
	}

	public class KeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent kev) {
			if (kev.getKeyCode() == KeyEvent.VK_UP) {
				key = 0;
				// System.out.println("up");
			} else if (kev.getKeyCode() == KeyEvent.VK_DOWN) {
				key = 2;// System.out.println("down");
			} else if (kev.getKeyCode() == KeyEvent.VK_LEFT) {
				key = 3;// System.out.println("left");
			} else if (kev.getKeyCode() == KeyEvent.VK_RIGHT) {
				key = 1;// System.out.println("right");
			} else if (kev.getKeyCode() == KeyEvent.VK_A) {
				key = 4;// System.out.println("A");
			} else if (kev.getKeyCode() == KeyEvent.VK_ENTER) {
				key = 5;// System.out.println("enter");
			} else {
				key = -1;
			}

		}
	}

	public static void bodyTest() {
		Body body = new Body("Character");
		Organ skin = new Organ(false, Mat.skin, 0.5, 2, "skin");
		Organ fat = new Organ(false, Mat.fat, 2.0, 2, "fat");
		Organ muscle = new Organ(false, Mat.muscle, 10, 2, "muscle");
		Organ bone = new Organ(false, Mat.bone, 5, 10, "bone");
		Organ wind_pipe = new Organ(true, Mat.wind_pipe, 5, 10, "windpipe");
		Organ brain = new Organ(true, Mat.brain, 5, 5, "brain");
		body.growBodypart(new BodyPart("head",
				new Organ[] { brain, bone, skin }, 0, false), "soul");
		body.growBodypart(new BodyPart("neck",
				new Organ[] { bone, muscle, skin }, 0, false), "head");
		body.growBodypart(new BodyPart("torso", new Organ[] { bone, wind_pipe,
				muscle, fat, skin }, 0, false), "neck");
		body.growBodypart(new BodyPart("left_shoulder", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "torso");
		body.growBodypart(new BodyPart("left_upper_arm", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "left_shoulder");
		body.growBodypart(new BodyPart("left_lower_arm", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "left_upper_arm");
		body.growBodypart(new BodyPart("left_hand", new Organ[] { bone, muscle,
				fat, skin }, 0, false), "left_lower_arm");
		body.growBodypart(new BodyPart("right_shoulder", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "torso");
		body.growBodypart(new BodyPart("right_upper_arm", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "right_shoulder");
		body.growBodypart(new BodyPart("right_lower_arm", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "right_upper_arm");
		body.growBodypart(new BodyPart("right_hand", new Organ[] { bone,
				muscle, fat, skin }, 0, false), "right_lower_arm");
		body.growBodypart(new BodyPart("left_tigh", new Organ[] { bone, muscle,
				fat, skin }, 0, true), "torso");
		body.growBodypart(new BodyPart("left_knee", new Organ[] { bone, muscle,
				fat, skin }, 0, true), "left_tigh");
		body.growBodypart(new BodyPart("left_shin", new Organ[] { bone, muscle,
				fat, skin }, 0, true), "left_knee");
		body.growBodypart(new BodyPart("left_fot", new Organ[] { bone, muscle,
				fat, skin }, 0, true), "left_shin");
		body.growBodypart(new BodyPart("right_tigh", new Organ[] { bone,
				muscle, fat, skin }, 0, true), "torso");
		body.growBodypart(new BodyPart("right_knee", new Organ[] { bone,
				muscle, fat, skin }, 0, true), "right_tigh");
		body.growBodypart(new BodyPart("right_shin", new Organ[] { bone,
				muscle, fat, skin }, 0, true), "right_knee");
		body.growBodypart(new BodyPart("right_fot", new Organ[] { bone, muscle,
				fat, skin }, 0, true), "right_shin");
		body.armor("left_shoulder", Mat.steel);
		body.attackBody(new Attack(AttackType.slash, 200.0, 100.0, 100.0,
				100.0, "left_shoulder"));
		System.out.println("");
		System.out.println("");
		System.out.println("");
		body.attackBody(new Attack(AttackType.slash, 100.0, 100.0, 100.0,
				100.0, "right_knee"));
		System.out.println("");
		System.out.println("");
		System.out.println(body.pollBloodLoss());
		System.out.println("Alive = " + body.getAlive());
		body.simulateBody();
		body.simulateBody();
		body.simulateBody();
		body.simulateBody();
	}

	public static void main(String[] args) {
		//bodyTest();
		 //attackType, force, depth, sharpness, weight

		 SwingUtilities.invokeLater(new Runnable() {
		 public void run() {

		 JFrame window = new Run();
		 }
		 });
	}
}
