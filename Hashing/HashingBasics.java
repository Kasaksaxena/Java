import java.util.*;

public class HashingBasics {

    public static void main(String[] args) {

        // ==========================
        // HASHMAP
        // ==========================

        HashMap<String, Integer> map = new HashMap<>();

        // put(key, value)
        map.put("Alice", 90);
        map.put("Bob", 85);
        map.put("Charlie", 95);

        System.out.println(map);

        // get(key)
        System.out.println("Alice Marks: " + map.get("Alice"));

        // getOrDefault(key, defaultValue)
        System.out.println(map.getOrDefault("David", 0));

        // containsKey()
        System.out.println(map.containsKey("Bob"));

        // containsValue()
        System.out.println(map.containsValue(95));

        // replace value
        map.put("Bob", 88);
        System.out.println(map);

        // remove(key)
        map.remove("Charlie");
        System.out.println(map);

        // size()
        System.out.println("Size = " + map.size());

        // isEmpty()
        System.out.println(map.isEmpty());

        // keySet()
        System.out.println("\nKeys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // values()
        System.out.println("\nValues:");
        for (int value : map.values()) {
            System.out.println(value);
        }

        // entrySet()
        System.out.println("\nKey Value Pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // clear()
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(1, 100);
        temp.put(2, 200);

        System.out.println(temp);
        temp.clear();
        System.out.println(temp);



        // ==========================
        // HASHSET
        // ==========================

        HashSet<Integer> set = new HashSet<>();

        // add()
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // duplicate ignored

        System.out.println("\nHashSet:");
        System.out.println(set);

        // contains()
        System.out.println(set.contains(20));

        // remove()
        set.remove(20);
        System.out.println(set);

        // size()
        System.out.println(set.size());

        // isEmpty()
        System.out.println(set.isEmpty());

        // iterate
        System.out.println("\nElements:");
        for (int num : set) {
            System.out.println(num);
        }

        // clear()
        set.clear();
        System.out.println(set);



        // ==========================
        // FREQUENCY COUNT
        // ==========================

        int[] nums = {1,2,1,3,2,1,4};

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        System.out.println("\nFrequency Map:");
        System.out.println(freq);



        // ==========================
        // CHARACTER FREQUENCY
        // ==========================

        String s = "banana";

        HashMap<Character,Integer> charFreq = new HashMap<>();

        for(char ch : s.toCharArray()){
            charFreq.put(ch, charFreq.getOrDefault(ch,0)+1);
        }

        System.out.println(charFreq);
    }
}