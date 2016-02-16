import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();
		problem.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in); 

		int numCases = sc.nextInt();

		do {

			int xDiv = sc.nextInt();
			int yDiv = sc.nextInt();

			for (int i = 0; i < numCases; i++) {
				int xCase = sc.nextInt();
				int yCase = sc.nextInt();

				if (xCase == xDiv || yCase == yDiv)
					System.out.println("divisa");
				else if (xCase > xDiv)
					if (yCase > yDiv) 
						System.out.println("NE");
					else
						System.out.println("SE");
				else if (yCase > yDiv) 
					System.out.println("NO");
				else
					System.out.println("SO");
			}

			numCases = sc.nextInt();
		} while (numCases != 0);
	}
}