import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main p = new Main();
		p.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int numCases = sc.nextInt();

		for (int i = 1; i <= numCases; i++) {
			int numRunners = sc.nextInt();

			int clownSpeed = -1;
			for (int j = 0; j < numRunners; j++) {
				clownSpeed = Math.max(clownSpeed, sc.nextInt());
			}

			System.out.println("Case " + i + ": " + clownSpeed);
		}
	}
}