import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int caseNumber = 0;

		while (true) {
			int numberReq = sc.nextInt();
			int numberProp = sc.nextInt();

			caseNumber++;

			if (numberReq == 0) {
				break;
			}
			if (caseNumber > 1) {
				System.out.println();
			}

			sc.nextLine();

			for (int i = 0; i < numberReq; i++) {
				String rubber = sc.nextLine();
			}

			int bestProposal = -1; 
			ArrayList<Proposal> proposalList = new ArrayList<Proposal>(numberProp);
			for (int i = 0; i < numberProp; i++) {
				String name = sc.nextLine();
				// System.out.println(name);
				double price = sc.nextDouble();
				int metRequirements = sc.nextInt();
				sc.nextLine();

				if (metRequirements > bestProposal) {
					bestProposal = metRequirements;
				}

				Proposal p = new Proposal(name, price, metRequirements);
				proposalList.add(p);
				for (int j = 0; j < metRequirements; j++) {
					String rubber = sc.nextLine();
				}
			}

			double minPrice = Double.MAX_VALUE;
			Proposal selected = null;
			for (Proposal p: proposalList) {
				if (p.metRequirements == bestProposal) {
					if (p.price < minPrice) {
						selected = p;
						minPrice = p.price;
					}
				}
			}

			System.out.println("RFP #" + caseNumber);
			System.out.println(selected.name);
		}
	}
}

class Proposal {
	String name;
	double price;
	int metRequirements;

	public Proposal(String name, double price, int metRequirements) {
		this.name = name;
		this.price = price;
		this.metRequirements = metRequirements;
	}
}