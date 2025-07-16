
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class FindAllAnagramINString {
    public static void main(String[] args){
        String s="cbaebabacd";
        String p="abc";
        Solution sol = new Solution();
        List<Integer> ans=sol.findAnagrams(s, p);
        System.out.println(" Anagram indices :" +ans);
        
    }
}
    class Solution{
      public  List<Integer> findAnagrams(String s, String p){
          List<Integer> result=new ArrayList<>();
          if(s.length()<p.length()) return result;
            int[] scount=new int[26];
            int[] pcount=new int[26];


      // find pattern frequency
      for(char ch : p.toCharArray()){
        pcount[ch - 'a']++;
      }
    // first window
     for(int i=0;i<p.length();i++){
        scount[s.charAt(i)-'a']++;
     }
     // check first window
    if(Arrays.equals(pcount,scount)){
        result.add(0);
    }

    // slide the window
    for(int i=p.length();i<s.length();i++){
        // add new character
        scount[s.charAt(i) - 'a']++;
        // remove leftmost character
        scount[s.charAt(i-p.length())-'a']--;

        // compare 
        if(Arrays.equals(pcount,scount)){
            result.add(i-p.length()+1);
        }
    }
    return result;
    }
    
}
