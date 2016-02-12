import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int height = sc.nextInt();
			int workers = sc.nextInt();

			if (height == 0) 
				break;

			if (height == 1 && workers == 1) {
				System.out.println("0 1");
				continue;
			}

			ArrayList<Integer> factorsHeight = factorize(height);
			ArrayList<Integer> factorsWorkers = factorize(workers);

			int heightMCD = factorsMCD(factorsHeight);
			int workersMCD = factorsMCD(factorsWorkers);

			/*System.out.println("Factors height: "); 
			for (int i = 0; i < factorsHeight.size(); i++) System.out.println(factorsHeight.get(i));
			System.out.println("Common power: " + heightMCD);

			System.out.println("Factors workers: "); 
			for (int i = 0; i < factorsWorkers.size(); i++) System.out.println(factorsWorkers.get(i));
			System.out.println("Common power: " + workersMCD);
*/
			int minFactorHeight = initialFactor(factorsHeight);
			int minFactorWorkers = initialFactor(factorsWorkers);


			int power = MCD(workersMCD, heightMCD);

			if (workers == 1) {
				heightMCD = workersMCD;
			}

			int realFactorWorkers = minFactorWorkers;
			int realFactorHeight = minFactorHeight;
			if (workersMCD != heightMCD) {
				realFactorWorkers = (int) Math.pow(minFactorWorkers,(int) (workersMCD / power));
				realFactorHeight = (int) Math.pow(minFactorHeight, (int) (heightMCD / power));
			}


			int aux = realFactorHeight;
			int levels = 1;
			while (aux != height) {
				levels++;
				aux *= realFactorHeight;
			}

		 	// System.out.println("Factors: " + realFactorHeight + " " + realFactorWorkers);

			int numCats = 0;
			for (int i = 0; i < levels; i++) {
				numCats += Math.pow(realFactorWorkers, i);
				//System.out.println("numCats: " + numCats);
			}

			int totalHeight = height;
			for (int i = 1; i <= levels; i++) {
				height /= (1 + realFactorWorkers);
				totalHeight += height * Math.pow(realFactorWorkers, i);
//				System.out.println("height: " + height + " total: " + totalHeight);
			}

			System.out.println(numCats + " " + totalHeight);
//			System.out.println();
		}
	}

	int initialFactor(ArrayList<Integer> factors) {
		int mcd = factorsMCD(factors);

		ArrayList<Integer> distint = distintFactors(factors);
		ArrayList<Integer> powers = factorsPowers(factors);

		int factor = 1;
		for (int i = 0; i < powers.size(); i++) {
			int times = powers.get(i) / mcd;
			for (int j = 1; j <= times; j++) {
				factor *= distint.get(i);
			}
		}

		return factor;
	}

	int factorsMCD(ArrayList<Integer> factors) {
		ArrayList<Integer> powers = factorsPowers(factors);

		int mcd = powers.get(0);
		for (int i = 1; i < powers.size(); i++) {
			mcd = MCD(mcd, powers.get(i));
		}

		return mcd;
	}

	ArrayList<Integer> factorsPowers(ArrayList<Integer> factors) {
		ArrayList<Integer> powers = new ArrayList<Integer>();

		int factor = factors.get(0);
		int power = 1;
		for (int i = 1; i < factors.size(); i++) {
			int newFactor = factors.get(i);
			if (factor == newFactor) {
				power++;
			} else {
				powers.add(power);
				power = 1;
				factor = newFactor;
			}
		}
		powers.add(power);

		return powers;
	}

	ArrayList<Integer> distintFactors(ArrayList<Integer> factors) {
		ArrayList<Integer> distint = new ArrayList<Integer>();

		int factor = factors.get(0);
		distint.add(factor);
		for (int i = 1; i < factors.size(); i++) {
			int newFactor = factors.get(i);
			if (newFactor != factor) {
				distint.add(newFactor);
				factor = newFactor;
			}
		}

		return distint;
	}


	int MCD(int a, int b){
	 	while (a > 0) {
	   		int t = a;
	   		a = b % a;
	   		b = t;
	  	}
		return b;
	}

	int minFactor(ArrayList<Integer> factors) {
		int factor = factors.get(0);
		int minFactor = factor;
		for (int i = 1; i < factors.size(); i++) {
			int newFactor = factors.get(i);
			if (newFactor != factor) {
				minFactor *= newFactor;
				factor = newFactor;
			}
		}

		return minFactor;
	}

	int maxPower(ArrayList<Integer> factors) {
		int factor = factors.get(0);
		int actualPower = 1;
		int maxPower = 0;

		for (int i = 1; i < factors.size(); i++) {
			int newFactor = factors.get(i);
			if (newFactor == factor) {
				actualPower++;
			} else {
				if (actualPower > maxPower) {
					maxPower = actualPower;
				}
				actualPower = 1;
				factor = newFactor;
			}
		}
		return maxPower;
	}

	ArrayList<Integer> factorize(int number) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; number > 1; ) {
			if (number % i == 0) {
				factors.add(i);
				// System.out.println(i);
				number /= i;
			} else {
				i++;
			}
		}
		if (factors.isEmpty()) 
			factors.add(number);

		return factors;
	}
}