package sept8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Morphing {
	public static ArrayList<String> visited = new ArrayList<String>();
	public static Map<String, String> map = new HashMap<String, String>();
	public static boolean found = false;
	
	
	public static Map<String, String> search (Graph graph, String first, String second) {
		
		
		/* get Adjacent List */
		String[] startinglist = graph.searchNode(first);
		
		while (startinglist.length != 0){
			visited.add(first);
			map.put(null, first);
			for (int i = 0; i < startinglist.length; i++){
				visited.add(startinglist[i]);
				map.put(first, startinglist[i]);
				searchNode(graph, startinglist[i], second);
			}
		}
		if (found)
			return map;
		else 
			return null;
	}
	
	public static void searchNode (Graph graph, String input, String second){
		if (graph == null){
			found = false;
		}
		for (String s: graph.searchNode(input)){
			
			if(s.equals(second)){
				map.put(input, second);
				found = true;
				
			}
			
			if(visited.contains(s))
				return;
			visited.add(s);
			map.put(input,s);
			searchNode(graph, s, second);
		}
	}
}
