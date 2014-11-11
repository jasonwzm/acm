package snowboard;

import java.util.Scanner;
import java.io.File;

public class Driver {
	static int LEFT = 0;
	static int RIGHT = 1;
	static int UP = 2;
	static int DOWN = 3;
	public static void main(String[] arg){
		Scanner sc = null;
		try{
			sc = new Scanner(new File("testSnow.txt"));
		}
		catch(Exception ex){}
		int fields = Integer.parseInt(sc.next());
		for(int i = 0; i < fields; i++){
			String name = sc.next();
			int rows = Integer.parseInt(sc.next());
			int cols = Integer.parseInt(sc.next());
			int[][] grid = new int[rows][cols];
			int[][] paths = new int[rows][cols];
			for(int j = 0; j < rows; j++)
				for(int k = 0; k < cols; k++)
					grid[j][k] = Integer.parseInt(sc.next());
			for(int j = 0; j < rows; j++){
				for(int k = 0; k < cols; k++){
					paths[j][k] = -1;
				}
			}
			for(int j = 0; j < rows; j++){
				for(int k = 0; k < cols; k++){
					setPaths(grid, paths, j, k);
				}
			}
			int out = 0;
			for(int j = 0; j < rows; j++){
				for(int k = 0; k < cols; k++){
					if (paths[j][k] > out)
						out = paths[j][k];
				}
			}
			System.out.println(String.format("%s: %d", name, out));
		}
	}
	public static boolean isMin(int[][] grid, int j, int k){
		try{
			if (grid[j][k] > grid[j][k-1])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] > grid[j][k+1])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] > grid[j+1][k])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] > grid[j-1][k])
				return false;
		}
		catch(Exception ex){}
		return true;
	}
	public static boolean isMax(int[][] grid, int j, int k){
		try{
			if (grid[j][k] < grid[j][k-1])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] < grid[j][k+1])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] < grid[j+1][k])
				return false;
		}
		catch(Exception ex){}
		try{
			if (grid[j][k] < grid[j-1][k])
				return false;
		}
		catch(Exception ex){}
		return true;
	}
	public static void setPaths(int[][] grid, int[][] paths, int j, int k){
		if (paths[j][k] != -1)
			return;
		if (isMax(grid,j,k)){
			paths[j][k] = 1;
			return;
		}
		int[] dirs = new int[4];
		try{
		if (grid[j-1][k] > grid[j][k]){
			if (paths[j-1][k] == -1)
				setPaths(grid, paths, j-1,k);
			dirs[0] = paths[j-1][k] + 1;
		}
		}
		catch(Exception ex){}
		try{
		if (grid[j+1][k] > grid[j][k]){
			if (paths[j+1][k] == -1)
				setPaths(grid, paths, j+1,k);
			dirs[1] = paths[j+1][k] + 1;
		}
		}
		catch(Exception ex){}
		try{
		if (grid[j][k-1] > grid[j][k]){
			if (paths[j][k-1] == -1)
				setPaths(grid, paths, j,k-1);
			dirs[2] = paths[j][k-1] + 1;
		}
		}
		catch(Exception ex){}
		try{
		if (grid[j][k+1] > grid[j][k]){
			if (paths[j][k+1] == -1)
				setPaths(grid, paths, j,k+1);
			dirs[3] = paths[j][k+1] + 1;
		}
		}
		catch(Exception ex){}
		paths[j][k] = Math.max(dirs[0], Math.max(dirs[1], Math.max(dirs[2], dirs[3])));
	}
}
