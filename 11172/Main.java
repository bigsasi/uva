import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		int numberInputs = sc.nextInt();

		for (int i = 0; i < numberInputs; i++) {
			int number1 = sc.nextInt();
			int number2 = sc.nextInt();

			if (number1 < number2) 
				System.out.println("<");
			if (number2 < number1) 
				System.out.println(">");
			if (number1 == number2)
				System.out.println("=");
		}
	}
}