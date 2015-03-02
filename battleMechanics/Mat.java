package battleMechanics;

public enum Mat {
	skin, scale, bone, skull, exoskeleton, brain, flesh, fat, muscle, airway, heart, intestines, tendon;

	public static double resistance(Mat mat) {
		switch (mat) {
		case skin:
			return 5;
		case scale:
			return 100;
		case bone:
			return 5;
		case skull:
			return 5;
		case exoskeleton:
			return 5;
		case brain:
			return 5;
		case flesh:
			return 5;
		case fat:
			return 5;
		case muscle:
			return 5;
		case airway:
			return 5;
		case heart:
			return 5;
		case intestines:
			return 5;

		}
		return 0;
	}
}
