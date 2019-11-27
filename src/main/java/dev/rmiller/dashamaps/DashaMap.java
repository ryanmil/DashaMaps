package dev.rmiller.dashamaps;

import java.util.function.Function;

public class DashaMap {

    private Function<String, Integer> hash;
    private Node[] nodeArray;

    public DashaMap() {
        nodeArray = new Node[26];
        hash = HashFuntions::hashFunctionOne;
    }

    public DashaMap(Function<String, Integer> hash) {
        nodeArray = new Node[26];
        this.hash = hash;
    }

    public void put(String key, Integer val) {
        int hashVal = hash.apply(key);

        if (hashVal > nodeArray.length) {
            resizeArr(hashVal + 1);
        }

        if (nodeArray[hashVal] == null) {
            nodeArray[hashVal] = new Node(key, val);
        } else {
            Node node = nodeArray[hashVal];
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(key, val);
        }
    }

    public Integer get(String key) {
        Node node = nodeArray[hash.apply(key)];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.val;
            }
            node = node.next;
        }
        return null;
    }

    public boolean delete(String key) {
        int hashVal = hash.apply(key);
        if (nodeArray[hashVal] == null) {
            return false;
        } else if (nodeArray[hashVal].key.equals(key)) {
            nodeArray[hashVal]= nodeArray[hashVal].next;
            return true;
        } else {
            Node node = nodeArray[hashVal];
            while (node.next != null) {
                if (node.next.key.equals(key)) {
                    node.next = node.next.next;
                    return true;
                }
            }
            return false;
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            Node node = nodeArray[i];
            while (node != null) {
                node = node.next;
                size++;
            }
        }
        return size;
    }

    private void resizeArr(int size) {
        Node[] newArr = new Node[size];
        for (int i = 0; i < nodeArray.length; i++) {
            newArr[i] = nodeArray[i];
        }
        nodeArray = newArr;
    }

    private static class Node {
        String key;
        Integer val;
        Node next;

        Node(String key, Integer val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
}
