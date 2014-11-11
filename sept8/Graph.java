package sept8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Graph {
 
            private Map<String, String[]> map = new HashMap<String, String[]>();
            private List<String> words;
           
            public Graph(List<String> words) {
                        this.words = words;
                       
                        for (String word: words) {
                                    List<String> adjs = new ArrayList<String>();
                                   
                                    for (String adj: words) {
                                                if (adj.equals(word)) continue;
                                                if (isAlmost(adj, word)) {
                                                            adjs.add(adj);
                                                }
                                    }
                                   
                                    map.put(word, adjs.toArray(new String[0]));
                        }
            }
           
            public static boolean isAlmost(String a, String b) {
                        int diffs = 0;
                        for (int i=0; i<a.length(); i++) {
                                    if (a.charAt(i) != b.charAt(i)) diffs++;
                        }
                        return diffs == 1;
            }
           
            public String[] searchNode(String s) {
                        return map.get(s);
            }
           
           
}