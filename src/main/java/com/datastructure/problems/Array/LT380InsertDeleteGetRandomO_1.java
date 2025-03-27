package com.datastructure.problems.Array;

import java.util.*;

public class LT380InsertDeleteGetRandomO_1 {

    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    Random random = new Random();
    public LT380InsertDeleteGetRandomO_1() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(list.size()-1);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastElement = list.get(list.size()-1);
        map.put(idx,lastElement);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
