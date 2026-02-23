import java.util.*;
import java.util.regex.*;
public class textAnalyser {

//Normalise text
//word frequency
//Longest substring without repeating characters;
//anagram
//top-k frequent words

    public String normaliseText(String text) {
        text = text.toLowerCase(Locale.ROOT); //prevents bugs in some languages like turkish
        text = text.replaceAll("\\p{Punct}", " ");
        text = text.replaceAll("\\s+", " ").trim();
        return text;
    }

    public HashMap<String, Integer> wordFrequency(String text) {
        text = normaliseText(text);
        String[] arr = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;

    }

    public String longest_substring(String text) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int n = text.length();
        int start = 0;
        int maxlen = 0;
        for (int r = 0; r < n; r++) {
            while(set.contains(text.charAt(r))) {
                set.remove(text.charAt(l));
                l++;
            }
            set.add(text.charAt(r));
            if (r - l + 1 > maxlen) {
                maxlen = r - l + 1;
                start = l;
            }
        }
        return text.substring(start, start + maxlen);
    }


    public boolean anagramCheck(String t1, String t2) {
        t1=normaliseText(t1).replace(" ","");
        t2=normaliseText(t2).replace(" ","");
        int n1 = t1.length();
        int n2 = t2.length();
        if (n1 != n2) return false;
        return freqCheck(t1, n1).equals(freqCheck(t2, n2));

    }

    private static HashMap<Character, Integer> freqCheck(String s, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character word = s.charAt(i);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }


    public List<String> freqWords(String s,int k){
     PriorityQueue<Map.Entry<String,Integer>> minheap= new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
        HashMap<String,Integer> map=wordFrequency(s);
     for(Map.Entry<String,Integer> entry: map.entrySet()){
         minheap.offer(entry);
         if(minheap.size()>k){
           minheap.poll();
         }
        }
     List<String> result= new ArrayList<>();
     while(!minheap.isEmpty()){
         result.add(minheap.poll().getKey());
     }
     Collections.reverse(result);
 return result;
    }



}