import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	int[] city;

	void run() {
		Scanner sc = new Scanner(System.in);

		city = new int[10000];

		while (sc.hasNextInt()) {
			int left = sc.nextInt();
			int high = sc.nextInt();
			int rigth = sc.nextInt();

			for (int i = left - 1; i < rigth - 1; i++) {
				if (high > city[i]) {
					city[i] = high;
				}
			}
		}

		int high = city[0];
		System.out.printf("1 %d", high);
		for (int i = 0; i < 10000; i++) {
			if (high != city[i]) {
				high = city[i];
				System.out.printf(" %d %d", i + 1, high);
			}
		}
		System.out.printf("\n");
		
	}
}