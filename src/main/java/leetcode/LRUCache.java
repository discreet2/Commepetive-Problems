package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    //https://leetcode.com/problems/lru-cache/
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache);
        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println(lRUCache);
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache);
        lRUCache.get(1);    // return 1
        System.out.println(lRUCache);
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache);
        lRUCache.get(2);    // returns -1 (not found)
        System.out.println( lRUCache.get(2));
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache);
        lRUCache.get(1);    // return -1 (not found)
        System.out.println(lRUCache.get(1));
        lRUCache.get(3);    // return 3
        System.out.println(lRUCache);
        lRUCache.get(4);    // return 4
        System.out.println(lRUCache);

    }

    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                '}';
    }
}
