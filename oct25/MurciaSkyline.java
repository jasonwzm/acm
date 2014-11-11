package oct25;

import java.util.Arrays;
import java.util.Scanner;

public class MurciaSkyline {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int cases = Integer.parseInt(line);
		for (int i = 0; i < cases; i++){
			line = scanner.nextLine();
			int number = Integer.parseInt(line);
			String[] height = scanner.nextLine().split(" ");
			String[] length = scanner.nextLine().split(" ");
			System.out.println(dpLIS(number, height, length));
		}
	}
	public static int dpLIS(int number, String[] height, String[] length){
		int[] array = new int[number];
		int max = 0;
		for (int k = 1; k < number; k++){
			int localmax = 0;
			for (int j = 0; j <= k; j++){
				if (Integer.parseInt(height[k]) > Integer.parseInt(height[j])){
					if (array[j] > localmax){
						localmax = array[j];
					}
					array[k] = localmax + 1;
				}
			}
			for (int i = 0; i < number; i++){
				if (array[i] > max){
					max = array[i];
				}
			}
		}
		return max;
	}
	
	public static int dpLDS(int number, String[] height, String[] length){
		int[] array = new int[number];
		int max = 0;
		for (int k = 0; k < number; k++){
			int localmax = 0;
			for (int j = 0; j <= k; j++){
				if (Integer.parseInt(height[k]) < Integer.parseInt(height[j])){
					if (array[j] > localmax){
						localmax = array[j];
					}
					array[k] = localmax + 1;
				}
			}
			for (int i = 0; i < number; i++){
				if(array[i] > max){
					max = array[i];
				}
			}
		}
		return max;
	}
	
	public static int dp(String[] seq){
		
		    int[]L=new int[seq.length];
		    L[0]=1;
		    for(int i=1;i<L.length;i++){
		      int maxn=0;
		      for(int j=0;j<i;j++){
		        if(seq[j]<seq[i]&&L[j]>maxn){
		          maxn=L[j];
		        }
		      }
		      L[i]=maxn+1;
		    }
		    int maxi=0;
		    for(int i=0;i<L.length;i++){
		      if(L[i]>maxi){
		        maxi=L[i];
		      }
		    }
		    return(maxi);
		  
	}
}
