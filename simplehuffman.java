import java.util.*;




class Node {
    char ch;
    int freq;
    Node left, right; 


    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class SimpleHuffman {

    // Build Huffman Tree using greedy approach
    static Node buildTree(Map<Character, Integer> freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));

        // Create leaf nodes for all characters
        for (var e : freq.entrySet())
            pq.add(new Node(e.getKey(), e.getValue()));

        // Combine two smallest nodes until one root remains
        while (pq.size() > 1) {
            Node left = pq.poll(), right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        return pq.peek(); // root of Huffman tree
    }

    // Recursively print Huffman codes
    static void printCodes(Node root, String code) {
        if (root == null) return;

        // If leaf node, print the character and its code
        if (root.left == null && root.right == null)
            System.out.println(root.ch + " : " + code);

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        String text = "Huffman coding example";

        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        // Step 2: Build Huffman Tree
        Node root = buildTree(freq);

        // Step 3: Print Huffman Codes
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}

