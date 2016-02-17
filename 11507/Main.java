import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int length = sc.nextInt();
			
			if (length == 0) 
				break;
			sc.nextLine();

			String line = sc.nextLine();
			String[] orders = line.split(" ");

			int dir = 0;
			// System.out.println(line);

			for (int i = 0; i < orders.length; i++) {
				String order = orders[i];
				if (order.equals("No")) 
					continue;

				if (order.equals("+y")) {
					if (dir == 0) 
						dir = 1;
					else if (dir == 2)
						dir = 3;
					else if (dir == 1) 
						dir = 2;
					else if (dir == 3)
						dir = 0; 
				}
				if (order.equals("-y")) {
					if (dir == 0) 
						dir = 3;
					else if (dir == 2)
						dir = 1;
					else if (dir == 1) 
						dir = 0;
					else if (dir == 3)
						dir = 2;	
				}
				if (order.equals("+z")) {
					if (dir == 0) 
						dir = 5;
					else if (dir == 2)
						dir = 4;
					else if (dir == 5) 
						dir = 2;
					else if (dir == 4) 
						dir = 0;
				}
				if (order.equals("-z")) {
					if (dir == 0) 
						dir = 4;
					else if ( dir == 2)
						dir = 5;
					else if (dir == 5) 
						dir = 0;
					else if (dir == 4) 
						dir = 2;
				}
				// System.out.println(dir);
			}

			String direction = "";
			switch (dir) {
				case 0: 
					direction = "+x";
					break;
				case 1:
					direction = "+y";
					break;
				case 2:
					direction = "-x";
					break;
				case 3:
					direction = "-y";
					break;
				case 4:
					direction = "-z";
					break;
				case 5:
					direction = "+z";
					break;
			}

			System.out.println(direction);
		}
	}
}