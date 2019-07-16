package ass1_2;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.*;

public class main {
	public static Graph buildGraph(int[][] g) {
		Graph graph = new Graph(g.length);
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				if (g[i][j] != -1) {
					graph.addEdge(i, j, g[i][j]);
				}
			}
		}
		return graph;
	}

	public static void StrategyAlgo(int size, String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String UserInput;
		int[][] g = new int[size][size];
		int k = 0;
		while ((UserInput = br.readLine()) != null) {
			String[] stringTokens = UserInput.split(",");
			g[k] = Stream.of(stringTokens).mapToInt(strToken -> Integer.parseInt(strToken)).toArray();
			k++;
		}
		Graph graph = buildGraph(g);
		System.out.println("-------MENU-------");
		System.out.println("please choose a number of the algorithm you want.");
		System.out.println("1. BFS\n2. DFS\n3. UCS\n4. DLS");
		Scanner s = new Scanner(System.in);
		int choose = s.nextInt();
		algorithm algo = null;
		if (choose == 1)
			algo = new BFS();
		if (choose == 2)
			algo = new DFS();
		if (choose == 3)
			algo = new UCS();
		if (choose == 4) {
			algo = new DLS();
		}
		algo.runAlgo(graph);
		br.close();
		s.close();
	}

	public static void main(String[] args) throws IOException {
		StrategyAlgo(6, "D:\\array.txt");
	}
}
