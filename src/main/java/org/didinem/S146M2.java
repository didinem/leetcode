package org.didinem;

import java.util.HashMap;

/**
 * Created by zhongzhengmin on 2018/3/2.
 */
public class S146M2 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));        // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));        // returns -1 (not found)
        System.out.println(cache.get(3));         // returns 3
        System.out.println(cache.get(4));        // returns 4

//        cache.put(2, 1);
//        cache.put(1, 1);
//        cache.put(2, 3);
//        cache.put(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
    }

    private static class LRUCache {

        private HashMap<Integer, Node> map;

        private int capacity;

        private int size;

        private Node head;

        private Node tail;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            size = 0;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            remove(node);
            insertToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            Node oldNode = map.put(key, node);
            if (oldNode != null) {
                remove(oldNode);
                insertToTail(node);
                return;
            }
            if (++size > capacity) {
                map.remove(head.key);
                remove(head);
                size--;
            }
            insertToTail(node);
        }

        private void remove(Node node) {
            Node prevNode = node.prevNode;
            Node nextNode = node.nextNode;
            prevNode.nextNode = nextNode;
            nextNode.prevNode = prevNode;
            node.prevNode = null;
            node.nextNode = null;

            if (head == node) {
                head = nextNode;
            } else if (tail == node) {
                tail = prevNode;
            }
        }

        private void insertToTail(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                node.prevNode = node;
                node.nextNode = node;
                return;
            }

            tail.nextNode = node;
            node.prevNode = tail;
            head.prevNode = node;

            tail = node;
            node.nextNode = head;
        }

        private static class Node {
            int key;
            int value;

            Node prevNode;
            Node nextNode;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    }

}
