import java.util.*; 
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Main problem = new Main();

		problem.run();
	}	

	int[][] table;
	int tableSize;

	void initTable(int tableSize) {
		this.tableSize = tableSize;
		table = new int[tableSize][tableSize];

		for (int i = 0; i < tableSize; i++) {
			for (int j = 0; j < tableSize; j++) {
				table[i][j] = -1;
			}
		}
		for (int i = 0; i < tableSize; i++) {
			table[0][i] = i;
		}
	}

	void printTable() {
		for (int i = 0; i < tableSize; i++) {
			String toPrint = i + ":";
			for (int j = 0; j < tableSize; j++) {
				if (table[j][i] != -1) {
					toPrint += " " + table[j][i];
				}
			}
			System.out.println(toPrint);
		}
	}

	int[] findBlock(int block) {
		int[] pos = new int[2];
		for (int i = 0; i < tableSize; i++) {
			for (int j = 0; j < tableSize; j++) {
				if (table[j][i] == block) {
					pos[0] = j;
					pos[1] = i;
					return pos;
				}
				if (table[j][i] == -1) 
					break;
			}
		}

		return pos;
	}


	void run() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		int tableSize = sc.nextInt();
		initTable(tableSize);
		//printTable();

		String line; 
		line = sc.nextLine();
		line = sc.nextLine();
		while (!line.equals("quit")) {
			//System.out.println("line: " + line);
			StringTokenizer st = new StringTokenizer(line);
            String order = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            order += st.nextToken();
            int to = Integer.parseInt(st.nextToken());

            if (order.equals("moveonto"))
            	moveOnto(from, to);
            else if (order.equals("moveover"))
            	moveOver(from, to);
            else if (order.equals("pileonto"))
            	pileOnto(from, to);
            else
            	pileOver(from, to);

            //printTable();

			line = sc.nextLine();
		}
		printTable();
	} 

	void moveOnto(int from, int to) {
		int[] posFrom = findBlock(from);
		int[] posTo = findBlock(to);

		for (int i = posFrom[0] + 1; i < tableSize; i++) {
			if (table[i][posFrom[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}
		for (int i = posTo[0] + 1; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}
		table[posTo[0] + 1][posTo[1]] = from;
		table[posFrom[0]][posFrom[1]] = -1;
	}

	void moveOver(int from, int to) {
		int[] posFrom = findBlock(from);
		int[] posTo = findBlock(to);

		for (int i = posFrom[0] + 1; i < tableSize; i++) {
			if (table[i][posFrom[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}
		/*for (int i = posTo[0] + 1; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}*/
		for (int i = posTo[0] + 1; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1) {
				table[i][posTo[1]] = from;
				break;
			}
		}
		table[posFrom[0]][posFrom[1]] = -1;
	}
	void pileOnto(int from, int to) {
		int[] posFrom = findBlock(from);
		int[] posTo = findBlock(to);

		int[] stack = new int[tableSize];
		for (int i = 0; i < tableSize; i++) stack[i] = -1;
		for (int i = posFrom[0]; i < tableSize; i++) {
			stack[i - posFrom[0]] = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
		}

		for (int i = posTo[0] + 1; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}
		int first = 0;
		for (int i = 0; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1) {
				first = i;
				break;
			}
		}
		for (int i = first; i < tableSize; i++) {
			table[i][posTo[1]] = stack[i - first];
		}

	}
	void pileOver(int from, int to) {
		int[] posFrom = findBlock(from);
		int[] posTo = findBlock(to);

		int[] stack = new int[tableSize];
		for (int i = 0; i < tableSize; i++) stack[i] = -1;
		for (int i = posFrom[0]; i < tableSize; i++) {
			stack[i - posFrom[0]] = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
		}

		/*for (int i = posTo[0] + 1; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1)
				break;
			int block = table[i][posFrom[1]];
			table[i][posFrom[1]] = -1;
			for (int j = 0; j < tableSize; j++) {
				if (table[j][block] == -1) {
					table[j][block] = block;
					break;
				}
			}
		}*/
		int first = 0;
		for (int i = 0; i < tableSize; i++) {
			if (table[i][posTo[1]] == -1) {
				first = i;
				break;
			}
		}
		for (int i = first; i < tableSize; i++) {
			table[i][posTo[1]] = stack[i - first];
		}
	}
}