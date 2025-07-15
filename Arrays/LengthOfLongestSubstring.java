import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args){
        String s="abcabcbb";
        int  length=lengthofstring(s);
        System.out.println("Length Of Longest Substring: "+ length);

    }
    public static int lengthofstring(String s){
        int start=0;
        int maxlength=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int end=0; end<s.length();end++){
            char currentch=s.charAt((end));
            if(map.containsKey((currentch))){
                start=Math.max(start,map.get(currentch) + 1);
            }
            map.put(currentch,end);
            maxlength=Math.max(maxlength,end-start+1);
        }
        return maxlength;


    }
    
}
