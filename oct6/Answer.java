package oct6;

import java.util.Scanner;

public class Answer {
	static double E = 2.718281828;
	static double PI = 3.141592654;
	static double W = 3.534;
	static double PSI = 6.104;
	static double L = 1.33387;
	public static void main(String[] arg){
		
		Scanner sc = new Scanner(System.in);
		int roomNum = sc.nextInt();
		for (int i = 0; i < roomNum; i++){
			System.out.print("OFFICE " + (i + 1) + ": ");
			int x = sc.nextInt()*sc.nextInt()*sc.nextInt();
			int furNum = sc.nextInt();
			for(int j = 0; j < furNum; j++)
				x -= (sc.nextInt()*sc.nextInt()*sc.nextInt());
			double gas = 0.6*(E*E*E*(PSI/4) + (x*x/55.0))
					+ 0.1*L*(x - W)*(x - W) + 0.3*((7.24*PI) + (69*L) - ((4*W)/2));
			if (gas > 0)
				System.out.println(String.format("%.3f GRAMS", gas));
			else
				System.out.println("0.0 GRAMS");
		}
		System.out.println("END OF OUTPUT");
	}

}