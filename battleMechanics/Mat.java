package battleMechanics;

public enum Mat {
	skin, scale, bone, skull, exoskeleton, brain, flesh, fat, muscle, airway, heart, intestines, tendon, wind_pipe, iron, steel, bronze,;

	public static double resistance(Mat mat) {
		switch (mat) {
		case skin:
			return 5;
		case scale:
			return 100;
		case bone:
			return 30;
		case skull:
			return 30;
		case exoskeleton:
			return 30;
		case brain:
			return 1;
		case flesh:
			return 10;
		case fat:
			return 5;
		case muscle:
			return 10;
		case airway:
			return 2;
		case heart:
			return 2;
		case intestines:
			return 1;
		case iron:
			return 50;
		case steel:
			return 100;
		case bronze:
			return 70;

		}
		return 0;
	}
}
