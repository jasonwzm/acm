package oct20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Oldies {
	public static void main (String[] args){
		LinkedList<String> ll = new LinkedList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= num; i++){
			String line = sc.nextLine();
			ll.add(line);
			map.put(line, 0);
		}
		int total = 0;
		while (sc.hasNextLine()){
			total++;
			String curr = sc.nextLine();
			ll.remove(curr);
			int time = map.get(curr);
			map.put(curr, ++time);
			ll.push(curr);
		}
		while (!ll.isEmpty()){
			String object;
			System.out.print(object=ll.pop());
			System.out.print("     ");
			System.out.println(map.get(object));
		}
		System.out.println("---------------");
		System.out.println("total:     "+total);
	}
}
