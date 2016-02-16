import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int duration = sc.nextInt();
			double downPayment = sc.nextDouble();
			double value = sc.nextDouble();
			int numDeprecations = sc.nextInt();
			double remainPayment = value;

			if (duration < 0) {
				return;
			}

			double[] deprecations = new double[duration]; 

			int index = sc.nextInt();
			double deprecation = sc.nextDouble();

			for (int j = 0; j < duration; j++) {
				deprecations[j] = deprecation;
			}

			double payment = value / duration;
			value = (value + downPayment) * (1 - deprecation);


			for (int i = 1; i < numDeprecations; i++) {
				index = sc.nextInt();
				deprecation = sc.nextDouble();

				for (int j = index - 1; j < duration; j++) {
					deprecations[j] = deprecation;
				}
			}

			int numMonths = 0;
			while (value <= remainPayment) {
				// System.out.println("Value: " + value + " Remain: " + remainPayment);
				value *= (1 - deprecations[numMonths]);
				remainPayment -= payment;
				numMonths++;
			}
			
			// System.out.println("Value: " + value + " Remain: " + remainPayment);

			if (numMonths != 1) 
				System.out.println(numMonths + " months");
			else 
				System.out.println(numMonths + " month");
		}
	}
}