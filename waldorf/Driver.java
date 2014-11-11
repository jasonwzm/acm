package waldorf;

import java.util.Scanner;
import java.io.File;

public class Driver {
	public static void main(String[] arg){
		Scanner sc = null;
		try{sc = new Scanner(new File("testWal.txt"));}
		catch(Exception ex){System.out.println("File not found");}
		int rows = Integer.parseInt(sc.next());
		int cols = Integer.parseInt(sc.next());
		char[][] grid = new char[rows][cols];
		for(int i = 0; i < rows; i++){
			String row = sc.next();
			for(int j = 0; j < cols; j++){
				grid[i][j] = row.charAt(j);
			}
		}
		int wordNum = Integer.parseInt(sc.next());
		String[] words = new String[wordNum];
		for(int i = 0; i < wordNum; i++){
			words[i] = sc.next();
		}
		for(int i = 0; i < wordNum; i++){
			//System.out.println("Searching: " + words[i]);
			boolean found = false;
			for(int j = 0; j < rows; j++){
				for(int k = 0; k < cols; k++){
					if (Character.toUpperCase(grid[j][k]) == Character.toUpperCase(words[i].charAt(0))){
						//System.out.println(String.format("Frist found at %d, %d, %c", j, k, grid[j][k]));
						//System.out.println(String.format("%c %c %c %c %c", grid[j][k], 
						//		grid[j+1][k+1], grid[j+2][k+2], grid[j+3][k+3], grid[j+4][k+4]));
						if (isMatch(grid, j, k, words[i])){
							found = true;
							//System.out.println("Matched");
							System.out.println(String.format("%d %d", j+1, k+1));
							break;
						}
					}
				}
				if (found)
					break;
			}
		}
		//System.out.println("Done");
	}
	public static boolean isMatch(char[][] grid, int j, int k, String word){
		int len = word.length();
		boolean out;
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j + i][k]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				//System.out.println(String.format("%c", grid[j+i][k+i]));
				if (Character.toUpperCase(grid[j + i][k + i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j][k + i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j - i][k + i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j - i][k]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j - i][k - i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j][k - i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		out = true;
		try{
			for(int i = 0; i < len; i++){
				if (Character.toUpperCase(grid[j + i][k - i]) != Character.toUpperCase(word.charAt(i))){
					out = false;
					break;
				}
			}
			if (out)
				return true;
		}
		catch(ArrayIndexOutOfBoundsException ex){}
		return false;
	}
}
