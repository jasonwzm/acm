package ping;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static String[] input;
	
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		while (!line.equals("0")){
			input = line.split("");
			System.out.println(detect(input));
		}
	}
	
	public static ArrayList detect(String[] input){
		ArrayList array = new ArrayList();
		boolean odd = true;
		if (input[0] == "0"){
			odd = false;
		}
		
		return array;
	}
}
