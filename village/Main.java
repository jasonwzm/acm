package village;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		while (!line.equals("0 0 0")){
			int village = Integer.parseInt(line.split(" ")[0]);
			int road = Integer.parseInt(line.split(" ")[1]);
			int action = Integer.parseInt(line.split(" ")[2]);
			int[][] adjacency = new int[village][village];
			for (int i = 0; i < road; i++){
				String roadline = scanner.nextLine();
				int first = Integer.parseInt(roadline.split(" ")[0]);
				int second = Integer.parseInt(roadline.split(" ")[1]);
				adjacency[first-1][second-1] = 1;
				adjacency[second-1][first-1] = 1;
			}
			ArrayList<Integer> trade = new ArrayList<Integer>();
			ArrayList<Integer> increase = new ArrayList<Integer>();
			for (int j = 0; j < action; j++){
				String actionline = scanner.nextLine();
				if (actionline.startsWith("+")){
					trade.add(Integer.parseInt(actionline.split(" ")[1]));
					increase.add(Integer.parseInt(actionline.split(" ")[2]));
				}
				else {
					int question = Integer.parseInt(actionline.split(" ")[1]);
					System.out.println(calculate(adjacency, trade, increase, question));
				}
			}
			line = scanner.nextLine();
		}
	}
	public static int calculate(int[][] adjacency, ArrayList<Integer> trade, ArrayList<Integer> increase, int question){
		int result = 0;
		int[] revenue = new int[adjacency.length];
		for (int i = 0; i < trade.size(); i++){
			revenue[(int)(trade.get(i))-1] += increase.get(i);
			for (int j = 0; j < adjacency.length; j++){
				if (dfs(adjacency, trade.get(i)-1, j)){
					revenue[j] += increase.get(i);
				}
			}
		}
		return result;
	}
	public static boolean dfs(int[][] adjacency, int start, int end){
		for (int i = 0; i < adjacency.length; i++){
			if (adjacency[start][i] == 1){
				dfs(adjacency, i, end);
			}
		}
	}
}
