import java.util.*;


public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int b1 = sc.nextInt();
			int g1 = sc.nextInt();
			int c1 = sc.nextInt();

			int b2 = sc.nextInt();
			int g2 = sc.nextInt();
			int c2 = sc.nextInt();

			int b3 = sc.nextInt();
			int g3 = sc.nextInt();
			int c3 = sc.nextInt();

			int minMov = movementGCB(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			String minString = "GCB";

			int movement = movementGBC(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			if (movement <= minMov) {
				minMov = movement;
				minString = "GBC";
			}

			movement = movementCGB(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			if (movement <= minMov) {
				minMov = movement;
				minString = "CGB";
			}

			movement = movementCBG(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			if (movement <= minMov) {
				minMov = movement;
				minString = "CBG";
			}

			movement = movementBGC(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			if (movement <= minMov) {
				minMov = movement;
				minString = "BGC";
			}

			movement = movementBCG(g1, b1, c1, g2, b2, c2, g3, b3, c3);
			if (movement <= minMov) {
				minMov = movement;
				minString = "BCG";
			}
			System.out.println(minString + " " + minMov);
		}
	}

	int movementGCB(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return g2 + g3 + c1 + c3 + b1 + b2;
	}

	int movementGBC(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return g2 + g3 + b1 + b3 + c1 + c2;
	}

	int movementCGB(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return c2 + c3 + g1 + g3 + b1 + b2;
	}

	int movementCBG(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return c2 + c3 + b1 + b3 + g1 + g2;
	}

	int movementBGC(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return b2 + b3 + g1 + g3 + c1 + c2;
	}

	int movementBCG(int g1, int b1, int c1, int g2, int b2, int c2, int g3, int b3, int c3) {
		return b2 + b3 + c1 + c3 + g1 + g2;
	}

}