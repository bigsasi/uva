import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int participants = sc.nextInt();
			int budget = sc.nextInt();
			int hotels = sc.nextInt();
			int weeks = sc.nextInt();

			int[] price = new int[hotels];
			int[][] rooms = new int[hotels][weeks];

			for (int i = 0; i < hotels; i++) {
				price[i] = sc.nextInt();
				for (int j = 0; j < weeks; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}

			int minCost = budget + 1;

			for (int i = 0; i < hotels; i++) {
				for (int j = 0; j < weeks; j++) {
					if (rooms[i][j] >= participants) {
						int currentPrice = participants * price[i];
						if (currentPrice < minCost) {
							minCost = currentPrice;
						}
					}
				}
			}

			if (minCost > budget) {
				System.out.println("stay home");
			} else {
				System.out.println(minCost);
			}
		}
	}
}