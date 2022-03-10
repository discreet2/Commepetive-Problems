package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashTable<K, V> {
    private int size;
    private int capacity;
    private float loadFactor;
    private List<HashNode<K, V>> bucketList;

    private static class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode next;

        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % capacity;
        return index < 0 ? index * -1 : index;
    }

    public MyHashTable() {
        this.size = 0;
        this.capacity = 5;
        loadFactor = 0.7f;
        bucketList = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
            bucketList.add(null);
    }

    public MyHashTable(int size, int capacity, float loadFactor) {
        this.size = size;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        for (int i = 0; i < capacity; i++)
            bucketList.add(null);
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketList.get(bucketIndex);

        while (head != null) {
            if (head.hashCode == hashCode && head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        HashNode<K, V> hn = new HashNode<>(key, value, hashCode);
        head = bucketList.get(bucketIndex);
        hn.next = head;
        bucketList.set(bucketIndex, hn);

        if (size / capacity >= loadFactor) {
            System.out.println("resizing");
            List<HashNode<K, V>> temp = bucketList;
            bucketList = new ArrayList<>();
            size = 0;
            capacity = 2 * capacity;
            for (int i = 0; i < capacity; i++)
                bucketList.add(null);
            for (HashNode<K, V> node : temp) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public String toString() {
        int max = size() - 1;
        if (max == -1)
            return "{}";

        StringBuilder sb = new StringBuilder();

        sb.append('{');
        for (HashNode<K, V> node : bucketList) {
            while (node != null) {
                K key = node.key;
                V value = node.value;
                sb.append(key == this ? "(this Map)" : key.toString());
                sb.append('=');
                sb.append(value == this ? "(this Map)" : value.toString());
                sb.append(", ");
                node = node.next;
            }
        }
        return sb.append('}').toString();
    }

    public V get(K key) {
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketList.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketList.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) return null;
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketList.set(bucketIndex, head.next);
        }
        return head.value;
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> map = new MyHashTable<>();
        map.put("this", 1);
        System.out.println(map);
        map.put("coder", 2);
        System.out.println(map);
        map.put("this", 4);
        System.out.println(map);
        map.put("hi", 5);
        System.out.println(map);
        map.put("dumb", 7);
        System.out.println(map);
        map.put("fuck", 8);
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
