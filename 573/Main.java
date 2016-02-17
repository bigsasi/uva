import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		m.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			double height = sc.nextDouble();
			double climb = sc.nextDouble();
			double slide = sc.nextDouble();
			double fatigue = sc.nextDouble();

			if (height != 0) {
				snail(height, climb, slide, fatigue);
			} else {
				return;
			}
		}
	}

	void snail(double height, double climb, double slide, double fatigue) {
		double position = 0;
		double loose = fatigue / 100 * climb;
		for (int i = 1; ; i++) {
			position = position + climb;
			if (position > height) {
				System.out.println("success on day " + i);
				break;
			}
			position = position - slide;
			if (position < 0) {
				System.out.println("failure on day " + i);
				break;
			}
			climb -= loose;
			if (climb < 0) {
				climb = 0;
			}
		}
	}
}