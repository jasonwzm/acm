package oct24;

import java.util.Arrays;

public class CopyBooks {
	public static void main (String[] args){
		int[] example = {100,200,300,400,500,600,700,800,900};
		System.out.println(partitionArray(example, 3));
	}
	public static int partitionArray(int[] array, int parts){
		if (parts == 1){
			int sum = 0;
			for (int a : array){
				sum += a;
			}
			return sum;
		}
		int maxSum = 0;
		int minSum = 9999999;
		while (parts > 1){
			for (int i = 0; i < array.length; i++){
				maxSum = 0;
				int[] firstPart = Arrays.copyOfRange(array, 0, i+1);
				System.out.println("First Part is :   "+Arrays.toString(firstPart));
				int firstsum = 0;
				for (int a : firstPart){
					firstsum += a;
				}
				int[] secondPart = Arrays.copyOfRange(array, i+1, array.length);
				System.out.println("Second Part is :   "+Arrays.toString(secondPart));
				maxSum = Math.max(firstsum, partitionArray(secondPart, parts-1));
				System.out.println("maxSum is :   "+maxSum);
				minSum = Math.min(maxSum, minSum);
			}
			System.out.println("minSum is :   "+minSum);
			parts--;
		}
		return minSum;
	}
}
