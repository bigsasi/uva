import java.util.*;

public class Main{
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int numCases = sc.nextInt();

		for (int i = 0; i < numCases; i++) {
			int salary1 = sc.nextInt();
			int salary2 = sc.nextInt();
			int salary3 = sc.nextInt();

			int maxSalary = Math.max(salary3, Math.max(salary2, salary1));
			int minSalary = Math.min(salary3, Math.min(salary1, salary2));

			if (salary1 != maxSalary && salary1 != minSalary) {
				System.out.println("Case " + (i + 1) + ": " + salary1);				
			} else if (salary2 != maxSalary && salary2 != minSalary) {
				System.out.println("Case " + (i + 1) + ": " + salary2);				
			} else if (salary3 != maxSalary && salary3 != minSalary) {
				System.out.println("Case " + (i + 1) + ": " + salary3);				
			}
		}
	}
}