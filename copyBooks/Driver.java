package copyBooks;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Driver {
	public static void main(String[] arg){
		Scanner sc = null;
		try{sc = new Scanner(new File("testBook.txt"));}
		catch(Exception ex){System.out.println("File not found");}
		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			int books = sc.nextInt();
			int scribes = sc.nextInt();
			int[] pages = new int[books];
			for(int j = 0; j < books; j++)
				pages[j] = sc.nextInt();
			System.out.println(part(pages, 0, scribes));
			//System.out.println(Integer.MAX_VALUE);
		}
	}
	public static ArrayList<Integer> part(int[] arr, int start, int scribes){
		if (scribes == 1){
			return new ArrayList<Integer>();
		}
		int total = 0;
		for(int i = start; i < arr.length; i++)
			total += arr[i];
		total /= scribes;
		int i = start;
		int sTotal = 0;
		while (sTotal + arr[i] <= total){
			sTotal += arr[i++];
		}
		ArrayList<Integer> out = new ArrayList<Integer>();
		out.add(i);
		out.addAll(part(arr, i, scribes - 1));
		return out;
	}
	//arraylist contains max pages caused by following partition in first element
	//start is first element of interest
	//end points off of set of interest
	/*
	public static ArrayList<Integer> part(int[] arr, int start, int end, int scribes){
		ArrayList<Integer> out = new ArrayList<Integer>();
		if (scribes == 1){
			int total = 0;
			for(int i = start; i < end; i++)
				total += arr[i];
			out.add(total);
			return out;
		}
		out.add(Integer.MAX_VALUE);
		for(int i = start + 1; i < end; i++){
			for(int j = 1; j < scribes - 1; j++){
				if (j < i - start && scribes - 1 - j < end - i){
					ArrayList<Integer> left = part(arr, start, i, j);
					ArrayList<Integer> right = part(arr, i, end, scribes - 1 - j);
					ArrayList<Integer> comb = new ArrayList<Integer>();
					if (left.get(0) > right.get(0)){
						comb.add(left.get(0));
					}
					else{
						comb.add(right.get(0));
					}
					left.remove(0);
					comb.addAll(left);
					comb.add(i);
					right.remove(0);
					comb.addAll(right);
					if (comb.get(0) < out.get(0))
						out = comb;
				}
			}
		}
		return out;
	}*/
}
