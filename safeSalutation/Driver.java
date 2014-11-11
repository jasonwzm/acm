package safeSalutation;

import java.util.Scanner;
import java.io.File;

public class Driver {
	public static void main(String[] arg){
		Scanner sc = null;
		try{sc = new Scanner(new File("testSal.txt"));}
		catch(Exception ex){System.out.println("File not found");}
		while (sc.hasNextInt()){
			System.out.println(shake(sc.nextInt()));
		}
	}
	public static int shake(int n){
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		int out = 0;
		for(int i = 0; i < n; i++)
			out += shake(i)*shake(n - i - 1);
		return out;
	}
}
