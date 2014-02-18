import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.String.valueOf;
import static java.lang.System.out;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Code {

	private static class Location {
		// Helps with locations
		public int x, y, z;

		public Location(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	private static Map<String, Location> hex;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		init();
		Scanner scanner = new Scanner(new File("prob19-set1-in.txt"));
		int reps = parseInt(scanner.nextLine());
		for (int ix = 0; ix < reps; ix++) {
			String line = scanner.nextLine();
			out.println(line
					+ " "
					+ distance(hex.get(valueOf(line.charAt(0))),
							hex.get(valueOf(line.charAt(2)))));
		}
	}

	private static int distance(Location loc1, Location loc2) {
		return max(max(abs(loc2.x - loc1.x), abs(loc2.y - loc1.y)), abs(loc2.z
				- loc1.z));
	}

	private static void init() {
		hex = new HashMap<>();
		// Hexes Q, F, 3, A, & T
		hex.put("Q", new Location(0, 0, 0));
		hex.put("F", new Location(0, 1, -1));
		hex.put("3", new Location(0, 2, -2));
		hex.put("A", new Location(0, 3, -3));
		hex.put("T", new Location(0, 4, -4));
		// Hexes L, H, V, C, & Y
		hex.put("C", new Location(1, 0, -1));
		hex.put("V", new Location(1, 1, -2));
		hex.put("H", new Location(1, 2, -3));
		hex.put("L", new Location(1, 3, -4));
		hex.put("Y", new Location(1, -1, 0));
		// Hexes U, R, 5, J, & M
		hex.put("U", new Location(2, 3, -5));
		hex.put("R", new Location(2, 2, -4));
		hex.put("5", new Location(2, 1, -3));
		hex.put("J", new Location(2, 0, -2));
		hex.put("M", new Location(2, -1, -1));
		// Hexes E, X, B, 8, & G
		hex.put("E", new Location(3, 2, -5));
		hex.put("X", new Location(3, 1, -4));
		hex.put("B", new Location(3, 0, -3));
		hex.put("8", new Location(3, -1, -2));
		hex.put("G", new Location(3, -2, -1));
		// Hexes W, K, Z, P, 4
		hex.put("W", new Location(4, 2, -6));
		hex.put("K", new Location(4, 1, -5));
		hex.put("Z", new Location(4, 0, -4));
		hex.put("P", new Location(4, -1, -3));
		hex.put("4", new Location(4, -2, -2));
		// Hexes 2, 6, N, D, & S
		hex.put("2", new Location(5, 1, -6));
		hex.put("6", new Location(5, 0, -5));
		hex.put("N", new Location(5, -1, -4));
		hex.put("D", new Location(5, -2, -3));
		hex.put("S", new Location(5, -3, -2));
	}

}