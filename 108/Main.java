import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	int size;
	int[][] matrix;

	void run() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
		size = sc.nextInt();

		matrix = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		int maxSum = sumMatrix(0, 0, size - 1, size - 1);
		int[] pos = new int[4];
		int possibleMax;

		int aux = 0;
		for (int k = size; k > 0; k--) {
			possibleMax = k * size * 127;
			if (maxSum > possibleMax) {
				break;
			}
			for (int m = size; m > 0; m--) {
				possibleMax = k * m * 127;
				if (maxSum > possibleMax) {
					break;
				}
				
				int maxChange = 2 * 127 * k;
				for (int i = 0; i <= size - k; i++) {
					int sum = sumMatrix(i, 0, i + k - 1, 0 + m - 1); 
					if (sum > maxSum) {
						maxSum = sum;
					}
					if (sum + maxChange <= maxSum) {
						continue;
					}
					for (int j = 1; j <= size - m; j++) {
						sum = sum - sumMatrix(i, j - 1, i + k -1, j - 1) + sumMatrix(i, j + m -1, i + k -1, j + m - 1);
						if (sum > maxSum) {
							maxSum = sum;
						}
					}
				} 

			}
		}

		System.out.println(maxSum);
		}
	}

	int sumMatrix(int i, int j, int k, int m) {
		int sum = 0;
		for (int ii = i; ii <= k; ii++) {
			for (int jj = j; jj <= m; jj++) {
				sum += matrix[ii][jj];
			}
		}
		return sum;
	}
}