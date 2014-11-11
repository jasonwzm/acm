package sept15;

import java.util.Scanner;

public class Path {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		int configNum = scanner.nextInt();
		while (configNum > 0){
			int cityNum = scanner.nextInt();
			while (cityNum > 0){
				String[][] elements = new String[cityNum][cityNum];
				String line;
				int currentline = 0;
				while (currentline < cityNum){
					for (int i = 0; i < cityNum; i++){
						line = scanner.next();
						elements[currentline][i] = line;
					}
					currentline++;
				}
				
				cityNum--;
			}
			configNum--;
		}
		System.out.println("END OF OUTPUT");
	}
}
