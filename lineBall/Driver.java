package lineBall;

import java.util.Scanner;

public class Driver {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println();
		while (num != 0) {
			String[] array = new String[num];
			for (int i = 0; i < num; i++){
				array[i] = sc.nextLine();
			}
			System.out.println(drop(array));
			num = Integer.parseInt(sc.nextLine());
		}
	}
	public static int drop (String[] array){
		int spaceIndex = 0;
		for (int i = 0; i < array.length; i++){
			if (spaceIndex >= array[i].length()){
				continue;
			}
			while (array[i].charAt(spaceIndex) != ' '){
				spaceIndex++;
			}
		}
		return spaceIndex+1;
	}
}
