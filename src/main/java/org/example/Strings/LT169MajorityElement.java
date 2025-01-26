package org.example.Strings;

import java.util.HashMap;
import java.util.Map;

public class LT169MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxElement = 0;
        int maxOccurance = 0;
        for(Integer num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            map.putIfAbsent(num,1);
        }
     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
                maxElement = entry.getKey();
            }
        }
     return maxElement;
    }
    public static void main(String[] args) {

    }
}
